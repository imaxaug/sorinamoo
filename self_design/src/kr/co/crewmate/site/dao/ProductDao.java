package kr.co.crewmate.site.dao;

import java.util.List;

import kr.co.crewmate.site.model.CommonCode;
import kr.co.crewmate.site.model.Design;
import kr.co.crewmate.site.model.ListResult;
import kr.co.crewmate.site.model.Product;
import kr.co.crewmate.site.model.user.User;
import kr.co.crewmate.site.model.user.UserCriteria;
import kr.co.crewmate.site.model.user.UserLoginForm;
import kr.co.crewmate.site.model.user.UserLoginHistory;

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
}
