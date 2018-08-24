package CustomerDemoDAO;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import bean.*;


public class CustomerImpl implements CustDao
{
    
        CustomerPojo custPojo = null;
    List<CustomerPojo> Customers;
    public void InsertCustomer(CustomerPojo custPojo)
    {
        
        try
        {
	        List<CustomerPojo> Customers = new ArrayList<CustomerPojo>();
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection con;
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	        PreparedStatement ps=con.prepareStatement("insert into test.Customer (`ID`,`Name`,`Mobile`)"+"Values(?,?,?)");//creates a dynamic place holder.
	        //prepare only needs to compile once. That is why is use it. It could execute again and again. prepare statement is secure. 
	        ps.setInt(1, custPojo.getId());
	        ps.setString(2, custPojo.getName());
	        ps.setString(3, custPojo.getMobile());
	        ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("Error");
        }
    }
        
    
    public CustomerPojo getCustomer(int id){     
        CustomerPojo c=null;
        return c;
        }
        
    public void UpdateCustomer(CustomerPojo custPojo)
    {
         try
        {
        
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection con;
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	        
	        Statement stmt=con.createStatement();
	        String sql="Update Customer set name="+"'"+custPojo.getName()+"'"+ ","+ "Mobile="+"'"+custPojo.getMobile()+"'"+ "where id="+custPojo.getId();
	        stmt.executeUpdate(sql);
	        con.close();
        
        }
            catch(ClassNotFoundException e)
            {
                System.out.println("Illegal Values");
            }
            catch(SQLException e)
            {
                System.out.println("SQL Exception");
            }
            catch(IllegalAccessException e)
            {
                System.out.println("Illegal Access Exception");
            } 
	         catch (InstantiationException ex) {
	            Logger.getLogger(CustomerImpl.class.getName()).log(Level.SEVERE, null, ex);
	        }
       }
        public void DeleteCustomer(int Id)
        {
	         try
	        {
        
		        Class.forName("com.mysql.jdbc.Driver").newInstance();
		        Connection con;
		        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		           
		        Statement stmt=con.createStatement();
		        String sql="Delete from test.Customer where ID= "+ Id;
		         System.out.println(sql);
		         stmt.execute(sql);
		         con.close();
	        }
	         catch(SQLException e)
	         {
	             System.out.println("SQL Exception");
	         }
	         catch(ClassNotFoundException e)
	         {
	             System.out.println("Class Not Found Exception");
	         } catch (InstantiationException ex) {
	            Logger.getLogger(CustomerImpl.class.getName()).log(Level.SEVERE, null, ex);
	         } catch (IllegalAccessException ex) {
	            Logger.getLogger(CustomerImpl.class.getName()).log(Level.SEVERE, null, ex);
	        }
        }
                
public CustomerPojo Search(int id)
        {
            try
            {
                
               
		        Class.forName("com.mysql.jdbc.Driver").newInstance();
		        Connection con;
		        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		        Statement ps=con.createStatement();
		        String sql;
		        sql="SELECT * FROM Customer where ID ="+id;
		        ResultSet rs=ps.executeQuery(sql);
		    
		        while(rs.next())
		        {
		        	// System.out.println(rs.getInt("id"));
		        	// System.out.println(rs.getString("name"));
		            
		            custPojo = new CustomerPojo();
		            custPojo.setId(rs.getInt("id"));
		            custPojo.setName(rs.getString("name"));
		            custPojo.setMobile(rs.getString("mobile"));
		        
		        }
    
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
            catch(IllegalAccessException e)
            {
                
            }
            catch(ClassNotFoundException e)
            {
                
            } catch (InstantiationException ex) {
            Logger.getLogger(CustomerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return custPojo;
     }
        
        
        
public List<CustomerPojo> getAllCustomers()
     {
          try
        {
	        Customers = new ArrayList<CustomerPojo>();
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
	        Connection con;
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	        String sql;
	        sql="SELECT * FROM test.Customer";
	        PreparedStatement ps=con.prepareStatement(sql);
	        ResultSet rs=ps.executeQuery();
	        while(rs.next())
	        {
	        // System.out.println(rs.getInt("id"));
	            
	            CustomerPojo custPojo = new CustomerPojo();
	            custPojo.setId(rs.getInt("ID"));
	            custPojo.setName(rs.getString("Name"));
	            custPojo.setMobile(rs.getString("Mobile"));
	            Customers.add(custPojo);//adding the object to the ArrayList of objects
	       
	        }
	        return Customers;
	        //con.close();
        
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return Customers;
     }
        
 }
        
        

