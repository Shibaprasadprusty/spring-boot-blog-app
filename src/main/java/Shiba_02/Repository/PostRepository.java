package Shiba_02.Repository;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import Shiba_02.AllEntity.Post;

public interface PostRepository  extends JpaRepository<Post, Integer>{

	 List<Post> findByUser(User user);
}
