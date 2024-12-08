package data;

public interface ActorADT {
    public void setName(String byVal_name);
    public void setSurname(String byVal_surname);
    public void setUsername(String byVal_username);
    public void setPassword(String byVal_password);
    public String getName();
    public String getSurname();
    public String getFullName();
    public String getUsername();
    public String getPassword();
    public String getCustomerId();
    public Boolean hasValidInformation(String username, String password);
}
