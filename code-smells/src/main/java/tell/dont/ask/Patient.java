package tell.dont.ask;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
public interface Patient {

    @Value.Parameter
    Optional<Email> email();

    @Value.Parameter
    Optional<Phone> phone();

    default boolean hasEmailAddress() {
        return email().isPresent();
    }

    default void receiveEmail(EmailService emailService) {
        if(hasEmailAddress()) {
            emailService.emailReminderTo(email().get().emailAddress());
        }
    };

    default void receivePhoneCommunication(TextMessageService phoneService) {
        if(!phone().isPresent()) {
            return;
        }

        if(phone().get().isMobile()) {
            phoneService.sendTextReminderTo(phone().get().phoneNumber());
        } else if(phone().get().isLandLine()) {
            phoneService.callWithReminder(phone().get().phoneNumber());
        }
    };
}
