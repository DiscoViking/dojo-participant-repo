import can.touch.Customer;
import can.touch.OfferSender;
import cannot.touch.EmailService;
import cannot.touch.TextService;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by paulg on 3/3/17.
 */
public class OfferSenderShould {

    private final int ID = 123;
    private final String NAME = "AARON";
    private final String EMAIL_CONTACT = "aaron@hotmail.net";
    private final String PHONE_CONTACT = "07123545463";

    private final EmailService emailService = mock(EmailService.class);
    private final TextService textService = mock(TextService.class);
    private final OfferSender offerSender = new OfferSender(emailService, textService);

    private final Customer customerWithEmail = new Customer(ID, NAME, EMAIL_CONTACT);
    private final Customer customerWithPhone = new Customer(ID, NAME, PHONE_CONTACT);
    private final Customer customerWithoutContact = new Customer(ID, NAME, null);
    private final String TEST_MESSAGE = "test offer message";

    @Test public void
    if_has_email_address_email_is_sent() {
        offerSender.sendOffer(customerWithEmail, TEST_MESSAGE);
        verify(emailService).sendEmail(customerWithEmail.getContact(), TEST_MESSAGE);
        verifyNoMoreInteractions(emailService);
        verifyZeroInteractions(textService);
    }

    @Test public void
    if_has_phone_text_is_sent() {
        offerSender.sendOffer(customerWithPhone, TEST_MESSAGE);
        verify(textService).sendMessage(customerWithPhone.getContact(), TEST_MESSAGE);
        verifyNoMoreInteractions(textService);
        verifyZeroInteractions(emailService);
    }

    @Test public void
    if_has_no_contact_nothing_is_sent() {
        offerSender.sendOffer(customerWithoutContact, TEST_MESSAGE);
        verifyZeroInteractions(textService, emailService);
    }
}
