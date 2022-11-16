package Model;

public class Packages {
    
    private int id;
    private String name;
    private String description;
    private String price;
    private int validityPeriod;
    private String antData;
    private String nigthtData;
    private String packageType;

    public Packages() {
    }

    public Packages(String name, String description, String price, int validityPeriod, String antData, String nigthtData, String packageType) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.validityPeriod = validityPeriod;
        this.antData = antData;
        this.nigthtData = nigthtData;
        this.packageType = packageType;
    }

    public Packages(int id, String name, String description, String price, int validityPeriod, String antData, String nigthtData, String packageType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.validityPeriod = validityPeriod;
        this.antData = antData;
        this.nigthtData = nigthtData;
        this.packageType = packageType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(int validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getAntData() {
        return antData;
    }

    public void setAntData(String antData) {
        this.antData = antData;
    }

    public String getNigthtData() {
        return nigthtData;
    }

    public void setNigthtData(String nigthtData) {
        this.nigthtData = nigthtData;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

   
    
    
    
}
