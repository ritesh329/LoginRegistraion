package DBDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import MODEL.WEBMODEL;



//this is UserLogin class 

public class UserDAO {

	    private Connection con;
	    private String query;
	    private ResultSet res;
	    private PreparedStatement pst;
	    
	    public UserDAO (Connection connection) {

			this.con = connection;
		}
	    
	    public WEBMODEL userlogin(String name, String password) {

	    	
	    
	    		
	    	WEBMODEL user = null;

	    		try {

	    			query = "select * from user where name=? and pass=?";
	    			pst = this.con.prepareStatement(query);
	    			pst.setString(1, name);
	    			pst.setString(2, password);
	    			res = pst.executeQuery();

	    			if (res.next()) {

	    				user = new WEBMODEL();
	    				user.setName(res.getString("name"));
                        user.setPassword(res.getString("pass"));
	    			}

	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		     return user;
	    		}
	    		return user;

	    	
	    	

		}
	    
	   
	    
	    
}
