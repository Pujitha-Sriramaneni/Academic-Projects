/**
 * 
 */
package electronic.cart.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import electronic.cart.bean.Product;
import electronic.cart.bean.UserDetails;

/**
 * @author Sravya Yella
 *
 */
@Component
public interface AdminActionsDao {

	public List<UserDetails> getDisApprovedUserDetails(String userType);
	
	public void adminResponse(String loginUserName,String adminInput) throws Exception;
	
	public List<UserDetails> getApprovedUserDetails(String userType);
	
	public String addProduct(Product product);
	
	public List<Product> getProductCombinations();
	
	public String productDeletion(String productId);
}
