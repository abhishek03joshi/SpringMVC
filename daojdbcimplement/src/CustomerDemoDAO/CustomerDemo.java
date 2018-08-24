package CustomerDemoDAO;
import bean.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class CustomerDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int Id;
        String strName;
        
        String Mobile;
        
        // TODO code application logic here
 
        List<CustomerPojo> c=new ArrayList<CustomerPojo>();
        CustDao custdao=new CustomerImpl();
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter Customer Name");
        strName=sc.next();
        System.out.println("Please Enter Customer Id");
        Id=sc.nextInt();
        System.out.println("Please Enter Customer Mobile Number");
        Mobile=sc.next();
        
       CustomerPojo custPojo=new CustomerPojo();
       //custPojo=custdao.Search(Id);
       
       //System.out.println("Name :"+custPojo.getName());
       //System.out.println("Id   :"+custPojo.getId());
       //System.out.println("Mobile  :"+custPojo.getMobile());
       custPojo.setId(Id);
       custPojo.setName(strName);
       custPojo.setMobile(Mobile);
       //custdao.InsertCustomer(custPojo);
       custdao.UpdateCustomer(custPojo);
       //custdao.DeleteCustomer(Id);
        
        System.out.println("Displaying all Customers");
        c=custdao.getAllCustomers();
        System.out.print("After getting all customers");
        Iterator itr=c.iterator();
   while(itr.hasNext())
        {
           CustomerPojo cp=(CustomerPojo)itr.next();
            System.out.println(cp.getName()+" "+cp.getId()+" "+cp.getMobile());
        }
        
        
    }
    
}
