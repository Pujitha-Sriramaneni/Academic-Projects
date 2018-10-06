package electronic.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import electronic.cart.bean.CustomerCart;
import electronic.cart.bean.Product;
import electronic.cart.bean.RemainderMessage;
import electronic.cart.bean.RetailerProduct;
import electronic.cart.bean.UserDetails;
import electronic.cart.dao.AdminActionsDao;
import electronic.cart.dao.CustomerActionsDao;
import electronic.cart.dao.RetailerActionsDao;
import electronic.cart.validations.EcartValidateUtil;
/**
 * Gives the product details.
 * @author Sravya Yella
 *
 */
@Controller
public class ElectronicCartRetailerController {

	@Autowired
	private AdminActionsDao actionsDao;

	@Autowired
	private UserDetails userDetails;

	@Autowired
	private RetailerProduct retailerProduct;

	@Autowired
	private RetailerActionsDao retailerActionsDao;

	@Autowired
	private CustomerActionsDao customerActionsDao;

	private String message;

	@RequestMapping(value = "/productsList", method = RequestMethod.POST)
	public ModelAndView getProductsList(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		ModelAndView modelAndView = new ModelAndView();
		List<Product> products = actionsDao.getProductCombinations();
		if(null == products || products.size() == 0){
			message = "No products available.";
		}
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("retailerProductAdditions");
		modelAndView.addObject("products",products);
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addToRetailerShop", method = RequestMethod.POST)
	public ModelAndView addToretailerShop(HttpServletRequest request) {
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		String userResponse = request.getParameter("userSelection");
		ModelAndView modelAndView = new ModelAndView();
		String[] values = userResponse.split("~",-1);
		retailerProduct.setRetailerId(request.getParameter("loggedInAs"));
		retailerProduct.setProductId(values[0]);
		message = "Please provide values to ";
		if(EcartValidateUtil.emptyCheck(values[1]) && values[1].matches("[a-zA-Z0-9 ]*")){
			retailerProduct.setProductBrandName(values[1].trim());
		}
		else{
			message = message + " Product Brand Name(Provide only Alphabets and spaces)";	
		}
		if(EcartValidateUtil.emptyCheck(values[2]) && values[2].trim().matches("[0-9]+[.]{0,1}[0-9]*")){
			retailerProduct.setProductPrice(Double.parseDouble(values[2].trim()));
		}
		else{
			message = message + " Product Price(Provide only digits)";	
		}
		if(EcartValidateUtil.emptyCheck(values[3]) && values[3].trim().matches("[0-9]+")){
			retailerProduct.setProductStock(Long.parseLong(values[3].trim()));
		}
		else{
			message = message + " Product Stock(Provide only digits)";	
		}
		if(!message.contains("  ")){
			if(retailerProduct.getProductPrice() <= 0 ){
				message = "Product Price should be greater than zero.";
			}else if(retailerProduct.getProductStock() < 1){
				message = "Product Stock should be greater than zero.";
			}else{
				message = retailerActionsDao.addToretailerShop(retailerProduct);
			}
		}
		List<Product> products = actionsDao.getProductCombinations();
		if(null == products || products.size() == 0){
			message = "No products available.";
		}
		modelAndView.addObject("products",products);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("retailerProductAdditions");
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	/**
	 * Gets the available products in the Shop.
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/retailerProductDeleteList", method = RequestMethod.POST)
	public ModelAndView getRetailerProductList(HttpServletRequest request) {
		message = "";
		ModelAndView modelAndView = new ModelAndView();
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		List<RetailerProduct> retailerProducts = retailerActionsDao.getAvailableProductsInShop(request.getParameter("loggedInAs"));
		if(null != retailerProducts && retailerProducts.size() == 0){
			message = "No Products in shop";
		}
		modelAndView.addObject("retailerProducts",retailerProducts);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("retailerProductDeletions");
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	/**
	 * deletes the item from retailer
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteRetailerProduct", method = RequestMethod.POST)
	public ModelAndView deleteItemFromretailerProductList(HttpServletRequest request) {
		message = "";
		ModelAndView modelAndView = new ModelAndView();
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		String userResponse = request.getParameter("userSelection");
		if(null != userResponse){
			message = retailerActionsDao.deleteRetailerProduct(userResponse);
		}
		else{
			message = "Item cannot be deleted";
		}
		List<RetailerProduct> retailerProducts = retailerActionsDao.getAvailableProductsInShop(request.getParameter("loggedInAs"));
		modelAndView.addObject("retailerProducts",retailerProducts);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("retailerProductDeletions");
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	/**
	 * Modify Current Items in Shop
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/retailerProductModifyList", method = RequestMethod.POST)
	public ModelAndView modifyItemsInShop(HttpServletRequest request) {
		message = "";
		ModelAndView modelAndView = new ModelAndView();
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		List<RetailerProduct> retailerProducts = retailerActionsDao.getAvailableProductsInShop(request.getParameter("loggedInAs"));
		modelAndView.addObject("retailerProducts",retailerProducts);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("retailerProductModifications");
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	/**
	 * MOdifies the product details
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/modifyRetailerProduct", method = RequestMethod.POST)
	public ModelAndView modifyRetailerProduct(HttpServletRequest request) {
		message = "Please provide values to ";
		ModelAndView modelAndView = new ModelAndView();
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		String userResponse = request.getParameter("userSelection");
		String[] values = userResponse.split("~", -1);
		retailerProduct.setRtlPrdId(Long.valueOf(values[0]));
		if(EcartValidateUtil.emptyCheck(values[1]) && values[1].trim().matches("[0-9]*[.]{0,1}[0-9]*")){
			retailerProduct.setProductPrice(Double.parseDouble(values[1].trim()));
		}
		else{
			message = message + " Product Price(Provide only digits)";	
		}
		if(EcartValidateUtil.emptyCheck(values[2]) && values[2].trim().matches("[0-9]*")){
			retailerProduct.setProductStock(Long.parseLong(values[2].trim()));
		}
		else{
			message = message + " Product Stock(Provide only digits)";	
		}
		if(!message.contains("  ")){
			if(retailerProduct.getProductPrice() <= 0 ){
				message = "Product Price should be greater than zero.";
			}else if(retailerProduct.getProductStock() < 1){
				message = "Product Stock should be greater than zero.";
			}else{
				message = retailerActionsDao.modifyRetailerProduct(retailerProduct);
			}
		}
		List<RetailerProduct> retailerProducts = retailerActionsDao.getAvailableProductsInShop(request.getParameter("loggedInAs"));
		modelAndView.addObject("retailerProducts",retailerProducts);
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("retailerProductModifications");
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	/**
	 * navigates customer to dispatch orders page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/dispatchOrders", method = RequestMethod.POST)
	public ModelAndView retailerDispatchOrederPending(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("retailerProductDispatchings");
		List<CustomerCart> customerCarts = retailerActionsDao.getDispatchPendingItems(userDetails.getLoginUserName());
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + "No Items to dispatch.";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	/**
	 * navigates retailer to dispatch page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/dispatchOrder", method = RequestMethod.POST)
	public ModelAndView dispatchItems(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		String userResponse = request.getParameter("userSelection");
		message = retailerActionsDao.dispatchItem(userResponse);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("retailerProductDispatchings");
		List<CustomerCart> customerCarts = retailerActionsDao.getDispatchPendingItems(userDetails.getLoginUserName());
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + "No Items to dispatch.";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	/**
	 * navigates customer to cancel orders page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/retailerMessagesFromExecutive", method = RequestMethod.POST)
	public ModelAndView viewMessages(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("messageVIewRetailer");
		List<RemainderMessage> remainderMessages = customerActionsDao.getMessages(userDetails.getLoginUserName());
		if(null ==  remainderMessages || remainderMessages.size() == 0){
			message = message + "No messages";
		}else{
			modelAndView.addObject("remainderMessages",remainderMessages);
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}

	/**
	 * updates retailer messages
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/retailerReadMessage",method = RequestMethod.POST)
	public ModelAndView updateMessageStatus(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		String userResponse = request.getParameter("userSelection");
		String message = customerActionsDao.updateMessageStatus(userResponse);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("messageVIewRetailer");
		List<RemainderMessage> remainderMessages = customerActionsDao.getMessages(userDetails.getLoginUserName());
		if(null ==  remainderMessages || remainderMessages.size() == 0){
			message = message + ". No messages";
		}else{
			modelAndView.addObject("remainderMessages",remainderMessages);
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}
}
