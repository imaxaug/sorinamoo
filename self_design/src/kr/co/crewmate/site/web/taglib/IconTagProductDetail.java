package kr.co.crewmate.site.web.taglib;

import kr.co.crewmate.site.config.Config;

/**
 * 상품 상세 아이콘
 */
@SuppressWarnings("serial")
public class IconTagProductDetail extends IconTag {

    @Override
    String getImageTag(String imageName) {
        //임시.. 
        return String.format("<img src=\""+Config.getImageServerHost()+"/images/shop/product/detail/detail_icon%s.gif\"/>", imageName);
    }
}
