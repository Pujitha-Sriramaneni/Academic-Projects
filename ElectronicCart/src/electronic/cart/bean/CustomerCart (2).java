package electronic.cart.bean;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/**
 * Details of Product
 * @author Sravya Yella
 *
 */
@Component
public class CustomerCart {

	private Long customerCartId;

	private Long rtlPrdId;

	private String isOrdered;

	private Long quantity;

	private String customerId;
	
	private String retailerId;

	private double totalValue;
	
	private String isDispatched;
	
	private String isReceived;

	@Transient
	private RetailerProduct retailerProduct;

	@Transient
	private double cost;
	/**
	 * @return the customerCartId
	 */
	public Long getCustomerCartId() {
		return customerCartId;
	}

	/**
	 * @param customerCartId the customerCartId to set
	 */
	public void setCustomerCartId(Long customerCartId) {
		this.customerCartId = customerCartId;
	}

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
	 * @return the isOrdered
	 */
	public String getIsOrdered() {
		return isOrdered;
	}

	/**
	 * @param isOrdered the isOrdered to set
	 */
	public void setIsOrdered(String isOrdered) {
		this.isOrdered = isOrdered;
	}

	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the totalValue
	 */
	public double getTotalValue() {
		return totalValue;
	}

	/**
	 * @param totalValue the totalValue to set
	 */
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	/**
	 * @return the isDispatched
	 */
	public String getIsDispatched() {
		return isDispatched;
	}

	/**
	 * @param isDispatched the isDispatched to set
	 */
	public void setIsDispatched(String isDispatched) {
		this.isDispatched = isDispatched;
	}

	/**
	 * @return the isReceived
	 */
	public String getIsReceived() {
		return isReceived;
	}

	/**
	 * @param isReceived the isReceived to set
	 */
	public void setIsReceived(String isReceived) {
		this.isReceived = isReceived;
	}

	/**
	 * @return the retailerProduct
	 */
	public RetailerProduct getRetailerProduct() {
		return retailerProduct;
	}

	/**
	 * @param retailerProduct the retailerProduct to set
	 */
	public void setRetailerProduct(RetailerProduct retailerProduct) {
		this.retailerProduct = retailerProduct;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
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

}
