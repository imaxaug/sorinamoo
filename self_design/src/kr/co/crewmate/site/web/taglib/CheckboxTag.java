package kr.co.crewmate.site.web.taglib;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.VelocityContext;

/**
 * 
 * 클래스명: <code>CheckboxTag</code>
 *
 * <pre>
 *  CustomTagSupport의 기능을 상속받는다.
 *   
 *  ex) &lt;ui:checkbox name="check2" key="orderStatCode" value="10, 30" clazz="check_class" except="100"/&gt;
 * </pre>
 *
 * @author newstar
 * @date 2011. 11. 9.
 *
 */
@SuppressWarnings("serial")
public class CheckboxTag extends CustomTagSupport {


    /**
     * 선택되어지는 값
     */

    private static final String CHECKBOX_TEMPLATE_NAME = "checkboxTag.vm";


    private String[] valuearray = null ;
    
    
    private String before ; 
    private String mid ; 
    private String after ; 
    
    public CheckboxTag() {
        setTagFileName(CHECKBOX_TEMPLATE_NAME);
    }
    
    @Override
    public VelocityContext setMoreContextData(VelocityContext context) {

        context.put("before", this.before);
        context.put("mid", this.mid);
        context.put("after", this.after);
        
        String value = super.getValue(); 

        String[] values = null ; 
        if(value != null){
            values = value.split(",");
        }
        if (valuearray != null) { 
            values =  valuearray ;  
        }
        
        if (values != null) {
            
            Map<String, String> valueMap = new HashMap<String, String>();
            for (String key : values) {
                valueMap.put(key.trim(), "");
            }

            context.put("value", valueMap);
        } 
        
        return context;
    }
    
    
    public String[] getValuearray() {
        return valuearray;
    }

    public void setValuearray(String[] valuearray) {
        this.valuearray = valuearray;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    
    

}
