import tell.dont.ask.EmailService;
import tell.dont.ask.Patient;
import tell.dont.ask.Phone;
import tell.dont.ask.TextMessageService;


public class PatientReminder {

    private final EmailService emailService;
    private final TextMessageService phoneService;

    public PatientReminder(EmailService emailService, TextMessageService phoneService) {
        this.emailService = emailService;
        this.phoneService = phoneService;
    }
    
    // Reminds a patient
    public void remind(Patient patient) {
        if(patient.hasEmailAddress()) {
            emailService.emailReminderTo(patient.getEmailAddress());
        }
        
        Phone patientPhone = patient.getPhone();

        if(patientPhone.isMobile()) {
            phoneService.sendTextReminderTo(patient.getPhoneNumber());
        } else if(patientPhone.isLandLine()) {
            phoneService.callWithReminder(patient.getPhoneNumber());
        }
    }
}