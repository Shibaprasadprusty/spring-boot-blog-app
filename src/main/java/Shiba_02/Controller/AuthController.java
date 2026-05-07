package Shiba_02.Controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Shiba_02.AllEntity.Comment;
import Shiba_02.AllEntity.Post;

import Shiba_02.AllEntity.User;
import Shiba_02.Service.CommentService;
import Shiba_02.Service.PostService;
import Shiba_02.Service.UserService;


@Controller
public class AuthController {
	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;
	
	
	@Autowired
	private CommentService commentService;
	
	// LOAD REGISTER PAGE
	@GetMapping("/register")
	public String loadRegisterPage(Model model) {

		model.addAttribute("user", new User());

		return "register";
	}
	// login page 
	@GetMapping("/login")
	public String loadLoginPage() {

		return "login";
	}
	// Post page
	@GetMapping("/createPost")
	public String loadCreatePostPage(Model model) {

		model.addAttribute("post", new Post());

		return "create-post";
	}
	
	@GetMapping("/dashboard")
	public String dashboardPage(Model model) {

		model.addAttribute("posts",
				postService.getAllPosts());

		return "dashboard";
	}
	
	//  delete post 
	@GetMapping("/deletePost/{id}")
	public String deletePost(@PathVariable("id") Integer id) {

		postService.deletePost(id);

		return "redirect:/dashboard";
	}
	
	
	// View post Logic 
	
	@GetMapping("/viewPost/{id}")
	public String viewPost(@PathVariable("id") Integer id,
			               Model model) {

		Post post = postService.getPostById(id);

		model.addAttribute("post", post);

		model.addAttribute("comment", new Comment());

		return "view-post";
	}
	
	// Edit Post
	@GetMapping("/editPost/{id}")
	public String editPost(@PathVariable("id") Integer id,
			               Model model) {

		Post post = postService.getPostById(id);

		model.addAttribute("post", post);

		return "edit-post";
	}
	
	
	
	// SAVE USER
		@PostMapping("/saveUser")
		public String saveUser(@ModelAttribute("user") User user,
				               Model model) {

			userService.registerUser(user);

			model.addAttribute("successMsg",
					"Registration Successful");

			return "register";
 }
		@PostMapping("/login")
		public String loginUser(@ModelAttribute User user,
				                Model model) {

			User validUser =
					userService.loginUser(
							user.getEmail(),
							user.getPwd());

			
			// LOGIN SUCCESS
			if(validUser != null) {

				model.addAttribute("successMsg",
						"Login Successful");

				return "dashboard";
			}

			
			// LOGIN FAILED
			model.addAttribute("errorMsg",
					"Invalid Email & Password");

			return "login";
		}
		@PostMapping("/savePost")
		public String savePost(@ModelAttribute Post post,
				               Model model) {

			postService.savePost(post);

			model.addAttribute("successMsg",
					"Post Saved Successfully");

			model.addAttribute("post", new Post());

			return "create-post";
		}
		
		// UPDATE POST 
		@PostMapping("/updatePost")
		public String updatePost(@ModelAttribute Post post) {

			postService.updatePost(post);

			return "redirect:/dashboard";
		}
		
		@PostMapping("/saveComment")
		public String saveComment(@ModelAttribute Comment comment,
				                  @RequestParam("postId") Integer postId) {

			Post post = postService.getPostById(postId);

			comment.setPost(post);

			commentService.saveComment(comment);

			return "redirect:/viewPost/" + postId;
		}

}