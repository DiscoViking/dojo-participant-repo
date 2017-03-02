package tell.dont.ask;

/**
 * Created by paulg on 3/2/17.
 */

public class Phone {
    private String phoneNumber;

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isMobile() {
        return isValid() && phoneNumber.startsWith("07");
    }

    public boolean isLandLine() {
        return isValid() && !isMobile();
    }

    private boolean isValid() {
        return (phoneNumber != null) && (phoneNumber.length() == 11);
    }

    public void setNumber(String number) {
        this.phoneNumber = number;
    }
}
