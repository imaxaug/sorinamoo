package kr.co.crewmate.site.dao.ibatis;

import java.util.List;

import kr.co.crewmate.site.dao.ProductDao;
import kr.co.crewmate.site.model.ColorSize;
import kr.co.crewmate.site.model.Product;
import kr.co.crewmate.site.model.product.ProductCriteria;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * 클래스명 : <code>SqlMapUserDao</code>
 *
 * @author 남세건
 * @date 2013. 5. 23.
 *
 */
@Repository
public class SqlMapProductDao extends SqlMapClientDaoSupport implements ProductDao {

	@Override
	public List<Product> getProductList(Product param) {
		return super.getSqlMapClientTemplate().queryForList("ProductSQL.getProductList", param);
	}

	@Override
	public Product getProductDetail(Product param) {
		return (Product)super.getSqlMapClientTemplate().queryForObject("ProductSQL.getProductDetail", param);
	}

	@Override
	public List<ColorSize> getColorSizeList(Product param) {
		return super.getSqlMapClientTemplate().queryForList("ProductSQL.getColorSizeList", param);
	}

	@Override
	public List<Product> getProductColor(ProductCriteria param) {
		return super.getSqlMapClientTemplate().queryForList("ProductSQL.getProductColor", param);
	}
}