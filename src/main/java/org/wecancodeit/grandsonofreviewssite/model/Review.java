package org.wecancodeit.grandsonofreviewssite.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Lob;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	private String reviewName;
	@Lob
	private String reviewDescription;
	private String recomendation;
	private String reviewRating;
	private String reviewImage;

	@ManyToOne
	private Category category;

	@OneToMany(mappedBy = "Review")
	private Collection<Comment> comments;

	public Review() {
	}

	public Review(String reviewName, String reviewDescription, String recomendation, String reviewRating,
			String reviewImage, Category category) {
		this.reviewName = reviewName;
		this.reviewDescription = reviewDescription;
		this.recomendation = recomendation;
		this.reviewRating = reviewRating;
		this.reviewImage = reviewImage;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public String getReviewName() {
		return reviewName;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	public String getRecomendation() {
		return recomendation;
	}

	public String getReviewRating() {
		return reviewRating;
	}

	public String getReviewImage() {
		return reviewImage;
	}

	public Category getCategory() {
		return category;
	}

}
