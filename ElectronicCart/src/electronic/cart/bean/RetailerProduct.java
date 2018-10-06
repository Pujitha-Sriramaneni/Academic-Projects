package electronic.cart.bean;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/**
 * Retailer Product.
 * @author Sravya Yella
 *
 */
@Component
public class RetailerProduct {

	private Long rtlPrdId;

	private String productId;

	private String retailerId;

	private Long productStock;

	private Double productPrice;

	private String productBrandName;
	
	private String productSearchKey;
	
	@Transient
	private Product product;

	/**
	 * @return the rtlPrdId
	 */
	public Long getRtlPrdId() {
		return rtlPrdId;
	}

	/**
	 * @param rtlPrdId the rtlPrdId to set
	 */
	public void setRtlPrdId(Long rtlPrdId) {
		this.rtlPrdId = rtlPrdId;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the retailerId
	 */
	public String getRetailerId() {
		return retailerId;
	}

	/**
	 * @param retailerId the retailerId to set
	 */
	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}

	/**
	 * @return the productStock
	 */
	public Long getProductStock() {
		return productStock;
	}

	/**
	 * @param productStock the productStock to set
	 */
	public void setProductStock(Long productStock) {
		this.productStock = productStock;
	}

	/**
	 * @return the productPrice
	 */
	public Double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the productBrandName
	 */
	public String getProductBrandName() {
		return productBrandName;
	}

	/**
	 * @param productBrandName the productBrandName to set
	 */
	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the productSearchKey
	 */
	public String getProductSearchKey() {
		return productSearchKey;
	}

	/**
	 * @param productSearchKey the productSearchKey to set
	 */
	public void setProductSearchKey(String productSearchKey) {
		this.productSearchKey = productSearchKey;
	}

}
