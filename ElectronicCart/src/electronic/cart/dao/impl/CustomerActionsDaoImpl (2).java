/**
 * 
 */
package electronic.cart.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import electronic.cart.bean.CustomerCart;
import electronic.cart.bean.Product;
import electronic.cart.bean.RemainderMessage;
import electronic.cart.bean.RetailerProduct;
import electronic.cart.dao.CustomerActionsDao;

/**
 * @author Sravya Yella
 *
 */
@Component
@Transactional
public class CustomerActionsDaoImpl implements CustomerActionsDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * provides the list based on the keyy
	 */
	@SuppressWarnings("unchecked")
	public List<RetailerProduct> getCustomerSearchResult(String key) {
		List<RetailerProduct> retailerProducts = (List<RetailerProduct>) hibernateTemplate.find("from RetailerProduct where upper(productSearchKey) like upper(?)", "%" + key + "%");
		List<RetailerProduct> uiList = new ArrayList<RetailerProduct>();
		for (RetailerProduct retailerProduct : retailerProducts) {
			RetailerProduct retailerProductNew = new RetailerProduct();
			Product product = hibernateTemplate.get(Product.class, Long.valueOf(retailerProduct.getProductId()));
			retailerProductNew = retailerProduct;
			retailerProductNew.setProduct(product);
			uiList.add(retailerProductNew);
		}
		return uiList;
	}

	/**
	 * updates the customer Cart.
	 */
	@SuppressWarnings("unchecked")
	public String updateCustomerCart(CustomerCart customerCart,int stock) {
		List<CustomerCart> cart = (List<CustomerCart>) hibernateTemplate.find("from CustomerCart where rtlPrdId = ? and customerId = ? and isOrdered = 'N'",customerCart.getRtlPrdId(),customerCart.getCustomerId());
		if(null == cart || cart.size() == 0){
			customerCart.setTotalValue(customerCart.getCost() * customerCart.getQuantity());
			hibernateTemplate.save(customerCart);
			hibernateTemplate.flush();
			return "Added to cart Successfully";
		}
		else {
			for (CustomerCart customerCart2 : cart) {
				CustomerCart customerCart3 = hibernateTemplate.get(CustomerCart.class, customerCart2.getCustomerCartId());
				if(stock < customerCart3.getQuantity()+ customerCart.getQuantity()){
					return "Already you have " + customerCart2.getQuantity() + " in your cart. So you can only add " + (stock - customerCart2.getQuantity());
				}
				customerCart3.setQuantity(customerCart2.getQuantity()+customerCart.getQuantity());
				customerCart3.setTotalValue(customerCart.getCost() * customerCart3.getQuantity());
				hibernateTemplate.update(customerCart3);
				hibernateTemplate.flush();
			}
			return "Added to cart Successfully";
		}
	}

	/**
	 * gives the items in customer cart.
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerCart> getDetailsOfCustomerCart(String customerId) {
		List<CustomerCart> cart = (List<CustomerCart>) hibernateTemplate.find("from CustomerCart where customerId = ? and isOrdered = 'N'",customerId);
		List<CustomerCart> uiList = new ArrayList<CustomerCart>();
		for (CustomerCart customerCart : cart) {
			CustomerCart customerCart2 = new CustomerCart();
			RetailerProduct retailerProduct = hibernateTemplate.get(RetailerProduct.class, customerCart.getRtlPrdId());
			Product product = hibernateTemplate.get(Product.class, Long.valueOf(retailerProduct.getProductId()));
			customerCart2 = customerCart;
			retailerProduct.setProduct(product);
			customerCart2.setRetailerProduct(retailerProduct);
			uiList.add(customerCart2);
		}
		return uiList;
	}

	/**
	 * Places the Customer Order.
	 */
	public String placeOrder(String custCartId) {
		CustomerCart customerCart = hibernateTemplate.get(CustomerCart.class, Long.valueOf(custCartId));
		RetailerProduct retailerProduct = hibernateTemplate.get(RetailerProduct.class, customerCart.getRtlPrdId());
		retailerProduct.setProductStock(retailerProduct.getProductStock() - customerCart.getQuantity());
		hibernateTemplate.update(retailerProduct);
		customerCart.setIsOrdered("Y");
		hibernateTemplate.update(customerCart);
		hibernateTemplate.flush();
		return "Order Placed Successfully.";
	}

	/**
	 * gets the orders of customer.
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerCart> getDetailsOfCustomerOrders(String customerId) {
		List<CustomerCart> cart = (List<CustomerCart>) hibernateTemplate.find("from CustomerCart where customerId = ? and isOrdered = 'Y' and isReceived = 'N'",customerId);
		List<CustomerCart> uiList = new ArrayList<CustomerCart>();
		for (CustomerCart customerCart : cart) {
			CustomerCart customerCart2 = new CustomerCart();
			RetailerProduct retailerProduct = hibernateTemplate.get(RetailerProduct.class, customerCart.getRtlPrdId());
			Product product = hibernateTemplate.get(Product.class, Long.valueOf(retailerProduct.getProductId()));
			customerCart2 = customerCart;
			retailerProduct.setProduct(product);
			customerCart2.setRetailerProduct(retailerProduct);
			uiList.add(customerCart2);
		}
		return uiList;
	}

	/**
	 * updates the order received by customer
	 */
	public String receiveOrder(String custCartId) {
		CustomerCart customerCart = hibernateTemplate.get(CustomerCart.class, Long.valueOf(custCartId));
		customerCart.setIsReceived("Y");
		hibernateTemplate.update(customerCart);
		hibernateTemplate.flush();
		return "Order Received Successfully.";
	}

	/**
	 * gives the order history of customer
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerCart> getCustomerOrderHistory(String customerId) {
		List<CustomerCart> cart = (List<CustomerCart>) hibernateTemplate.find("from CustomerCart where customerId = ? and isOrdered = 'Y' and isReceived = 'Y'",customerId);
		List<CustomerCart> uiList = new ArrayList<CustomerCart>();
		for (CustomerCart customerCart : cart) {
			CustomerCart customerCart2 = new CustomerCart();
			RetailerProduct retailerProduct = hibernateTemplate.get(RetailerProduct.class, customerCart.getRtlPrdId());
			Product product = hibernateTemplate.get(Product.class, Long.valueOf(retailerProduct.getProductId()));
			customerCart2 = customerCart;
			retailerProduct.setProduct(product);
			customerCart2.setRetailerProduct(retailerProduct);
			uiList.add(customerCart2);
		}
		return uiList;
	}

	/**
	 * cancel order
	 */
	public String cancelOrder(String custCartId) {
		CustomerCart customerCart = hibernateTemplate.get(CustomerCart.class, Long.valueOf(custCartId));
		RetailerProduct retailerProduct = hibernateTemplate.get(RetailerProduct.class, customerCart.getRtlPrdId());
		retailerProduct.setProductStock(retailerProduct.getProductStock() + customerCart.getQuantity());
		hibernateTemplate.update(retailerProduct);
		customerCart.setIsOrdered("Y");
		hibernateTemplate.delete(customerCart);
		hibernateTemplate.flush();
		return "Order Canceled Successfully.";
	}

	/**
	 * cancel eligible products
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerCart> getCancelEligibleOrders(String customerId) {
		List<CustomerCart> cart = (List<CustomerCart>) hibernateTemplate.find("from CustomerCart where customerId = ? and isOrdered = 'N' and isDispatched = 'N'",customerId);
		List<CustomerCart> uiList = new ArrayList<CustomerCart>();
		for (CustomerCart customerCart : cart) {
			CustomerCart customerCart2 = new CustomerCart();
			RetailerProduct retailerProduct = hibernateTemplate.get(RetailerProduct.class, customerCart.getRtlPrdId());
			Product product = hibernateTemplate.get(Product.class, Long.valueOf(retailerProduct.getProductId()));
			customerCart2 = customerCart;
			retailerProduct.setProduct(product);
			customerCart2.setRetailerProduct(retailerProduct);
			uiList.add(customerCart2);
		}
		return uiList;
	}

	/**
	 * gives the message details
	 */
	@SuppressWarnings("unchecked")
	public List<RemainderMessage> getMessages(String userId) {
		List<RemainderMessage> value = (List<RemainderMessage>) hibernateTemplate.find("from RemainderMessage where userId = ? order by isMessageViewed", userId);
		List<RemainderMessage> uiList = new ArrayList<RemainderMessage>();
		for (RemainderMessage remainderMessage : value) {
			CustomerCart customerCart = hibernateTemplate.get(CustomerCart.class, remainderMessage.getCustCartId());
			RetailerProduct retailerProduct = hibernateTemplate.get(RetailerProduct.class, Long.valueOf(customerCart.getRtlPrdId()));
			Product product = hibernateTemplate.get(Product.class, Long.valueOf(retailerProduct.getProductId()));
			retailerProduct.setProduct(product);
			customerCart.setRetailerProduct(retailerProduct);
			RemainderMessage remainderMessage2 = new RemainderMessage();
			remainderMessage2 = remainderMessage;
			remainderMessage2.setCustomerCart(customerCart);
			uiList.add(remainderMessage2);
		}
		return uiList;
	}

	/**
	 * updates messages
	 */
	public String updateMessageStatus(String msgId) {
		RemainderMessage remainderMessage = hibernateTemplate.get(RemainderMessage.class, Long.valueOf(msgId));
		remainderMessage.setIsMessageViewed("Y");
		hibernateTemplate.update(remainderMessage);
		hibernateTemplate.flush();
		return "Message Updated Successfully";
	}

}
