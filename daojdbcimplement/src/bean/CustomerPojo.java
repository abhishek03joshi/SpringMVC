package bean;
public class CustomerPojo
{
    private int Id;
    private String Name;
    private String Mobile;
    
  public CustomerPojo(int Id,String Name,String Mobile)
    {
        this.Id=Id;
        this.Name=Name;
        this.Mobile=Mobile;
    }

    public CustomerPojo()
    {}
    
    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }
    
    
}
