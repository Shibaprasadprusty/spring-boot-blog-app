package Shiba_02.ServiceImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Shiba_02.AllEntity.Post;
import Shiba_02.Repository.PostRepository;
import Shiba_02.Service.PostService;

@Service
public class PostServiceImpl implements PostService { 

	@Autowired
	private PostRepository postRepo;

	@Override
	public Post savePost(Post post) {

		return postRepo.save(post);
	}
	@Override
	public List<Post> getAllPosts() {

		return postRepo.findAll();
	}
	
	@Override
	public void deletePost(Integer postId) {

		postRepo.deleteById(postId);
	}
	
	@Override
	public Post getPostById(Integer postId) {

		return postRepo.findById(postId).orElse(null);
	}

	@Override
	public Post updatePost(Post post) {

		return postRepo.save(post);
	}
}