package kr.co.crewmate.site.dao;

import java.util.List;

import kr.co.crewmate.site.model.ColorSize;
import kr.co.crewmate.site.model.Product;
import kr.co.crewmate.site.model.product.ProductCriteria;

/**
 *
 * 클래스명 : <code>UserDao</code>
 *
 * @author 남세건
 * @date 2013. 5. 23.
 *
 */
public interface ProductDao {

	List<Product> getProductList(Product param);

	Product getProductDetail(Product param);

	List<ColorSize> getColorSizeList(Product param);

	List<Product> getProductColor(ProductCriteria param);
}
