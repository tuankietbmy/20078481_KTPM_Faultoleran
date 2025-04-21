package iuh.fit.InventoryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getInventoryById(Long id) {
        return inventoryRepository.findById(id);
    }

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(Long id, Inventory updatedInventory) {
        Optional<Inventory> existing = inventoryRepository.findById(id);
        if (existing.isPresent()) {
            Inventory inv = existing.get();
            inv.setProductId(updatedInventory.getProductId());
            inv.setQuantity(updatedInventory.getQuantity());
            return inventoryRepository.save(inv);
        } else {
            return null;
        }
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }
}
