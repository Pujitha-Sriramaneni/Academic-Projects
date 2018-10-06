package electronic.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import electronic.cart.bean.CustomerCart;
import electronic.cart.bean.RemainderMessage;
import electronic.cart.bean.RetailerProduct;
import electronic.cart.bean.UserDetails;
import electronic.cart.dao.CustomerActionsDao;
import electronic.cart.validations.EcartValidateUtil;

/**
 * @author Sravya Yella
 *
 */
@Controller
public class ElectronicCartCustomerController {

	@Autowired
	private UserDetails userDetails;

	private String message;

	@Autowired
	private CustomerActionsDao customerActions;

	@Autowired
	private CustomerCart customerCart;
	/**
	 * navigates to shopping page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/shoppingPage", method = RequestMethod.POST)
	public ModelAndView customerShopping(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.addObject("message",message);
		modelAndView.setViewName("customerShopping");
		return modelAndView;
	}
	/**
	 * finds the result of customer search
	 * @return
	 */
	@RequestMapping(value = "/searchResults", method=RequestMethod.POST)
	public ModelAndView customerSearch(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		List<RetailerProduct> retailerProducts = customerActions.getCustomerSearchResult(request.getParameter("userSelection"));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.addObject("message",message);
		modelAndView.addObject("retailerProducts",retailerProducts);
		modelAndView.setViewName("customerSearchResult");
		request.getSession().setAttribute("searchKey", request.getParameter("userSelection"));
		return modelAndView;
	}
	/**
	 * Adds to cart
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/productAddToCart", method = RequestMethod.POST)
	public ModelAndView productAddToCart(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		String userResponse = request.getParameter("userSelection");
		String[] values = userResponse.split("~",-1);
		if(EcartValidateUtil.emptyCheck(values[3]) && EcartValidateUtil.emptyCheck(values[2])){
			if(values[2].matches("[0-9]+") && values[3].matches("[0-9]+")){
				int stock = Integer.valueOf(values[2]);
				int quan = Integer.valueOf(values[3]);
				if( stock <= 0 ){
					message = "Item Out of stock.";
				}else if(quan <= 0){
					message = "Quantity should be greater than 0";
				}
				else if(quan > stock && quan > 0){
					message = "Quantity should be less than stock";
				}
			}
			else{
				message = "Provide proper value to Quantity Required";
			}
		}
		else{
			message = "Provide proper value to Quantity Required";
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		if(null == message || message.length() == 0){
			customerCart.setCost(Double.valueOf(values[1]));
			customerCart.setCustomerId(userDetails.getLoginUserName());
			customerCart.setIsOrdered("N");
			customerCart.setIsDispatched("N");
			customerCart.setIsReceived("N");
			customerCart.setRetailerId(values[4]);
			customerCart.setRtlPrdId(Long.valueOf(values[0]));
			customerCart.setQuantity(Long.valueOf(values[3]));
			message = customerActions.updateCustomerCart(customerCart,Integer.valueOf(values[2]));
		}
		if(message.contains("Success")){
			modelAndView.setViewName("customerCart");
			List<CustomerCart> customerCarts = customerActions.getDetailsOfCustomerCart(userDetails.getLoginUserName());
			if(null ==  customerCarts || customerCarts.size() == 0){
				message = "No Items in Cart";
			}else{
				modelAndView.addObject("customerCarts",customerCarts);
			}
		}else{
			List<RetailerProduct> retailerProducts = customerActions.getCustomerSearchResult((String) request.getSession().getAttribute("searchKey"));
			modelAndView.addObject("retailerProducts",retailerProducts);
			modelAndView.setViewName("customerSearchResult");
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	/**
	 * Places the order of Customer
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
	public ModelAndView customerPlaceOrder(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		String userResponse = request.getParameter("userSelection");
		message = customerActions.placeOrder(userResponse);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("customerCart");
		List<CustomerCart> customerCarts = customerActions.getDetailsOfCustomerCart(userDetails.getLoginUserName());
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + "No Items to display in Cart.";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	/**
	 * navigates customer to cart
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/goToCart", method = RequestMethod.POST)
	public ModelAndView goToCart(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("customerCart");
		List<CustomerCart> customerCarts = customerActions.getDetailsOfCustomerCart(userDetails.getLoginUserName());
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = "No Items to display in Cart.";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	/**
	 * navigates customer to orders page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/goToOrders", method = RequestMethod.POST)
	public ModelAndView goToOrders(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("customerOrders");
		List<CustomerCart> customerCarts = customerActions.getDetailsOfCustomerOrders(userDetails.getLoginUserName());
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = "No Items to display in Cart.";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	/**
	 * navigates customer to orders page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/orderReceived", method = RequestMethod.POST)
	public ModelAndView customerConfirmOrderReceiving(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		String userResponse = request.getParameter("userSelection");
		message = customerActions.receiveOrder(userResponse);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("customerOrders");
		List<CustomerCart> customerCarts = customerActions.getDetailsOfCustomerOrders(userDetails.getLoginUserName());
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + "No orders to receive.";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	/**
	 * navigates customer to orders page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/orderHistory", method = RequestMethod.POST)
	public ModelAndView customerOrderHistory(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("custOrderHistory");
		List<CustomerCart> customerCarts = customerActions.getCustomerOrderHistory(userDetails.getLoginUserName());
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + "No Items ordered in past.";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	/**
	 * navigates customer to orders eligible to cancel page
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ordersEligibleToCancel", method = RequestMethod.POST)
	public ModelAndView ordersCanCancel(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("customerCancelOrders");
		List<CustomerCart> customerCarts = customerActions.getCancelEligibleOrders(userDetails.getLoginUserName());
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = "No orders to eligible to cancel.";
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
	@RequestMapping(value = "/cancelOrder", method = RequestMethod.POST)
	public ModelAndView cancelOrders(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		String userResponse = request.getParameter("userSelection");
		message = customerActions.cancelOrder(userResponse);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("customerCancelOrders");
		List<CustomerCart> customerCarts = customerActions.getCancelEligibleOrders(userDetails.getLoginUserName());
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + "No orders to eligible to cancel.";
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
	@RequestMapping(value = "/messagesFromExecutive", method = RequestMethod.POST)
	public ModelAndView viewMessages(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("messageView");
		List<RemainderMessage> remainderMessages = customerActions.getMessages(userDetails.getLoginUserName());
		if(null ==  remainderMessages || remainderMessages.size() == 0){
			message = message + "No messages";
		}else{
			modelAndView.addObject("remainderMessages",remainderMessages);
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}

	@RequestMapping(value = "/readMessage",method = RequestMethod.POST)
	public ModelAndView updateMessageStatus(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		String userResponse = request.getParameter("userSelection");
		String message = customerActions.updateMessageStatus(userResponse);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail",userDetails);
		modelAndView.setViewName("messageView");
		List<RemainderMessage> remainderMessages = customerActions.getMessages(userDetails.getLoginUserName());
		if(null ==  remainderMessages || remainderMessages.size() == 0){
			message = message + ". No messages";
		}else{
			modelAndView.addObject("remainderMessages",remainderMessages);
		}
		modelAndView.addObject("message",message);
		return modelAndView;
	}
}
