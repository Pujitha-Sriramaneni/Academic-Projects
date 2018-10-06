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
import electronic.cart.bean.UserDetails;
import electronic.cart.dao.ExecutiveActionsDao;

/**
 * @author Sravya Yella
 *
 */
@Controller
public class ElectronicCartExecutiveController {

	@Autowired
	private UserDetails userDetails;

	private String message;

	@Autowired
	private ExecutiveActionsDao executiveActionsDao;

	@Autowired
	private RemainderMessage remainderMessage;

	/**
	 * returns the pending orders from customers.
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pendingOrdersFromCustomers",method = RequestMethod.POST)
	public ModelAndView getPendingOrdersFromCustomers(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("pendingCustOrders");
		List<CustomerCart> customerCarts = executiveActionsDao.pendingOrdersFromCustomers();
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + "No Pending orders from customers";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	/**
	 * returns the pending orders from customers.
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/custMessageOrderIntimation",method = RequestMethod.POST)
	public ModelAndView customerMessageIntimatiion(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		String userResponse = request.getParameter("userSelection");
		String[] values = userResponse.split("~",-1);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("pendingCustOrders");
		remainderMessage.setCustCartId(Long.valueOf(values[0]));
		remainderMessage.setUserId(values[1]);
		remainderMessage.setExecutiveMessage("This item is pending to Order. please take action on it");
		remainderMessage.setIsMessageViewed("N");
		String message = executiveActionsDao.messageUser(remainderMessage);
		List<CustomerCart> customerCarts = executiveActionsDao.pendingOrdersFromCustomers();
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + ". No Pending orders from customers";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	/**
	 * returns the pending orders from customers.
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pendingDispatchFromRetailer",method = RequestMethod.POST)
	public ModelAndView getPendingDispatchFromRetailer(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("pendingRetailerDispatches");
		List<CustomerCart> customerCarts = executiveActionsDao.pendingDispatchesFromretailers();
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + "No dispatches pending from Retailer";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	/**
	 * returns the pending orders from customers.
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/retailerMessageDispatchIntimation",method = RequestMethod.POST)
	public ModelAndView retailerMessageIntimation(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		String userResponse = request.getParameter("userSelection");
		String[] values = userResponse.split("~",-1);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("pendingRetailerDispatches");
		remainderMessage.setCustCartId(Long.valueOf(values[0]));
		remainderMessage.setUserId(values[1]);
		remainderMessage.setExecutiveMessage("This item is pending to dispatch. Please make it at the earliest");
		remainderMessage.setIsMessageViewed("N");
		String message = executiveActionsDao.messageUser(remainderMessage);
		List<CustomerCart> customerCarts = executiveActionsDao.pendingDispatchesFromretailers();
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + ". No dispatches pending from Retailer";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	/**
	 * returns the pending orders from customers.
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pendingReceiveFromCustomer",method = RequestMethod.POST)
	public ModelAndView getPendingRecieveFromCustomer(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("pendingCustReceivings");
		List<CustomerCart> customerCarts = executiveActionsDao.pendingReceiveFromCustomer();
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + "No receivings pending from customer";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	/**
	 * returns the pending orders from customers.
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/custReceiveMessageDispatchIntimation",method = RequestMethod.POST)
	public ModelAndView custReceiveMessageIntimation(HttpServletRequest request) {
		message = "";
		userDetails = (UserDetails) request.getSession().getAttribute("userSessionDetails");

		String userResponse = request.getParameter("userSelection");
		String[] values = userResponse.split("~",-1);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userDetail", userDetails);
		modelAndView.setViewName("pendingCustReceivings");
		remainderMessage.setCustCartId(Long.valueOf(values[0]));
		remainderMessage.setUserId(values[1]);
		remainderMessage.setExecutiveMessage("This item is dispatched and ready to receive. Please take action on this");
		remainderMessage.setIsMessageViewed("N");
		String message = executiveActionsDao.messageUser(remainderMessage);
		List<CustomerCart> customerCarts = executiveActionsDao.pendingReceiveFromCustomer();
		if(null ==  customerCarts || customerCarts.size() == 0){
			message = message + ". No receivings pending from customers.";
		}else{
			modelAndView.addObject("customerCarts",customerCarts);
		}
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
