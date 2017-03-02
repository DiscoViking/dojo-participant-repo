import org.junit.Test;
import org.mockito.Mockito;
import tell.dont.ask.*;

import static org.mockito.Mockito.*;


public class PatientReminderTest {
    private static final String EMAIL_ADDRESS = "an@email.address";
    private static final String PHONE_NUMBER = "07950518195";
    private static final String HOME_PHONE = "01659249394";

    private final Patient emailPatient = ImmutablePatient.builder().email(
            ImmutableEmail.of(EMAIL_ADDRESS)
    ).build();
    private final Patient phonePatient = ImmutablePatient.builder().phone(
            ImmutablePhone.of(PHONE_NUMBER)
    ).build();
    private final Patient homePhonePatient = ImmutablePatient.builder().phone(
            ImmutablePhone.of(HOME_PHONE)
    ).build();

    private final EmailService emailService = mock(EmailService.class);
    private final TextMessageService phoneService = mock(TextMessageService.class);

    private final PatientReminder reminder = new PatientReminder(emailService, phoneService);

    @Test public void
    a_patient_with_an_email_address_receives_an_email() {
        reminder.remind(emailPatient);
        verify(emailService).emailReminderTo(EMAIL_ADDRESS);
    }

    @Test public void
    a_patient_with_a_phone_number_receives_a_text_message() {
        reminder.remind(phonePatient);
        verify(phoneService).sendTextReminderTo(PHONE_NUMBER);
    }

    @Test public void
    a_patient_with_no_email_address_does_not_get_an_email() {
        reminder.remind(phonePatient);
        verify(emailService, never()).emailReminderTo(Mockito.anyString());
    }

    @Test public void
    a_patient_with_no_phone_number_does_not_receive_a_text() {
        reminder.remind(emailPatient);
        verify(phoneService, never()).sendTextReminderTo(Mockito.anyString());
    }
    
    @Test public void
    a_patient_with_an_invalid_phone_number_does_not_receive_a_test() {
        Patient invalidPatient = ImmutablePatient.builder().phone(
                ImmutablePhone.of("This is not a phone number")
        ).build();
        reminder.remind(invalidPatient);
        verify(phoneService, never()).sendTextReminderTo(Mockito.anyString());
    }

    @Test public void
    a_patient_with_a_home_phone_number_is_not_texted() {
        reminder.remind(homePhonePatient);
        verify(phoneService, never()).sendTextReminderTo(Mockito.anyString());
    }

    @Test public void
    a_patient_with_a_home_phone_is_rung() {
        reminder.remind(homePhonePatient);
        verify(phoneService).callWithReminder(Mockito.anyString());
    }
}
