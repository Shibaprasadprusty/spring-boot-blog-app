package Shiba_02.ServiceImplement;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import Shiba_02.AllEntity.User;
import Shiba_02.Repository.UserRepository;
import Shiba_02.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User registerUser (User user) {

		return userRepo.save(user);
	}
	@Override
	public User loginUser(String email, String pwd) {

		User user = userRepo.findByEmail(email);

		if(user != null && user.getPwd().equals(pwd)) {

			return user;
		}

		return null;
	}


}