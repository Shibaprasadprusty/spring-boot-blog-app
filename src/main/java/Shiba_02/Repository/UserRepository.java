package Shiba_02.Repository;

import Shiba_02.AllEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	 User findByEmail(String email);
}
