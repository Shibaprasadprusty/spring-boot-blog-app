package Shiba_02.Service;

import Shiba_02.AllEntity.User;

public interface UserService {


	// take user object //  save into DB //  return saved user 
	User registerUser(User user);
	
	User loginUser(String email, String pwd);
}
