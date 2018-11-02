package org.wecancodeit.grandsonofreviewssite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.grandsonofreviewssite.model.Tag;
import org.wecancodeit.grandsonofreviewssite.repository.TagRepository;

@RestController
public class ApiController {

	@Autowired
	TagRepository tagRepo;

	@GetMapping("/api/reviews/{id}")
	public Tag getTagsForReview(@PathVariable(value = "id") Long id) {
		return tagRepo.findById(id).get();
	}
}
