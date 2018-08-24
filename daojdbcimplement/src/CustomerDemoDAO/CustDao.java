package CustomerDemoDAO;
import java.util.List;
import bean.*;

public interface CustDao 
{
    public List<CustomerPojo> getAllCustomers();
    public CustomerPojo getCustomer(int Id);
    public void UpdateCustomer(CustomerPojo custPojo);
    public void DeleteCustomer(int Id);
    public void InsertCustomer(CustomerPojo custPojo  );
    public CustomerPojo Search(int id);
           
}
