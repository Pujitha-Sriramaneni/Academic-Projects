package electronic.cart.validations;

import org.springframework.util.StringUtils;

import electronic.cart.bean.LoginDetails;

/**
 * Validates the User Login data
 * @author Sravya Yella
 *
 */
public class UserLoginDetailsValidator {

	/**
	 * Validates the User Login input
	 * @param loginDetails
	 * @return
	 */
	public static String loginCredentialsValidator(LoginDetails loginDetails) {
		if("".equals(loginDetails.getUserName())
				|| "".equals(loginDetails.getPassword())
				|| StringUtils.isEmpty(loginDetails.getUserName())
				|| StringUtils.isEmpty(loginDetails.getPassword())){
			return "Please Provide the Values of User Name and Password";
		}
		if(!(loginDetails.getUserName().matches("[a-zA-Z0-9]*") || loginDetails.getPassword().matches("[a-zA-Z0-9.$]{6,20}"))){
			return "Invalid User Name and Password.";
		}
		return null;

	}
}
