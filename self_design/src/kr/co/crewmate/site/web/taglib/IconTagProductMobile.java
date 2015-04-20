package kr.co.crewmate.site.web.taglib;

import org.apache.commons.lang3.StringUtils;

/**
 * 상품 아이콘
 */
@SuppressWarnings("serial")
public class IconTagProductMobile extends IconTag {
    @Override
    String getImageTag(String imageName) {
        String result = "";
        if(StringUtils.equals(imageName, "01")){
            result = "<i class=\"ico ico01\">쿠폰O</i>";
        }else if(StringUtils.equals(imageName, "02")){
            result = "<i class=\"ico ico02\">쿠폰X</i>";
        }else if(StringUtils.equals(imageName, "03")){
            result = "<i class=\"ico ico03\">GIFT</i>";
        }else if(StringUtils.equals(imageName, "04")){
            result = "<i class=\"ico ico04\">NEW</i>";
        }else if(StringUtils.equals(imageName, "05")){
            result = "<i class=\"ico ico05\">SALE</i>";
        }else if(StringUtils.equals(imageName, "06")){ 
            result = "<i class=\"ico ico06\">BEST</i>";
        }
        return result;
    }

}
