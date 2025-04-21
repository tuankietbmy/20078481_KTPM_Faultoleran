package iuh.fit.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        Optional<Payment> existing = paymentRepository.findById(id);
        if (existing.isPresent()) {
            Payment p = existing.get();
            p.setOrderId(updatedPayment.getOrderId());
            p.setAmount(updatedPayment.getAmount());
            p.setStatus(updatedPayment.getStatus());
            return paymentRepository.save(p);
        } else {
            return null;
        }
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
