package Model;

public class Customer extends UserCredentials {

    private int id;
    private String name;
    private String nic;
    private String address;
    private String userName;
    private String contactNo;
    
    public Customer() {

    }

    public Customer(String email, String password) {
       this.email = email;
       this.password = password;
    }
    
    

    public Customer(String name, String nic, String userName, String password, String address, String email, String contactNo) {
        this.name = name;
        this.nic = nic;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
       
    }

    public Customer(int id, String name, String nic, String userName, String password, String address, String email, String contactNo) {
        this.id = id;
        this.name = name;
        this.nic = nic;
         this.userName = userName;
         this.password = password;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
       
    }

    public Customer(int id, String nic, String userName) {
        this.id = id;
        this.nic = nic;
        this.userName = userName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    
    

}

