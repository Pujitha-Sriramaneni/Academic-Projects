package electronic.cart.bean;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/**
 * @author Sravya Yella
 *
 */
@Component
public class RemainderMessage {

	private Long messageId;

	private Long custCartId;

	private String userId;

	private String executiveMessage;

	private String isMessageViewed;
	
	@Transient
	private CustomerCart customerCart;

	/**
	 * @return the messageId
	 */
	public Long getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the custCartId
	 */
	public Long getCustCartId() {
		return custCartId;
	}

	/**
	 * @param custCartId the custCartId to set
	 */
	public void setCustCartId(Long custCartId) {
		this.custCartId = custCartId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the executiveMessage
	 */
	public String getExecutiveMessage() {
		return executiveMessage;
	}

	/**
	 * @param executiveMessage the executiveMessage to set
	 */
	public void setExecutiveMessage(String executiveMessage) {
		this.executiveMessage = executiveMessage;
	}

	/**
	 * @return the isMessageViewed
	 */
	public String getIsMessageViewed() {
		return isMessageViewed;
	}

	/**
	 * @param isMessageViewed the isMessageViewed to set
	 */
	public void setIsMessageViewed(String isMessageViewed) {
		this.isMessageViewed = isMessageViewed;
	}

	/**
	 * @return the customerCart
	 */
	public CustomerCart getCustomerCart() {
		return customerCart;
	}

	/**
	 * @param customerCart the customerCart to set
	 */
	public void setCustomerCart(CustomerCart customerCart) {
		this.customerCart = customerCart;
	}

}
