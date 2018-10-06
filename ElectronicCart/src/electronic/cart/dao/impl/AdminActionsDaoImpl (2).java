package electronic.cart.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import electronic.cart.bean.Product;
import electronic.cart.bean.UserDetails;
import electronic.cart.dao.AdminActionsDao;

/**
 * @author Sravya Yella
 *
 */
@Component
@Transactional
public class AdminActionsDaoImpl implements AdminActionsDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	/**
	 * gets the list of unapproved user list.
	 */
	@SuppressWarnings("unchecked")
	public List<UserDetails> getDisApprovedUserDetails(String userType) {
		List<UserDetails> userDetails = (List<UserDetails>) hibernateTemplate.find("from UserDetails where userType = ? and approvalStatus = 'N'", userType);
		return userDetails;
	}
	/**
	 * updates the approval Status
	 */
	public void adminResponse(String loginUserName, String adminInput) throws Exception{
		if(loginUserName != null && loginUserName.length() > 0){
			UserDetails details = hibernateTemplate.get(UserDetails.class, loginUserName);
			if(null != details){
				if(adminInput != null && adminInput.equalsIgnoreCase("Accept")){
					details.setApprovalStatus("Y");
					hibernateTemplate.update(details);
					hibernateTemplate.flush();
				}
				else{
					details.setApprovalStatus("N");
					hibernateTemplate.delete(details);
					hibernateTemplate.flush();
				}
			}
		}
		else{
			throw new Exception("User Data not found. Please refresh your page.");
		}
	}
	/**
	 * Gets the list of approved users
	 */
	@SuppressWarnings("unchecked")
	public List<UserDetails> getApprovedUserDetails(String userType) {
		return (List<UserDetails>) hibernateTemplate.find("from UserDetails where userType = ? and approvalStatus = 'Y'", userType);
	}
	/**
	 * Adds the new product
	 */
	@SuppressWarnings("unchecked")
	public String addProduct(Product product) {
		List<Product> products = (List<Product>) hibernateTemplate.find("from Product where category = ? and productType = ? and productSubType= ?", product.getCategory(),product.getProductType(),product.getProductSubType());
		if(null != products && products.size() > 0 ){
			return "Product combination already exist. Please try a new one.";
		}
		hibernateTemplate.save(product);
		hibernateTemplate.flush();
		return "Product added Successfully.";
	}
	/**
	 * returs the available product combinations.
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getProductCombinations() {
		return (List<Product>) hibernateTemplate.find("from Product");
	}
	/**
	 * deletes the product of given product ID.
	 */
	public String productDeletion(String productId) {
		Product product = hibernateTemplate.get(Product.class, Long.parseLong(productId));
		if(null != product){
			hibernateTemplate.delete(product);
			hibernateTemplate.flush();
			return "Product deleted Successfully";
		}
		return "Product not available";
	}
}
