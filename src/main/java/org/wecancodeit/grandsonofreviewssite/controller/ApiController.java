package org.wecancodeit.grandsonofreviewssite.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.grandsonofreviewssite.model.Tag;
import org.wecancodeit.grandsonofreviewssite.repository.ReviewRepository;
import org.wecancodeit.grandsonofreviewssite.repository.TagRepository;

@RestController
public class ApiController {

	@Autowired
	TagRepository tagRepo;

	@Autowired
	ReviewRepository reviewRepo;

	@GetMapping("/api/reviews/{id}")
	public Collection<Tag> getTagsForReview(@PathVariable(value = "id") Long id) {
		return reviewRepo.findById(id).get().getTags();
	}
}
