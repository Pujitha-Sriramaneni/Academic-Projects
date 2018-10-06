package electronic.cart.dao;

import org.springframework.stereotype.Component;

import electronic.cart.bean.UserDetails;

@Component
public interface LoginCredentialsValidateDao {

	public UserDetails validateLoginDetails(String loginUserName);
}
