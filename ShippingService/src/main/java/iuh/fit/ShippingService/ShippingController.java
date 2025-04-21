package iuh.fit.ShippingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping
    public Shipping create(@RequestBody Shipping shipping) {
        return shippingService.createShipping(shipping);
    }

    @GetMapping
    public List<Shipping> getAll() {
        return shippingService.getAllShipments();
    }

    @GetMapping("/{id}")
    public Shipping getById(@PathVariable Long id) {
        return shippingService.getShippingById(id).orElse(null);
    }

    @PutMapping("/{id}/status")
    public Shipping updateStatus(@PathVariable Long id, @RequestParam String status) {
        return shippingService.updateStatus(id, status);
    }
}
