package kr.co.crewmate.site.web.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;






import kr.co.crewmate.site.config.Config;
import kr.co.crewmate.site.exceptions.UserNotFoundException;
//import kr.co.crewmate.site.model.display.DisplayCriteria;
//import kr.co.crewmate.site.model.display.DisplayEntityData;
//import kr.co.crewmate.site.model.display.MainDisplay;
//import kr.co.crewmate.site.model.main.MainDisplayData;
//import kr.co.crewmate.site.model.main.MainHtml;
//import kr.co.crewmate.site.service.FrontDisplayService;
//import kr.co.crewmate.site.service.MainDisplayService;
import kr.co.crewmate.site.model.ListResult;
import kr.co.crewmate.site.model.LoginUser;
import kr.co.crewmate.site.model.Parameter;
import kr.co.crewmate.site.model.ParameterImpl;
import kr.co.crewmate.site.model.user.User;
import kr.co.crewmate.site.model.user.UserCriteria;
import kr.co.crewmate.site.model.user.UserLoginForm;
import kr.co.crewmate.site.service.MessageService;
import kr.co.crewmate.site.service.UserService;
import kr.co.crewmate.site.utils.CookieUtils;
import kr.co.crewmate.site.utils.Encryption;
import kr.co.crewmate.site.utils.SiteUtils;
import kr.co.crewmate.site.utils.Utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Controller
public class MainController extends FrontOfficeController {

    @Inject
    private UserService userService;

    @Inject
    private MessageService messageService;

    final Log log = LogFactory.getLog(this.getClass());

    /**
     * 메인 index
     * @param naver_code
     * @param pcKey
     * @return
     */
    @RequestMapping("/")
    public ModelAndView index(String pcKey) {
        if (StringUtils.equals(pcKey, "pc")){
            this.getSession().setAttribute(SET_PC_KEY, pcKey);
        }

        return new ModelAndView("redirect:/shop/main");
//        return new ModelAndView("redirect:/make_product?base_product=21");//test용
    }

    /**
     * 메인 HTML view page
     * @param model
     * @param criteria
     * @return
     */
    @RequestMapping("/shop/main")
    public ModelAndView viewHtml(ModelMap model, UserCriteria criteria) {
        return new ModelAndView("frontoffice/main");
    }

    /**
     * parking
     * @return
     */
    @RequestMapping("/shop/parking")
    public ModelAndView parking(ModelMap model){
        return new ModelAndView("frontoffice/main/parking");
    }

    @RequestMapping("/shop/error")
    public ModelAndView error() {
        throw new RuntimeException("hello");
    }
}
