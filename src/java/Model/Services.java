package Model;


public class Services {
    
    private int id;
    private String name;
    private String description;
    private String servicetype_id;

    public Services() {
    }

    public Services(String name, String description, String servicetype_id) {
        this.name = name;
        this.description = description;
        this.servicetype_id = servicetype_id;
    }

    public Services(int id, String name, String description, String servicetype_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.servicetype_id = servicetype_id;
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

    public String getServicetype_id() {
        return servicetype_id;
    }

    public void setServicetype_id(String servicetype_id) {
        this.servicetype_id = servicetype_id;
    }

   
    
}
