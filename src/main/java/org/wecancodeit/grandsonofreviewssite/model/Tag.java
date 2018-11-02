package org.wecancodeit.grandsonofreviewssite.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	private String tagName;

	@JoinTable
	@ManyToMany
	private List<Review> reviews = new ArrayList<Review>();

	public Tag() {
	}

	public Tag(String tagName) {
		this.tagName = tagName;
	}

	public Tag(String tagName, Review review) {
		this.tagName = tagName;
		addReview(review);
	}

	public Long getId() {
		return id;
	}

	public String getTagName() {
		return tagName;
	}

	public void addReview(Review review) {
		reviews.add(review);
	}

	public List<Review> getReviews() {
		return reviews;
	}

}
