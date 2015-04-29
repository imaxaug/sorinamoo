package kr.co.crewmate.site.dao.ibatis;

import java.util.List;

import kr.co.crewmate.site.dao.ProductDao;
import kr.co.crewmate.site.model.Canvas;
import kr.co.crewmate.site.model.ColorSize;
import kr.co.crewmate.site.model.Product;
import kr.co.crewmate.site.model.TypeSize;

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
	public List<Product> getProductColor(Product param) {
		return super.getSqlMapClientTemplate().queryForList("ProductSQL.getProductColor", param);
	}

	@Override
	public List<Product> getProductType(Product param) {
		return super.getSqlMapClientTemplate().queryForList("ProductSQL.getProductType", param);
	}

	@Override
	public List<TypeSize> getTypeSizeList(Product param) {
		return super.getSqlMapClientTemplate().queryForList("ProductSQL.getTypeSizeList", param);
	}

	@Override
	public List<String> getProductSize(Product param) {
		return super.getSqlMapClientTemplate().queryForList("ProductSQL.getProductSize", param);
	}

	@Override
	public List<Canvas> getCanvasList(Product param) {
		return super.getSqlMapClientTemplate().queryForList("ProductSQL.getCanvasList", param);
	}

	@Override
	public List<Product> getFileList(Product param) {
		return super.getSqlMapClientTemplate().queryForList("ProductSQL.getFileList", param);
	}

	@Override
	public List<ColorSize> getPriceList(Product param) {
		return super.getSqlMapClientTemplate().queryForList("ProductSQL.getPriceList", param);
	}
}