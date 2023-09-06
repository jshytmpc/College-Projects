package Constructors;

public class Subscriber {
    private String firstname;
    private String lastname;
    private String middlename;
    private String suffix;
    private String birthday;
    private String sex;
    private String nationality;
    private String province;
    private String city;
    private int unit;
    private String street;
    private String barangay;
    private int zipcode;

    public Subscriber(String firstname, String lastname, String middlename, String suffix, String birthday, String sex, String nationality, String province, String city, int unit, String street, String barangay, int zipcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.suffix = suffix;
        this.birthday = birthday;
        this.sex = sex;
        this.nationality = nationality;
        this.province = province;
        this.city = city;
        this.unit = unit;
        this.street = street;
        this.barangay = barangay;
        this.zipcode = zipcode;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public String getNationality() {
        return nationality;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public int getUnit() {
        return unit;
    }

    public String getStreet() {
        return street;
    }

    public String getBarangay() {
        return barangay;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}

