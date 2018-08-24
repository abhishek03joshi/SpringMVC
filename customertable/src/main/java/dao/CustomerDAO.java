package dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import beans.Customer;

public class CustomerDAO {

	private String jdbcURL=" ";
	private String jdbcUsername=" ";
	private String jdbcPassword=" ";
	private Connection jdbcConnection;
	
	
	public CustomerDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		// TODO Auto-generated constructor stub
		this.jdbcURL=jdbcURL;
		this.jdbcUsername=jdbcUsername;
		this.jdbcPassword=jdbcPassword;

	}
	
	protected void connect () throws SQLException {
		if(jdbcConnection==null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch(ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection=DriverManager.getConnection(jdbcURL, jdbcUsername,jdbcPassword);
		}
	}
	
	protected void disconnect() throws SQLException{
		if(jdbcConnection!=null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public boolean insertCustomer (Customer cus)throws SQLException{
		String sql = "INSERT INTO test.customer (id,name,mobile) VALUES (?,?,?);";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setInt(1, cus.getId());
		statement.setString(2, cus.getName());
		statement.setString(3, cus.getMobile());
		
		boolean rowInserted = statement.executeUpdate()>0;
		
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<Customer> listAllCustomers() throws SQLException{
		List<Customer> listCus=new ArrayList<Customer>();
		
		String sql = "SELECT id, name, mobile FROM test.customer";
		
		connect();
		
		Statement statement=jdbcConnection.createStatement();
		ResultSet resultset = statement.executeQuery(sql);
		
		while(resultset.next()) {
			
			int id = resultset.getInt("id");
			String name = resultset.getString("name");
			String mobile = resultset.getString("mobile");
			
			Customer cus = new Customer();
			
			System.out.println(id);
			System.out.println(name);
			System.out.println(mobile);
			cus.setId(id);
			cus.setName(name);
			cus.setMobile(mobile);
			listCus.add(cus);
			System.out.println("In list");
			
		}
		
		resultset.close();
		statement.close();
		disconnect();
		return listCus;
		
	}
	
	public boolean deleteCustomer(int cusID) throws SQLException{
		String sql = "DELETE FROM test.customer WHERE id=?;";
		
		connect();
		
		PreparedStatement statement=jdbcConnection.prepareStatement(sql);
		statement.setInt(1, cusID);
		
		boolean rowDeleted=statement.executeUpdate()>0;
		statement.close();
		disconnect();
		return rowDeleted;
		
	}
	
	public boolean updateCustomer(Customer cus)throws SQLException
	{
		
		System.out.println("Update");
		
		String sql="UPDATE test.customer set name=?,mobile=? where id=?;";
		connect();
		
		PreparedStatement statement=jdbcConnection.prepareStatement(sql);
		
		
		statement.setString(1, cus.getName());
		statement.setString(2, cus.getMobile());
		statement.setInt(3, cus.getId());
		
		boolean rowUpdated=statement.executeUpdate()>0;
		
		statement.close();
		disconnect();
		return rowUpdated;
	}
	
	
	public Customer getCustomer(int id) throws SQLException
	{
		Customer cus = null;
		
		String sql = "SELECT * FROM test.customer WHERE id = ?;";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultset = statement.executeQuery();

		if (resultset.next())
		{

			int cus_id = resultset.getInt("id");
			String name = resultset.getString("name");
			String mobile = resultset.getString("mobile");
			
			cus = new Customer();
			
			cus.setId(cus_id);
			cus.setName(name);
			cus.setMobile(mobile);
			
		}
		
		resultset.close();
		statement.close();
		return cus;
	}
	
	
	public Customer getCustomer(String mobile) throws SQLException
	{
		Customer cus = null;
		
		String sql = "SELECT * FROM test.customer WHERE mobile = ?;";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, mobile);

		ResultSet resultset = statement.executeQuery();

		if (resultset.next())
		{

			int cus_id = resultset.getInt("id");
			String name = resultset.getString("name");
			String strmobile = resultset.getString("mobile");
			
			cus = new Customer();
			
			cus.setId(cus_id);
			cus.setName(name);
			cus.setMobile(strmobile);
			
		}
		
		resultset.close();
		statement.close();
		return cus;
	}


}
