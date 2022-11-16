package Model;

public class Employee extends UserCredentials {

    private int id;
    private String name;
    private String nic;
    private String image;
    private String branchId;

    public Employee() {

    }

    public Employee(String email, String password) {
       this.email = email;
       this.password = password;
    }

    public Employee(int id, String name, String nic, String email, String password, String branchId) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.password = password;
        this.branchId = branchId;
    }

    public Employee(String name, String nic, String email, String password, String branchId) {
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.password = password;
        this.branchId = branchId;
    }

    public Employee(int id, String name, String nic, String email, String password, String image, String branchId) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.password = password;
        this.image = image;
        this.branchId = branchId;
    }

    public Employee(int id, String name, String nic, String email, String image) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.email = email;
        this.image = image;
    }

    public Employee(int id, String name, String nic, String email) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.email = email;
    }
    
     public Employee(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

}
