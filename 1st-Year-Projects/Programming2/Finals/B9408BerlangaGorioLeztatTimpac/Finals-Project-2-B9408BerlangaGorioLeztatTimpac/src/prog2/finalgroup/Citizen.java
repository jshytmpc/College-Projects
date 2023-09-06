package prog2.finalgroup;

public class Citizen implements Comparable<Citizen>{
    String fullName;
    String email;
    String address;
    int age;
    boolean resident;
    int district;
    char gender;

    public Citizen(String fullName, String email, String address, int age, boolean resident, int district, char gender) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.resident = resident;
        this.district = district;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public boolean isResident() {
        return resident;
    }

    public boolean isGender() {
        if(getGender() == 'M') {
            return true;
        }
        else
        return false;
    }


    public int getDistrict() {
        return district;
    }

    public char getGender() {
        return gender;
    }
    @Override
    public int compareTo(Citizen o) {
        return fullName.compareTo(o.fullName);
    }

    @Override
    public String toString() {
        String residentStatus = isResident() ? "Resident" : "Non-Resident";
        return String.format("| %5s %-20s\t%c\t%d\t%-50s\t%-20s\t%-40s %-10d | \n", "",
                fullName, gender, age, email, residentStatus, address, district);
    }
}
