package Model;


public abstract class UserCredentials {
    
    protected String email;
    protected String password;
    
    public UserCredentials(){
        
    }
    
    public abstract String getEmail();

    public abstract void setEmail(String email);

    public abstract String getPassword();

    public abstract void setPassword(String password);
    
}
