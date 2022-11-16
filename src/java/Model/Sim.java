
package Model;


public class Sim {
    
    private int id;
    private String simNumber;
    private int status;
    private String customerNIC;

    public Sim() {
    }

    public Sim(String simNumber, int status, String customerNIC) {
        this.simNumber = simNumber;
        this.status = status;
        this.customerNIC = customerNIC;
    }

    public Sim(int id, String simNumber, String customerNIC) {
        this.id = id;
        this.simNumber = simNumber;
        this.customerNIC = customerNIC;
    }
    
    

    public Sim(int id, String simNumber, int status, String customerNIC) {
        this.id = id;
        this.simNumber = simNumber;
        this.status = status;
        this.customerNIC = customerNIC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCustomerNIC() {
        return customerNIC;
    }

    public void setCustomerNIC(String customerNIC) {
        this.customerNIC = customerNIC;
    }
    
    
    
}
