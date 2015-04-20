package kr.co.crewmate.site.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import kr.co.crewmate.site.model.ToString;
import kr.co.crewmate.site.model.common.Differ;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * 
 * 클래스명: <code>DifferUtils</code>
 *
 * <pre>
 *  두개의 모델을 서로 비교하는 유틸 
 *  모델의 각 필드명을 기준으로 비교한다.
 *  모델의 필드에 객체일때는 TOString을 이용해서 비교하게 된다.
 *  
 *  현 시스템에서는 회원/주문/상품에 관련된 
 *  히스토리를 남기는데 사용된다.
 *  
 *  싱글톤으로 구현되어있다.
 * </pre>
 *
 * @author 이경연
 * @date 2012. 1. 9.
 *
 */
public class DifferUtils {

    final Log log = LogFactory.getLog(this.getClass());

    /**
     * 비교대상의 논리 정보를 가지고있는 xml
     */
    private final static String CONFIG_FILE_NAME = "differ.xml";

    private static DifferUtils instance;

    private final static Object o = new Object();

    /**
     * 비교대상 데이터를 가지고있게 되는 맵
     */
    private Map<String, DiffItem> keys;

    private DifferUtils() throws IOException {
        FieldNameXmlParser parser = new FieldNameXmlParser();
        keys = new HashMap<String, DiffItem>();
        parser.parse(this.getClass().getResourceAsStream(CONFIG_FILE_NAME), keys);
    }

    /**
     * <pre>
     *  싱글톤 인스턴스를 반환하는 메소드
     * </pre>
     * @return
     */
    public static DifferUtils getInstance() {
        if (instance == null) {
            synchronized (o) {
                try {
                    instance = new DifferUtils();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return instance;
    }

    /**
     * <pre>
     *  두개의 오브젝트를 비교하여 비교결과를 
     *  리스트로 반환하는 메소드
     *  
     *  히스토리 목록을 저장하다가 오류가나는것을 
     *  방지하기위해 모든 오류는 내부적으로 처리하지않는다.
     * </pre>
     * @param o
     * @param n
     * @return
     */
    public List<Differ> diff(Object o, Object n) {
        List<Differ> differs = new ArrayList<Differ>();
        Method[] methods = o.getClass().getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (this.keys.containsKey(methodName)) {
                try {
                    Object value1 = method.invoke(o, new Object[] {});
                    Method changeMethod = n.getClass().getMethod(methodName);
                    if (changeMethod != null) {
                        Object value2 = changeMethod.invoke(n, new Object[] {});
                        Differ differ = this.guessDiffer(value1, value2, methodName);
                        differs.add(differ);
                    }
                } catch (IllegalArgumentException e) {
                    continue;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (SecurityException e) {
                    continue;
                } catch (NoSuchMethodException e) {
                    continue;
                } catch (SameValueException e) {
                    continue;
                } catch (DiffClassException e) {
                    continue;
                }
            }
        }

        return differs;
    }

    /**
     * <pre>
     *  서로같은 데이터인지 비교한다 
     *  하지만 이것은 타입이나 모든면에서 서로다를수있으므로 
     *  일정한 패턴으로 예측하는 수준에서 처리한다.
     * </pre>
     * @param value1
     * @param value2
     * @param methodName
     * @return
     */
    private Differ guessDiffer(Object value1, Object value2, String methodName) {
        if (value1 == null && value2 == null) {
            throw new SameValueException("Both Null");
        }

        if (value1 == null && StringUtils.isBlank(value2.toString())) {
            throw new SameValueException("Both Null");
        } else if (value2 == null && StringUtils.isBlank(value1.toString())) {
            throw new SameValueException("Both Null");
        } else if ((value1 == null && value2 != null) || (value1 != null && value2 == null)) {
            // ignore 
        } else if (value1.equals(value2)) {
            throw new SameValueException("Same");
        } else if (!value1.getClass().equals(value2.getClass())) {
            throw new DiffClassException(String.format("[%s][%s]", value1.getClass(), value2.getClass()));
        }

        Differ differ = new Differ();
        DiffItem diffItem = this.keys.get(methodName); 
        differ.setField(diffItem.getPysicalName());
        differ.setFieldName(diffItem.getLogicalName());
        differ.setOldFieldValue(value1 == null ? null : value1.toString());
        differ.setNewFieldValue(value2 == null ? null : value2.toString());

        return differ;
    }

    @SuppressWarnings("serial")
    static class DiffClassException extends RuntimeException {
        public DiffClassException(String message) {
            super(message);
        }
    }

    @SuppressWarnings("serial")
    static class SameValueException extends RuntimeException {
        public SameValueException(String message) {
            super(message);
        }
    }
    
    /**
     * 클래스명: <code>DiffItem</code>
     *
     * <pre>
     *  아이템정보를 가지게 되는 클래스 
     *  
     * </pre>
     *
     * @author 이경연
     * @date 2012. 5. 21.
     *
     */
    @SuppressWarnings("serial")
    static class DiffItem extends ToString { 
        private String key;
        
        private String pysicalName;
        
        private String logicalName;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getPysicalName() {
            return pysicalName;
        }

        public void setPysicalName(String pysicalName) {
            this.pysicalName = pysicalName;
        }

        public String getLogicalName() {
            return logicalName;
        }

        public void setLogicalName(String logicalName) {
            this.logicalName = logicalName;
        }
    }
    
    /**
     * 클래스명: <code>FieldNameXmlParser</code>
     *
     * <pre>
     *  필드명따위를 저장하는 xml을 처리하는 파서
     *  differ.xml을 처리하여 저장하는 파서
     * </pre>
     *
     * @author 이경연 
     * @date 2012. 1. 9.
     *
     */
    static class FieldNameXmlParser {
        
        private final String prefix1 = "get";

        private final String prefix2 = "is";
        
        public void parse(InputStream resourceAsStream, Map<String, DiffItem> keys) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            
            
            Object result = null;
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document xmlDoc = builder.parse(resourceAsStream);
                XPathFactory xPathFactory = XPathFactory.newInstance();
                XPath xPath = xPathFactory.newXPath();
                XPathExpression expr = xPath.compile("/root/entry");
                result = expr.evaluate(xmlDoc, XPathConstants.NODESET);
            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            } catch (SAXException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (XPathExpressionException e) {
                throw new RuntimeException(e);
            }
            
            NodeList xmlitems = (NodeList)result;
            for (int i = 0; i < xmlitems.getLength(); i++) {
                Node node = xmlitems.item(i);
                DiffItem item = new DiffItem();
                NamedNodeMap attributeMap = node.getAttributes();
                {
                    String key = getAttributeValue(attributeMap, "key");
                    String pysicalName = getAttributeValue(attributeMap, "field");
                    String logicalName = node.getTextContent();
                    if (key == null) {
                        continue;
                    } else {
                        item.setKey(key);
                        item.setPysicalName(pysicalName);
                        item.setLogicalName(logicalName);
                        String[] methodNames = gussMethodNames(key);
                        for (String methodName: methodNames) {
                            keys.put(methodName, item);
                        }
                    }
                }
            }
        }

        private String getAttributeValue(NamedNodeMap attributeMap, String key) {
            Node node = attributeMap.getNamedItem(key);
            return node == null ? null : attributeMap.getNamedItem(key).getNodeValue();
        }
        
        private String[] gussMethodNames(String key) {
            StringBuilder bufferGet = new StringBuilder(key.length() + prefix1.length());
            StringBuilder bufferIs = new StringBuilder(key.length() + prefix2.length());
            char first = Character.toUpperCase(key.charAt(0));
            bufferGet.append(prefix1);
            bufferGet.append(first);
            bufferIs.append(prefix2);
            bufferIs.append(first);
            for (int i = 1; i < key.length(); i++) {
                char ch = key.charAt(i);
                bufferGet.append(ch);
                bufferIs.append(ch);
            }

            return new String[] { bufferGet.toString(), bufferIs.toString() };
        }
    }    
}
