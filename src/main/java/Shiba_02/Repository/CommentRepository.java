package Shiba_02.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Shiba_02.AllEntity.Comment;
import Shiba_02.AllEntity.Post;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
 
	List<Comment>findByPost(Post post);
}
