package Constructors;

public class Registration {
    private final long phoneNumber;
    private final String ownership;
    private final String network;

    public Registration(long phoneNumber, String ownership,String network) {
        this.phoneNumber = phoneNumber;
        this.ownership = ownership;
        this.network = network;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getOwnership() {
        return ownership;
    }

    public String getNetwork() {
        return network;
    }
}

