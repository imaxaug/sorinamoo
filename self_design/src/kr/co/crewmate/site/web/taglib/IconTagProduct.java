package kr.co.crewmate.site.web.taglib;

import org.apache.commons.lang3.StringUtils;

import kr.co.crewmate.site.config.Config;

/**
 * 상품 아이콘
 */
@SuppressWarnings("serial")
public class IconTagProduct extends IconTag {
    @Override
    String getImageTag(String imageName) {
        if(StringUtils.equals(Config.getSiteNatnCode(), "CN")){
            return String.format("<img src=\""+Config.getImageServerHost()+"/images/shop/cn/common/IconS%s.gif\"/>", imageName);
        }
        return String.format("<img src=\""+Config.getImageServerHost()+"/images/shop/product/list/sIcon%s.gif\"/>", imageName);
    }

}
