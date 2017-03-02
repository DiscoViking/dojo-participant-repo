package tell.dont.ask;

public class Patient {

    private String email;
    private Phone phone;

    public Patient() {
        phone = new Phone(null);
    }

    public void setEmailAddress(String email) {
        this.email = email;
    }

    public String getEmailAddress() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone.setNumber(phoneNumber);

    }

    public String getPhoneNumber() {
        return phone.getPhoneNumber();
    }

    public boolean hasEmailAddress() {
        return this.email != null;
    }

    public Phone getPhone() {
        return phone;
    }

}
