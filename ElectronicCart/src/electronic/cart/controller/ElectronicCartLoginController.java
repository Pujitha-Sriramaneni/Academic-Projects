package electronic.cart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import electronic.cart.bean.LoginDetails;
import electronic.cart.bean.UserDetails;
import electronic.cart.dao.LoginCredentialsValidateDao;
import electronic.cart.dao.UserSignUpDao;
import electronic.cart.validations.UserLoginDetailsValidator;
import electronic.cart.validations.UserSignUpDetailsValidator;
/**
 * Controls and validates the User Signup and Login Actions
 * @author Sravya Yella
 *
 */
@Controller
public class ElectronicCartLoginController {

	@Autowired
	private UserDetails userDetails;

	@Autowired
	private LoginDetails loginDetails;

	@Autowired
	private LoginCredentialsValidateDao logincredentialsValidate;

	@Autowired
	private UserSignUpDao userSignUpDao;

	/**
	 * User login
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public ModelAndView validateCredentials(HttpServletRequest request) {
		loginDetails.setUserName(request.getParameter("userName"));
		loginDetails.setPassword(request.getParameter("password"));
		String message = UserLoginDetailsValidator.loginCredentialsValidator(loginDetails);
		ModelAndView modelAndView = new ModelAndView();
		if (!StringUtils.isEmpty(message)) {
			modelAndView.addObject("message", message);
			modelAndView.setViewName("login");
			return modelAndView;
		}
		userDetails = logincredentialsValidate.validateLoginDetails(loginDetails.getUserName());
		if(userDetails == null || StringUtils.isEmpty(userDetails.getPassword()) || (!loginDetails.getPassword().equals(userDetails.getPassword()))){
			modelAndView.addObject("message", "Invalid User Name and Password.");
			modelAndView.setViewName("login");
			return modelAndView;
		}
		if("N".equalsIgnoreCase(userDetails.getApprovalStatus())){
			modelAndView.addObject("message", "Awaiting for Admin's approval.");
			modelAndView.setViewName("login");
			return modelAndView;
		}
		if("admin".equalsIgnoreCase(userDetails.getUserType())){
			modelAndView.setViewName("adminhome");
		}else if ("Customer".equalsIgnoreCase(userDetails.getUserType())) {
			modelAndView.setViewName("customerhome");
		}else if("Retailer".equalsIgnoreCase(userDetails.getUserType())){
			modelAndView.setViewName("retailerhome");
		}else if("Sales Executive".equalsIgnoreCase(userDetails.getUserType())){
			modelAndView.setViewName("executiveHome");
		}
		request.getSession().setAttribute("userSessionDetails", userDetails);
		userDetails.setPassword("");
		request.setAttribute("userDetail", userDetails);
		return modelAndView;
	}

	/**
	 * User Sign up
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userSignUp" , method = RequestMethod.POST)
	public ModelAndView saveUserDetails(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		userDetails.setFirstName(request.getParameter("firstName"));
		userDetails.setMiddleName(request.getParameter("middleName"));
		userDetails.setLastName(request.getParameter("lastName"));
		userDetails.setEmailId(request.getParameter("emailId"));
		userDetails.setContactNumber(request.getParameter("contactNumber"));
		userDetails.setLoginUserName(request.getParameter("loginUserName"));
		userDetails.setPassword(request.getParameter("password"));
		userDetails.setUserType(request.getParameter("userType"));
		String message = UserSignUpDetailsValidator.validateUserBean(userDetails);
		if (!StringUtils.isEmpty(message)) {
			modelAndView.addObject("userDetails", userDetails);
			modelAndView.addObject("message", message);
			modelAndView.setViewName("signup");
			return modelAndView;
		}
		try{
			String persistantMessage = userSignUpDao.validateAndPersistUser(userDetails);
			if((!StringUtils.isEmpty(persistantMessage)) && persistantMessage.contains("already Exists")){
				modelAndView.addObject("userDetails", userDetails);
				modelAndView.addObject("message", persistantMessage);
				modelAndView.setViewName("signup");
				return modelAndView;
			}
			modelAndView.setViewName("login");
			return modelAndView;
		}
		catch (Exception e) {
			modelAndView.addObject("userDetails", userDetails);
			modelAndView.addObject("message", "Try again or Contact Admin.");
			modelAndView.setViewName("signup");
			return modelAndView;
		}
	}
	/**
	 * Navigates to home
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userHome", method = RequestMethod.POST)
	public ModelAndView navigateToHome(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		ModelAndView modelAndView = new ModelAndView();
		if("Admin".equalsIgnoreCase(userDetails.getUserType())){
			modelAndView.setViewName("adminhome");
		}else if("Retailer".equalsIgnoreCase(userDetails.getUserType())){
			modelAndView.setViewName("retailerhome");
		}else if("Sales Executive".equalsIgnoreCase(userDetails.getUserType())){
			modelAndView.setViewName("executiveHome");
		}
		else if("Customer".equalsIgnoreCase(userDetails.getUserType())){
			modelAndView.setViewName("customerhome");
		}
		modelAndView.addObject("userDetail",userDetails);
		return modelAndView;

	}
}
