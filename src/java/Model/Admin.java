package Model;

public class Admin extends Employee{
     private String managerId;
     
     public Admin(){
         
     }

    public Admin(String email, String password) {
        super(email, password);
    }

    public Admin(int id, String name, String nic, String email, String password, String branchId) {
        super(id, name, nic, email, password, branchId);
    }

    public Admin(String name, String nic, String email, String password, String managerId, String branchId) {
         super( name, nic, email, password, branchId);
         this.managerId = managerId;
    }
    
    public Admin(int id,String name, String nic, String email, String password,String image, String branchId) {
         super(id, name, nic, email, password, image, branchId);
    }

    public Admin(int id, String name, String nic, String email, String image) {
        super(id, name, nic, email, image); 
    }

    public Admin(int id, String name, String nic, String email) {
         super(id, name, nic, email); 
    }
    
    public Admin(int id, String name, String image) {
         super(id, name, image); 
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
     
}

