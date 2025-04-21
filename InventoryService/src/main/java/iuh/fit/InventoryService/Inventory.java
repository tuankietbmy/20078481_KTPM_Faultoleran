package iuh.fit.InventoryService;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inventory {
    @Id
    
	private Long productId;
    private Integer stock;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	private Integer quantity;
    public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Inventory [quantity=" + quantity + ", productId=" + productId + ", stock=" + stock + "]";
	}
	
	public Inventory(Integer quantity, Long productId, Integer stock) {
		super();
		this.quantity = quantity;
		this.productId = productId;
		this.stock = stock;
	}
    
}
