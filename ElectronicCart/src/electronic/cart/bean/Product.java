package electronic.cart.bean;

import org.springframework.stereotype.Component;

/**
 * Product bean
 * @author Sravya Yella
 *
 */
@Component
public class Product {

	private Long productId;
	
	private String category;
	
	private String productType;
	
	private String productSubType;
	
	private String productDescription;

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the productSubType
	 */
	public String getProductSubType() {
		return productSubType;
	}

	/**
	 * @param productSubType the productSubType to set
	 */
	public void setProductSubType(String productSubType) {
		this.productSubType = productSubType;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
}
