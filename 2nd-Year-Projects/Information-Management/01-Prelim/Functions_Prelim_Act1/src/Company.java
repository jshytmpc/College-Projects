import java.util.Comparator;

public class Company {
    /**
     * Declaration
     */

    private final int index;
    private final String orgId;
    private final String name;
    private final String website;
    private final String country;
    private final int date;
    private final String industry;
    private final int numEmployees;

    /**
     * setters
     */

    public Company(int index, String orgId, String name, String website, String country, int date, String industry, int numEmployees) {
        this.index = index;
        this.orgId = orgId;
        this.name = name;
        this.website = website;
        this.country = country;
        this.date = date;
        this.industry = industry;
        this.numEmployees = numEmployees;
    }

    /**
     * Getters
     */

    public int getIndex() {
        return index;
    }
    public String getName() {
        return name;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getWebsite() {
        return website;
    }

    public String getCountry() {
        return country;
    }

    public int getDate() {
        return date;
    }

    public String getIndustry() {
        return industry;
    }

    public int getNumEmployees() {
        return numEmployees;
    }



    /**
     * toString for conversion
     */

    @Override
    public String toString() {
        return "Company " + index + "[ " +
                " Organization ID = " + orgId +
                ", Name = '" + name + '\'' +
                ", Website = '" + website + '\'' +
                ", Country = '" + country + '\'' +
                ", Founded = " + date +
                ", Industry = '" + industry + '\'' +
                ", Number of Employees = " + numEmployees +
                ']';
    }
}

class orgIdCompare implements Comparator<Company> {
    @Override
    public int compare(Company oI1, Company oI2) {
        return  oI1.getOrgId().compareTo(oI2.getOrgId());
    }
}
class nameCompare implements Comparator<Company> {
    @Override
    public int compare(Company n1, Company n2) {
        return  n1.getName().compareTo(n2.getName());
    }
}

class webCompare implements Comparator<Company> {
    @Override
    public int compare(Company w1, Company w2) {
        return  w1.getWebsite().compareTo(w2.getWebsite());
    }
}

class countryCompare implements Comparator<Company> {
    @Override
    public int compare(Company c1, Company c2) {
        return c1.getCountry().compareTo(c2.getCountry());
    }
}

class dateCompare implements Comparator<Company> {
    @Override
    public int compare(Company d1, Company d2) {
        return d1.getDate() - d2.getDate();
    }
}

class indusCompare implements Comparator<Company> {
    @Override
    public int compare(Company i1, Company i2) {
        return  i1.getIndustry().compareTo(i2.getIndustry()) ;
    }
}

class numEmpCompare implements  Comparator<Company> {
    @Override
    public int compare(Company nE1, Company nE2) {
        return nE1.getNumEmployees() - nE2.getNumEmployees();
    }
}



