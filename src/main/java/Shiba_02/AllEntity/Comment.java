package Shiba_02.AllEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name="COMMENT_TBL")
@Entity

public class Comment {
 
	 @Id
	 @GeneratedValue(strategy =GenerationType.IDENTITY)
	 private Integer id;
	 
	 private String name;
	 
	 private String email;
	 
	 public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreatetedOn() {
		return createtedOn;
	}

	public void setCreatetedOn(LocalDate createtedOn) {
		this.createtedOn = createtedOn;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Lob
	 private String content;
	 
	 @CreationTimestamp
	 private LocalDate createtedOn;
	 
	 @ManyToOne
	 @JoinColumn(name = "post_id")
	 private Post post;

	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", email=" + email + ", content=" + content + ", createtedOn="
				+ createtedOn + ", post=" + post + "]";
	}
	 
}
