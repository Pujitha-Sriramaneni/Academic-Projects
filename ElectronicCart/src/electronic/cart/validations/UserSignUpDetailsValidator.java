package electronic.cart.validations;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import electronic.cart.bean.UserDetails;
/**
 * Used to validate the User Signup data
 * @author Sravya Yella
 *
 */
@Component
public class UserSignUpDetailsValidator {

	/**
	 * Validates the User data
	 * @param userDetails
	 * @return
	 */
	public static String validateUserBean(UserDetails userDetails) {
		
		if("".equals(userDetails.getFirstName())
				|| "".equals(userDetails.getEmailId())
				|| "".equals(userDetails.getContactNumber())
				|| "".equals(userDetails.getLoginUserName())
				|| "".equals(userDetails.getPassword())
				|| StringUtils.isEmpty(userDetails.getFirstName())
				|| StringUtils.isEmpty(userDetails.getEmailId())
				|| StringUtils.isEmpty(userDetails.getContactNumber())
				|| StringUtils.isEmpty(userDetails.getLoginUserName())
				|| StringUtils.isEmpty(userDetails.getPassword())){
			return "Please Provide values to mandatory fields (First Name, Email Id, Contact Number, Login User Name, Password)";
		}
		if(!userDetails.getPassword().matches("[a-zA-Z0-9.$]{6,20}")){
			return "Password may contain small and capital alphabets, numbers and special characters('.','$') and length should be between 6 and 20	";
		}
		if(!userDetails.getContactNumber().matches("[0-9]{10}")){
			return "Contact number should contain only number and it should contain exactly 10 digits";
		}
		if(!userDetails.getLoginUserName().matches("[a-zA-Z0-9]*")){
			return "Login User Name should only contain alplabets and numbers.";
		}
		if(!userDetails.getEmailId().matches("[a-zA-Z0-9.]*[@][a-zA-Z]*[.][a-zA-Z]*")){
			return "Email ID should be as : username@hostname.(com/in) or user.name@hostname.(com/in)";
		}
		return null;
	}
}
