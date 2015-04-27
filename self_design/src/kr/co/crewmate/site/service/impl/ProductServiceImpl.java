package kr.co.crewmate.site.service.impl;

import java.util.List;

import javax.inject.Inject;

import kr.co.crewmate.site.dao.ProductDao;
import kr.co.crewmate.site.model.ColorSize;
import kr.co.crewmate.site.model.Product;
import kr.co.crewmate.site.model.product.ProductCriteria;
import kr.co.crewmate.site.service.ProductService;

import org.springframework.stereotype.Service;

import com.ibatis.common.logging.Log;
import com.ibatis.common.logging.LogFactory;

/**
 *
 * 클래스명 : <code>UserSeviceImpl</code>
 *
 * @author 남세건
 * @date 2013. 5. 22.
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

    final Log log = LogFactory.getLog(this.getClass());

    @Inject
    private ProductDao productDao;

	@Override
	public List<Product> getProductList(Product param) {
		return this.productDao.getProductList(param);
	}

	@Override
	public Product getProductDetail(Product param) {
		return this.productDao.getProductDetail(param);
	}

	@Override
	public List<ColorSize> getColorSizeList(Product param) {
		return this.productDao.getColorSizeList(param);
	}

	@Override
	public List<Product> getProductColor(ProductCriteria param) {
		return this.productDao.getProductColor(param);
	}
}