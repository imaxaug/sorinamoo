package kr.co.crewmate.site.service;

import java.util.List;

import kr.co.crewmate.site.model.Canvas;
import kr.co.crewmate.site.model.ColorSize;
import kr.co.crewmate.site.model.Product;
import kr.co.crewmate.site.model.TypeSize;

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

    List<Product> getProductColor(Product param);

    List<Product> getProductType(Product param);

    List<Product> getProductSize(Product param);

    List<Canvas> getCanvasList(Product param);

    List<Product> getFileList(Product param);

    List<Product> getPriceList(Product param);
}