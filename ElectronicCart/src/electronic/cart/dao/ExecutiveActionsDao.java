/**
 * 
 */
package electronic.cart.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import electronic.cart.bean.CustomerCart;
import electronic.cart.bean.RemainderMessage;

/**
 * @author Sravya Yella
 *
 */
@Component
public interface ExecutiveActionsDao {

	public List<CustomerCart> pendingOrdersFromCustomers();
	
	public String messageUser(RemainderMessage remainderMessage);
	
	public List<CustomerCart> pendingDispatchesFromretailers();
	
	public List<CustomerCart> pendingReceiveFromCustomer();
}
