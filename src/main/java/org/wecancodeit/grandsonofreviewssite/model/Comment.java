package org.wecancodeit.grandsonofreviewssite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.wecancodeit.grandsonofreviewssite.model.Review;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String content;

	@JsonIgnore
	@ManyToOne
	private Review review;

	public Comment() {

	}

	public Comment(String username, String content) {
		this.username = username;
		this.content = content;
	}

	private String getUsername() {
		return username;
	}

	private String getContent() {
		return content;
	}

}
