package kr.co.crewmate.site.service;

import java.util.List;

import kr.co.crewmate.site.model.ColorSize;
import kr.co.crewmate.site.model.Product;
import kr.co.crewmate.site.model.TypeSize;
import kr.co.crewmate.site.model.product.ProductCriteria;

/**
 *
 * 클래스명 : <code>UserService</code>
 *
 * @author 남세건
 * @date 2013. 5. 23.
 *
 */
public interface ProductService {

    List<Product> getProductList(Product param);

    Product getProductDetail(Product param);

    List<ColorSize> getColorSizeList(Product param);

    List<TypeSize> getTypeSizeList(Product param);

    List<Product> getProductColor(ProductCriteria param);

    List<Product> getProductType(ProductCriteria param);

    List<Product> getProductSize(ProductCriteria param);

}