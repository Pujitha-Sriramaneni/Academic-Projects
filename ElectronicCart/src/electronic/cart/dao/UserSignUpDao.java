package electronic.cart.dao;

import org.springframework.stereotype.Component;

import electronic.cart.bean.UserDetails;
/**
 * Validates and creates the new account for Customer and Retailer.
 * @author Sravya Yella
 *
 */
@Component
public interface UserSignUpDao {

	public String validateAndPersistUser(UserDetails userDetails);
		
}
