/**
 * 
 */
package electronic.cart.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import electronic.cart.bean.CustomerCart;
import electronic.cart.bean.RetailerProduct;

/**
 * @author Sravya Yella
 *
 */
@Component
public interface RetailerActionsDao {
	
	public String addToretailerShop(RetailerProduct retailerProduct);

	public List<RetailerProduct> getAvailableProductsInShop(String retalerId);
	
	public String deleteRetailerProduct(String rtlPrdId);
	
	public String modifyRetailerProduct(RetailerProduct retailerProduct);
	
	public List<CustomerCart> getDispatchPendingItems(String retailerId);
	
	public String dispatchItem(String custCartId);
}
