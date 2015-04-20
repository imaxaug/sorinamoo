package kr.co.crewmate.site.web.controller;

import kr.co.crewmate.site.config.Config;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController extends FrontOfficeController {

    final Log log = LogFactory.getLog(this.getClass());

    private final String jsExtension = "js";

    @RequestMapping("/script/{scriptId}")
    public ModelAndView script(ModelMap model, @PathVariable("scriptId") String scriptId, String serviceYn) {
        model.addAttribute("imageServer", Config.getImageServerHost());
        model.addAttribute("uploadServer", Config.getUploadServerHost());
        model.addAttribute("isLogin", super.getLoginUser() == null ? false : true);
        model.addAttribute("serverHost", Config.getServerHost());
        model.addAttribute("serverHostForSSL", Config.getServerHostForSSL());
        model.addAttribute("onlyServerHost", Config.getOnlyServerHost());
//        System.out.println(super.getLoginUser() == null ? false : true);
        return new ModelAndView(String.format("script/%s.%s", scriptId, jsExtension));
    }

    @RequestMapping("/system/error")
    public ModelAndView error(ModelMap model) {
        try {
            Exception e = (Exception) this.getRequest().getAttribute("exception");
            if (StringUtils.indexOf(e.getMessage(), "FileNotFoundException") > 0) {
                return new ModelAndView("forward:/shop/common/pageNotFound");
            }
            if (log.isErrorEnabled()) {
                log.error(e.getMessage(), e);
            }
        } catch (Throwable e) {
            model.addAttribute("exception", new RuntimeException("오류없음", e));
            if (log.isErrorEnabled()) {
                log.error(e.getMessage(), e);
            }
        }

        model.addAttribute("imageServer", Config.getImageServerHost());
        model.addAttribute("decorator", "none");
        return new ModelAndView("error/systemError");
    }

    @RequestMapping("/shop/common/pageNotFound")
    public ModelAndView pageNotFound(ModelMap model) {
        model.addAttribute("imageServer", Config.getImageServerHost());
        model.addAttribute("decorator", "none");
        return new ModelAndView("frontoffice/common/pageNotFound");
    }

    /**
     * Exception 페이지
     */
    @RequestMapping("/shop/common/orderSession")
    public ModelAndView orderSession(ModelMap model) {
        try {
            Exception e = (Exception) this.getRequest().getAttribute("exception");
            if (log.isErrorEnabled()) {
                log.error(e.getMessage(), e);
            }
        } catch (Throwable e) {
        }

        model.addAttribute("decorator", "none");
        return new ModelAndView("frontoffice/common/orderSession");
    }


}
