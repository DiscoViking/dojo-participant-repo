import tell.dont.ask.EmailService;
import tell.dont.ask.Patient;
import tell.dont.ask.Phone;
import tell.dont.ask.TextMessageService;

import java.util.Optional;


public class PatientReminder {

    private final EmailService emailService;
    private final TextMessageService phoneService;

    public PatientReminder(EmailService emailService, TextMessageService phoneService) {
        this.emailService = emailService;
        this.phoneService = phoneService;
    }
    
    // Reminds a patient
    public void remind(Patient patient) {
        patient.receiveEmail(emailService);
        patient.receivePhoneCommunication(phoneService);
    }
}