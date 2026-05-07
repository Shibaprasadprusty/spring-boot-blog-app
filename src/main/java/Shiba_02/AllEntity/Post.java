package Shiba_02.AllEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="POST_TBL")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	private String title;
	
	private String description;
	
	
	// its for blog content  
	@Lob
	private String content;
	
	// when the blog is create 
	@CreationTimestamp
	private LocalDate createdOn;
	
	// when blog is updated 
	@UpdateTimestamp
	private LocalDate updatedOn;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.REMOVE)
	private List<Comment> comments;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		this.updatedOn = updatedOn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", description=" + description + ", content=" + content
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", user=" + user + ", comments=" + comments
				+ "]";
	}
}
