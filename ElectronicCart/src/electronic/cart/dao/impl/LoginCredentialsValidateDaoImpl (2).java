package electronic.cart.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import electronic.cart.bean.UserDetails;
import electronic.cart.dao.LoginCredentialsValidateDao;

@Component
public class LoginCredentialsValidateDaoImpl implements LoginCredentialsValidateDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public UserDetails validateLoginDetails(String userName) {
		UserDetails dataBasedetails = hibernateTemplate.get(UserDetails.class, userName);
		return dataBasedetails;
	}
}
