package beans;

public class Customer {
	
	private int id=0;
	private String name=" ";
	private String mobile=" ";





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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	


	public Customer() {
		
	}
	
	public Customer(int cus_id) {
		this.id=cus_id;
	}

}
