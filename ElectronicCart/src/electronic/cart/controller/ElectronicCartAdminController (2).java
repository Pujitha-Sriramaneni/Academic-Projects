package electronic.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import electronic.cart.bean.Product;
import electronic.cart.bean.UserDetails;
import electronic.cart.dao.AdminActionsDao;
import electronic.cart.validations.EcartValidateUtil;

/**
 * Controls the functionalities of Admin
 * @author Sravya Yella
 *
 */
@Controller
public class ElectronicCartAdminController {

	@Autowired
	private AdminActionsDao actionsDao;

	@Autowired
	private UserDetails userDetails;

	/**
	 * Picks the list of Retailers who are pending for approvals
	 * @return
	 */
	@RequestMapping(value = "/approveOrRejectRetailer", method = RequestMethod.POST)
	public ModelAndView approveOrRejectRetailer(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		List<UserDetails> details = actionsDao.getDisApprovedUserDetails("Retailer");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.addObject("userDetails",details);
		modelAndView.setViewName("adminApprovals");
		return modelAndView;
	}
	/**
	 * Picks the list of Sales Executive who are pending for approvals
	 * @return
	 */
	@RequestMapping(value = "/approveOrRejectExecutive", method = RequestMethod.POST)
	public ModelAndView approveOrRejectExecutive(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		List<UserDetails> details = actionsDao.getDisApprovedUserDetails("Sales Executive");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.addObject("userDetails",details);
		modelAndView.setViewName("adminApprovals");
		return modelAndView;
	}
	/**
	 * Approves the user
	 * @param request
	 * @return
	 */
	@RequestMapping( value = "/adminApprovalResponse" , method = RequestMethod.POST)
	public ModelAndView approveUser(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		String adminResponse = request.getParameter("userSelection");
		String[] details = adminResponse.split("~");
		ModelAndView modelAndView = new ModelAndView();
		try{
			actionsDao.adminResponse(details[0], details[2]);
		}
		catch (Exception e) {
			if(e.getMessage().contains("User Data not found")){
				modelAndView.addObject("message",e.getMessage());}
		}
		List<UserDetails> details1 = actionsDao.getDisApprovedUserDetails(details[1]);
		modelAndView.addObject("message", details[0] + " " + details[2] + "ance is"+ " Successfull");
		modelAndView.addObject("userDetails",details1);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("adminApprovals");
		return modelAndView;
	}
	/**
	 * sends the approved Retailers data to the GUI
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteRetailer")
	public ModelAndView deleteRetailer(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		ModelAndView modelAndView = new ModelAndView();
		List<UserDetails> details = actionsDao.getApprovedUserDetails("Retailer");
		modelAndView.addObject("userDetails",details);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("userDeletions");
		return modelAndView;
	}
	/**
	 * sends the approved Retailers data to the GUI
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteExecutive")
	public ModelAndView deleteExecutive(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		ModelAndView modelAndView = new ModelAndView();
		List<UserDetails> details = actionsDao.getApprovedUserDetails("Sales Executive");
		modelAndView.addObject("userDetails",details);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("userDeletions");
		return modelAndView;
	}
	/**
	 * Deletes the user and sends list of existing user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteUsers", method=RequestMethod.POST)
	public ModelAndView deleteUser(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		String adminResponse = request.getParameter("userSelection");
		String[] details = adminResponse.split("~");
		ModelAndView modelAndView = new ModelAndView();
		try{
			actionsDao.adminResponse(details[0], details[2]);
		}
		catch (Exception e) {
			if(e.getMessage().contains("User Data not found")){
				modelAndView.addObject("message",e.getMessage());
			}
		}
		List<UserDetails> details1 = actionsDao.getApprovedUserDetails(details[1]);
		modelAndView.addObject("message" , details[1] + " : " + details[0] + " deleted Successfully");
		modelAndView.addObject("userDetails",details1);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("userDeletions");
		return modelAndView;
	}
	/**
	 * Provide to add the new product
	 * @return
	 */
	@RequestMapping("/newProductAddition")
	public ModelAndView addNewProduct(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","");
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("addNewProduct");
		return modelAndView;
	}
	/**
	 * Provide to add the new product
	 * @return
	 */
	@RequestMapping("/addProduct")
	public ModelAndView addProduct(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		String message = "Please provide value to ";
		Product product = new Product();
		if(EcartValidateUtil.emptyCheck(request.getParameter("category"))){
			product.setCategory(request.getParameter("category").trim());
		}
		else{
			message = message + " Category";
		}
		if(EcartValidateUtil.emptyCheck(request.getParameter("productType"))){
			product.setProductType(request.getParameter("productType").trim());
		}
		else{
			message = message + " Product Type";
		}
		if(EcartValidateUtil.emptyCheck(request.getParameter("productSubType"))){
			product.setProductSubType(request.getParameter("productSubType").trim());
		}
		else{
			message = message + " Product SubType";
		}
		if(EcartValidateUtil.emptyCheck(request.getParameter("productDesc"))){
			product.setProductDescription(request.getParameter("productDesc").trim());
		}
		else{
			message = message + " Product Description";
		}		
		if(!message.contains("  ")){
			message = actionsDao.addProduct(product);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("addNewProduct");
		return modelAndView;
	}
	/**
	 * Gives the available product details.
	 * @return
	 */
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		List<Product> productdeatils = actionsDao.getProductCombinations();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("","");
		modelAndView.addObject("productDetails",productdeatils);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("deleteProduct");
		return modelAndView;
	}
	/**
	 * deletes the product
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/productDeletion" , method = RequestMethod.POST)
	public ModelAndView productDeletion(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		String message = actionsDao.productDeletion(request.getParameter("userSelection"));
		List<Product> productdeatils = actionsDao.getProductCombinations();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.addObject("productDetails",productdeatils);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("deleteProduct");
		return modelAndView;
	}
}
