package iuh.fit.PaymentService;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository repo;

    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus("SUCCESS");
        return repo.save(payment);
    }

    @GetMapping("/{id}")
    public Payment get(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}
