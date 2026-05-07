package Shiba_02.AllEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "USER_TBL")
@Setter
@Getter 
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;
	
  private String fname;
  
  private String lname;
  
  private String email;
  
  private String pwd;
 /* 
  * ------ its not mandatory 
  @OneToMany(mappedBy = "user")
   private List<Post> posts;
   */

public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	this.pwd = pwd;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", pwd=" + pwd
			+ "]";
}
}
