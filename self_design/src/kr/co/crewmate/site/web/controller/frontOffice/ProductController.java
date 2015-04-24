package kr.co.crewmate.site.web.controller.frontOffice;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.crewmate.site.model.CommonCode;
import kr.co.crewmate.site.model.Design;
import kr.co.crewmate.site.model.DesignCriteria;
import kr.co.crewmate.site.model.Product;
import kr.co.crewmate.site.model.ProductParam;
import kr.co.crewmate.site.model.Text;
import kr.co.crewmate.site.model.product.ProductCriteria;
import kr.co.crewmate.site.model.user.UserCriteria;
import kr.co.crewmate.site.service.CommonCodeService;
import kr.co.crewmate.site.service.DesignService;
import kr.co.crewmate.site.service.ProductService;
import kr.co.crewmate.site.web.controller.FrontOfficeController;
import kr.co.crewmate.utils.DateUtil;
import kr.co.crewmate.utils.TextToImage;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

/**
 *
 * 클래스명: <code>UserController</code>
 *
 * <pre>
 *  회원가입 담당 컨트롤러
 * </pre>
 *
 * @author 남세건
 * @date 2013. 6. 21.
 *
 */
@Controller
public class ProductController extends FrontOfficeController {

    final Log log = LogFactory.getLog(this.getClass());

    @Inject
    private CommonCodeService commonCodeService;

    @Inject
    private DesignService designService;

    @Inject
    private ProductService productService;

    private static String DESIGN_PRICE = "PRICE";//디자인 상품의 금액별 리스트

    private static String DESIGN = "DESIGN";//디자인 상품의 카테고리

    private static String CATALOG = "CATALOG";//상품의 카달로그

    private static String TOPIC = "TOPIC";//상품의 카테고리


    @RequestMapping("/make_product")
    public ModelAndView makeProduct(ModelMap model, ProductCriteria criteria) {
//    	return new ModelAndView("frontoffice/main/viewMain");
    	return new ModelAndView("frontoffice/product");
    }

    @RequestMapping("/product")
    public ModelAndView product(ModelMap model, UserCriteria criteria) {
    	return new ModelAndView("frontoffice/product");
    }

    /**
     * 상품 위젯 > 전체 상품 리스트(이미지 포함)
     * @param model
     * @param param
     * @return
     */
    @RequestMapping("/product/productList")
    public View baseProducts(ModelMap model, ProductParam param) {

    	if(!StringUtils.isEmpty(param.getTopic())) {
    		param.setCategory(param.getTopic());
    	}

    	List<Product> list = this.productService.getProductList(param);

    	model.addAttribute("data", list);
    	return new MappingJacksonJsonView();
    }

    /**
     * 디자인 위젯 > 디자인 카테고리 리스트
     * @param model
     * @return
     */
    @RequestMapping("/product/category")
    public View designCategory(ModelMap model) {
    	CommonCode codeClass = new CommonCode(DESIGN);

    	List<CommonCode> list = this.commonCodeService.getCommonCode(codeClass);

    	model.addAttribute("data", list);
    	return new MappingJacksonJsonView();

    }

    /**
     * 디자인 위젯 > 디자인 가격 리스트
     * @param model
     * @return
     */
    @RequestMapping("/product/getCommonData")
    public View getCommonData(ModelMap model) {
    	CommonCode codeClass = new CommonCode();
    	codeClass.setCodeClass(DESIGN_PRICE);

    	List<CommonCode> list = this.commonCodeService.getCommonCode(codeClass);

    	model.addAttribute("data", list);
    	return new MappingJacksonJsonView();
    }

    /**
     * type - TY001 : 유료
     *        TY002 : 무료
     *        TY003 : 사용자 추가 이미지
     * @param model
     * @param param
     * @return
     */
    @RequestMapping("/product/designs")
    public View designs(ModelMap model, DesignCriteria param) {

    	if(StringUtils.equals(param.getType(), "TY001")) {
    		param.setPremiumYn("Y");
    	} else if(StringUtils.equals(param.getType(), "TY002")) {
    		param.setPremiumYn("N");
    	} else {

    	}

    	if(!StringUtils.isEmpty(param.getDesign())) {
    		param.setCategory(param.getDesign());
    	}

    	List<Design> list = this.designService.getDesignList(param);

    	model.addAttribute("data", list);
    	return new MappingJacksonJsonView();
    }

    /**
     * 상품 위젯 > 카달로그 리스트
     * @param model
     * @return
     */
    @RequestMapping("/product/catalogs")
    public View catalogs(ModelMap model) {
    	CommonCode codeClass = new CommonCode();
    	codeClass.setCodeClass(CATALOG);

    	List<CommonCode> list = this.commonCodeService.getCommonCode(codeClass);

    	model.addAttribute("data", list);
    	return new MappingJacksonJsonView();

    }

    /**
     * 상품 위젯 > 카테고리 리스트
     * @param model
     * @return
     */
    @RequestMapping("/product/topics")
    public View topics(ModelMap model) {
    	CommonCode codeClass = new CommonCode();
    	codeClass.setCodeClass(TOPIC);

    	List<CommonCode> list = this.commonCodeService.getCommonCode(codeClass);

    	model.addAttribute("data", list);
    	return new MappingJacksonJsonView();
    }


    @RequestMapping("/make_product/base_product/{productId}")
    public View baseProduct(ModelMap model, @PathVariable("productId") String productId) {
    	ProductParam param = new ProductParam();
    	param.setProductId(productId);

    	Product product = this.productService.getProductDetail(param);

    	model.addAttribute("data", product);
    	return new MappingJacksonJsonView();
    }


    @RequestMapping("/cart")
    public View getCommonData(ModelMap model, String json) {
//    	String str = "{\"baskets\":[{\"id\":99110,\"priceId\":99572,\"session_key\":\"\",\"base_productName_en\":null,\"base_productName_ko\":\"특양면 맨투맨\",\"productId\":99572,\"base_productId\":21,\"name\":\"상품 만들기 제품\",\"quantity\":10,\"color\":\"ffffff\",\"point\":200,\"type\":\"TY002\",\"size\":\"S(85)\",\"price_ko\":22000,\"price_en\":0,\"filepath\":\"/up/product/99572_product_image_FT001.png\"}]}";
    	//baskets: 만 제거된 array 형식으로
    	String str = "[{\"id\":99110,\"priceId\":99572,\"session_key\":\"\",\"base_productName_en\":null,\"base_productName_ko\":\"특양면 맨투맨\",\"productId\":99572,\"base_productId\":21,\"name\":\"상품 만들기 제품\",\"quantity\":10,\"color\":\"ffffff\",\"point\":200,\"type\":\"TY002\",\"size\":\"S(85)\",\"price_ko\":22000,\"price_en\":0,\"filepath\":\"/up/product/99572_product_image_FT001.png\"}]";

    	Object jsonarray = JSONValue.parse(str);
    	JSONArray products = (JSONArray)jsonarray;

    	model.addAttribute("data", products);
    	return new MappingJacksonJsonView();
    }

    /**
     * 텍스트 위젯 > 텍스트 표시
     * @param model
     * @param request
     * @param response
     * @param text
     * @return
     */
    @RequestMapping("/mygm/text")
    public View text(ModelMap model, HttpServletRequest request, HttpServletResponse response, Text text) {

    	boolean crateFile = false;
    	String fileName = "text_" + super.getLoginUser().getUser().getAliasId() + DateUtil.getTimestamp();
    	text.setFilePath(request.getSession().getServletContext().getRealPath("/up/text/"));
    	text.setFileName(fileName);

    	try {
    		crateFile = TextToImage.createImage(text);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

    	text = new Text();
    	Text data = new Text();
    	data.setPath("/up/text/" + fileName);

    	model.addAttribute("data", data);
    	return new MappingJacksonJsonView();
    }
}
