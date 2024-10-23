package MODEL;

public class WEBMODEL {

	int id;
	String name;
	String email;
	String Password;

	public WEBMODEL(int id, String name, String email, String password) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.Password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public WEBMODEL() {

	}

	@Override
	public String toString() {
		return "WEBMODEL [id=" + id + ", name=" + name + ", email=" + email + ", Password=" + Password + "]";
	}

}
