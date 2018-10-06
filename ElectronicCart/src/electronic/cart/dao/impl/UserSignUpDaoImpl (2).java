package electronic.cart.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import electronic.cart.bean.UserDetails;
import electronic.cart.dao.UserSignUpDao;

@Component
@Transactional
public class UserSignUpDaoImpl implements UserSignUpDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public String validateAndPersistUser(UserDetails userDetails) {
		UserDetails existingDetails = hibernateTemplate.get(UserDetails.class, userDetails.getLoginUserName());
		if(existingDetails != null){
			return "Login User Name already Exists. Please try another one.";
		}
		hibernateTemplate.setCheckWriteOperations(false);
		if("customer".equalsIgnoreCase(userDetails.getUserType())){
			userDetails.setApprovalStatus("Y");
		}else{
			userDetails.setApprovalStatus("N");
		}
		hibernateTemplate.save(userDetails);
		hibernateTemplate.flush();
		return "success";
	}
}
