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
import electronic.cart.dao.ExecutiveActionsDao;

/**
 * @author Sravya Yella
 *
 */
@Component
@Transactional
public class ExecutiveActionsDaoImpl implements ExecutiveActionsDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * gives the list of pending orders
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerCart> pendingOrdersFromCustomers() {
		List<CustomerCart> cart = (List<CustomerCart>) hibernateTemplate.find("from CustomerCart where isOrdered = 'N'");
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
	 * messages to User
	 */
	public String messageUser(RemainderMessage remainderMessage) {
		hibernateTemplate.save(remainderMessage);
		hibernateTemplate.flush();
		return "Message sent Successfully";

	}

	/**
	 * pending dispatch Retailer details
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerCart> pendingDispatchesFromretailers() {
		List<CustomerCart> cart = (List<CustomerCart>) hibernateTemplate.find("from CustomerCart where isOrdered = 'Y' and isDispatched = 'N'");
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
	 * pending receiving customer details
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerCart> pendingReceiveFromCustomer() {
		List<CustomerCart> cart = (List<CustomerCart>) hibernateTemplate.find("from CustomerCart where isOrdered = 'Y' and isDispatched = 'Y' and isReceived = 'N'");
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

}
