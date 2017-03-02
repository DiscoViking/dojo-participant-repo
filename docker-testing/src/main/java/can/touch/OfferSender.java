package can.touch;

import cannot.touch.EmailService;
import cannot.touch.TextService;

/**
 * Created by paulg on 3/3/17.
 */
public class OfferSender {

    private final EmailService emailService;
    private final TextService textService;

    public OfferSender(EmailService emailService, TextService textService) {
        this.emailService = emailService;
        this.textService = textService;
    }

    public void sendOffer(Customer customer, String message) {
        this.emailService.sendEmail(customer.getContact(), message);
    }
}
