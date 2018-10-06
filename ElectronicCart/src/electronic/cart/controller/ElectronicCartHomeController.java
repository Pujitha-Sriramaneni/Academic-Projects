package electronic.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import electronic.cart.bean.UserDetails;

/**
 * Controlls the requests from home page
 * @author Sravya Yella
 *
 */
@Controller
public class ElectronicCartHomeController {

	/**
	 * Navigates to the Login Page
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView homeLogin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "");
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	/**
	 * Navigates to the Sign up page
	 * @return
	 */
	@RequestMapping("/signup")
	public ModelAndView homeSignUp(){
		UserDetails userDetails = new UserDetails();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetails", userDetails);
		modelAndView.addObject("message","");
		return modelAndView;
	}
}
