/**
 * 
 */
package electronic.cart.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import electronic.cart.bean.CustomerCart;
import electronic.cart.bean.RemainderMessage;
import electronic.cart.bean.RetailerProduct;

/**
 * @author Sravya Yella
 *
 */
@Component
public interface CustomerActionsDao {

	public List<RetailerProduct> getCustomerSearchResult(String key);
	
	public String updateCustomerCart(CustomerCart customerCart,int stock);

	public List<CustomerCart> getDetailsOfCustomerCart(String customerId);
	
	public List<CustomerCart> getDetailsOfCustomerOrders(String customerId);
	
	public List<CustomerCart> getCustomerOrderHistory(String customerId);
	
	public List<CustomerCart> getCancelEligibleOrders(String customerId);
	
	public String placeOrder(String custCartId);
	
	public String receiveOrder(String custCartId);
	
	public String cancelOrder(String custCartId);
	
	public List<RemainderMessage> getMessages(String userId);
	
	public String updateMessageStatus(String msgId);
}
