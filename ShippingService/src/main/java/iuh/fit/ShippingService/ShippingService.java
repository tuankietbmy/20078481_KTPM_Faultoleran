package iuh.fit.ShippingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    public Shipping createShipping(Shipping shipping) {
        shipping.setStatus("PENDING");
        return shippingRepository.save(shipping);
    }

    public List<Shipping> getAllShipments() {
        return shippingRepository.findAll();
    }

    public Optional<Shipping> getShippingById(Long id) {
        return shippingRepository.findById(id);
    }

    public Shipping updateStatus(Long id, String status) {
        Optional<Shipping> ship = shippingRepository.findById(id);
        if (ship.isPresent()) {
            Shipping s = ship.get();
            s.setStatus(status);
            return shippingRepository.save(s);
        }
        return null;
    }
}
