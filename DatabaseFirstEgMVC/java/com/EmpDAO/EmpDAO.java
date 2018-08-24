package com.EmpDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper; 

import com.Employee.Beans.Employee;


public class EmpDAO {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	
	
	public int save(Employee p) {
		String sql = "INSERT INTO Emp99 (name,salary,designation) VALUES('"+p.getName()+"','"+p.getSalary()+"','"+p.getDesignation()+"')";
		return template.update(sql);
		
	}
	
	public int update(Employee p){  
	    String sql="update Emp99 set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where ID="+p.getID()+"";  
	    return template.update(sql);  
	}
	
	public int delete(int id){  
	    String sql="delete from Emp99 where ID="+id+"";  
	    return template.update(sql);  
	}  
	public Employee getEmpById(int id){  
	    String sql="select ID,name,salary,designation from Emp99 where ID=?"; 
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public List<Employee> getEmployees(){  
	    return template.query("select * from Emp99",new RowMapper<Employee>(){  
	        public Employee mapRow(ResultSet rs, int row) throws SQLException {  
	        	Employee e=new Employee();  
	            e.setID(rs.getInt(1));  
	            e.setName(rs.getString(2));  
	            e.setSalary(rs.getFloat(3));  
	            e.setDesignation(rs.getString(4));  
	            return e;  
	        }  
	    });  
	}
	

}
