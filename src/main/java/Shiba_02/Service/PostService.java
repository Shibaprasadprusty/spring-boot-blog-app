package Shiba_02.Service;

import java.util.List;

import Shiba_02.AllEntity.Post;

public interface PostService {

	Post savePost(Post post);
	
	List<Post> getAllPosts();
	
	void deletePost(Integer postId);
	
	Post getPostById(Integer postId);
	
	Post updatePost(Post post);
	
}
