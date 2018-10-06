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
import electronic.cart.bean.RetailerProduct;
import electronic.cart.dao.RetailerActionsDao;

/**
 * @author Sravya Yella
 *
 */
@Component
@Transactional
public class RetailerActionsDaoImpl implements RetailerActionsDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	/**
	 * Adds new band
	 */
	@SuppressWarnings("unchecked")
	public String addToretailerShop(RetailerProduct retailerProduct) {
		List<RetailerProduct> availableList = (List<RetailerProduct>) hibernateTemplate.find("from RetailerProduct where productId = ? and retailerId = ? and productBrandName = ?", retailerProduct.getProductId(),retailerProduct.getRetailerId(),retailerProduct.getProductBrandName());
		if(null != availableList && availableList.size() > 0){
			return "Combination already available";
		}
		Product product = hibernateTemplate.get(Product.class, Long.valueOf(retailerProduct.getProductId()));
		retailerProduct.setProductSearchKey(product.getCategory() + " " + product.getProductType() + " " + product.getProductSubType() + " " + product.getProductDescription() + " " +retailerProduct.getProductBrandName());
		hibernateTemplate.save(retailerProduct);
		hibernateTemplate.flush();
		return "Added to Shop Successfully";
	}
	/**
	 * provides the list of available products in shop
	 */
	@SuppressWarnings("unchecked")
	public List<RetailerProduct> getAvailableProductsInShop(String retalerId) {
		List<RetailerProduct> list = (List<RetailerProduct>) hibernateTemplate.find("from RetailerProduct where retailerId = ?", retalerId);
		List<RetailerProduct> uiList = new ArrayList<RetailerProduct>();
		for (RetailerProduct retailerProduct : list) {
			RetailerProduct retailerProductNew = new RetailerProduct();
			Product product = hibernateTemplate.get(Product.class, Long.valueOf(retailerProduct.getProductId()));
			retailerProductNew = retailerProduct;
			retailerProductNew.setProduct(product);
			uiList.add(retailerProductNew);
		}
		return uiList;
	}
	/**
	 * deletes the product from retailer shop.
	 */
	public String deleteRetailerProduct(String rtlPrdId) {
		RetailerProduct retailerProduct = hibernateTemplate.get(RetailerProduct.class, Long.valueOf(rtlPrdId));
		if(null != retailerProduct){
			hibernateTemplate.delete(retailerProduct);
			hibernateTemplate.flush();
			return "Item Deleted Successfully";
		}
		return "Item Cannot be Deleted";
	}
	/**
	 * Modifies the product data
	 */
	public String modifyRetailerProduct(RetailerProduct retailerProduct) {
		RetailerProduct retailerProductDb = hibernateTemplate.get(RetailerProduct.class, Long.valueOf(retailerProduct.getRtlPrdId()));
		if(null != retailerProductDb){
			retailerProductDb.setProductPrice(retailerProduct.getProductPrice());
			retailerProductDb.setProductStock(retailerProduct.getProductStock());
			hibernateTemplate.update(retailerProductDb);
			hibernateTemplate.flush();
			return "Item Modified Successfully";
		}
		return "Item Cannot be MOdified";
	}
	@SuppressWarnings("unchecked")
	public List<CustomerCart> getDispatchPendingItems(String retailerId) {
		List<CustomerCart> cart = (List<CustomerCart>) hibernateTemplate.find("from CustomerCart where isOrdered = 'Y' and  isDispatched = 'N' and retailerId = ?", retailerId);
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
	public String dispatchItem(String custCartId) {
		CustomerCart customerCart = hibernateTemplate.get(CustomerCart.class, Long.valueOf(custCartId));
		customerCart.setIsDispatched("Y");
		hibernateTemplate.update(customerCart);
		hibernateTemplate.flush();
		return "Order Dispatched Successfully.";
	}
}
