package Shiba_02.ServiceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Shiba_02.AllEntity.Comment;
import Shiba_02.Repository.CommentRepository;
import Shiba_02.Service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository commentRepo;

	@Override
	public Comment saveComment(Comment comment) {

		return commentRepo.save(comment);
	}

}
