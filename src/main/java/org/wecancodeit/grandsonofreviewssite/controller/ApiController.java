package org.wecancodeit.grandsonofreviewssite.controller;

import java.util.Collection;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.grandsonofreviewssite.model.Review;
import org.wecancodeit.grandsonofreviewssite.model.Tag;
import org.wecancodeit.grandsonofreviewssite.repository.ReviewRepository;
import org.wecancodeit.grandsonofreviewssite.repository.TagRepository;

@CrossOrigin
@RestController
public class ApiController {

	@Autowired
	TagRepository tagRepo;

	@Autowired
	ReviewRepository reviewRepo;

	// get rid of fancy stuff
	@GetMapping("/api/reviews/{id}")
	public Collection<Tag> getTagsForReview(@PathVariable(value = "id") Long id) {
		System.out.println(id);
		System.out.println(reviewRepo.findById(id).get().getTags());
		return reviewRepo.findById(id).get().getTags();
	}

	@PostMapping("/api/reviews/{id}/tags/add")
	public Collection<Tag> addTag(@PathVariable(value = "id") Long id, @RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String tagName = json.getString("tagName");
		Review review = reviewRepo.findById(id).get();
		if (tagRepo.findByTagName(tagName) == null) {
			Tag tag = new Tag(tagName, review);
			review.addTag(tag);
			tagRepo.save(tag);
			System.out.println("making a new tag");
		}

		else {
			Tag tag = tagRepo.findByTagName(tagName);
			tag.addReview(review);
			review.addTag(tag);
			tagRepo.save(tag);
			System.out.println("Saving existing tag to review");
		}

		return review.getTags();
	}

	@PostMapping("/api/review/{id}/tags/remove")
	public void removeTag(@PathVariable(value = "id") Long id, @RequestBody String body) throws JSONException {
		System.out.println(body);
		JSONObject json = new JSONObject(body);
		String tagName = json.getString("tagName");
		Review review = reviewRepo.findById(id).get();
		Tag tag = tagRepo.findByTagName(tagName);
		if (tag != null) {
			review.removeTag(tag);
			tag.removeReview(review);
			reviewRepo.save(review);
		}
	}
}
