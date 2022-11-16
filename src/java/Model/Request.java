package Model;

public class Request {

    private int id;
    private String title;
    private String request;
    private int customer_id;
    private String number;
    private String date_time;
    private int agent_id;
    private int admin_id;
    private int manager_id;
    private int status;

    public Request() {
        
    }

    public Request(int id, String title, String request, int customer_id, String number, String date_time, int agent_id, int admin_id, int manager_id, int status) {
        this.id = id;
        this.title = title;
        this.request = request;
        this.customer_id = customer_id;
        this.number = number;
        this.date_time = date_time;
        this.agent_id = agent_id;
        this.admin_id = admin_id;
        this.manager_id = manager_id;
        this.status = status;
    }
    
     public Request(String title, String request, int customer_id, String number, int agent_id) {

        this.title = title;
        this.request = request;
        this.customer_id = customer_id;
        this.number = number;
        this.agent_id = agent_id;

    }
    
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    

}
