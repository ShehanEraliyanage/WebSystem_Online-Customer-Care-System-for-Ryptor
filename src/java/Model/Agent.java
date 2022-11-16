package Model;

public class Agent extends Employee {

    public Agent() {

    }

    public Agent(String email, String password) {
        super(email, password);
    }

    public Agent(int id, String name, String nic, String email, String password, String branchId) {
        super(id, name, nic, email, password, branchId);
    }

    public Agent(String name, String nic, String email, String password, String branchId) {
        super(name, nic, email, password, branchId);
    }

    public Agent(int id, String name, String nic, String email, String password, String image, String branchId) {
        super(id, name, nic, email, password, image, branchId);
    }

    public Agent(int id, String name, String nic, String email, String image) {
        super(id, name, nic, email, image);
    }

    public Agent(int id, String name, String nic, String email) {
        super(id, name, nic, email);
    }
    
    public Agent(int id, String name, String image) {
        super(id, name, image);
    }

}

