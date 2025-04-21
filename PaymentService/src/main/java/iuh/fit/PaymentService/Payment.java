package iuh.fit.PaymentService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Payment {
    @Id @GeneratedValue
    private Long id;
    private Long orderId;
    private BigDecimal amount;
    private String status;
    private LocalDateTime paymentDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", orderId=" + orderId + ", amount=" + amount + ", status=" + status
				+ ", paymentDate=" + paymentDate + "]";
	}
	public Payment(Long id, Long orderId, BigDecimal amount, String status, LocalDateTime paymentDate) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.amount = amount;
		this.status = status;
		this.paymentDate = paymentDate;
	}
    
}
