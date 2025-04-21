package iuh.fit.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryRepository repo;

    @PostMapping("/deduct")
    public ResponseEntity<?> deductStock(@RequestParam Long productId, @RequestParam int quantity) {
        Inventory item = repo.findById(productId).orElse(null);
        if (item != null && item.getStock() >= quantity) {
            item.setStock(item.getStock() - quantity);
            repo.save(item);
            return ResponseEntity.ok("Stock updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not enough stock");
    }
}
