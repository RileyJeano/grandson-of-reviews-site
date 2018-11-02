package org.wecancodeit.grandsonofreviewssite.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.grandsonofreviewssite.model.Category;
import org.wecancodeit.grandsonofreviewssite.model.Comment;
import org.wecancodeit.grandsonofreviewssite.model.Tag;
import org.wecancodeit.grandsonofreviewssite.repository.CategoryRepository;
import org.wecancodeit.grandsonofreviewssite.repository.PostRepository;
import org.wecancodeit.grandsonofreviewssite.repository.ReviewRepository;
import org.wecancodeit.grandsonofreviewssite.repository.TagRepository;

@Controller
public class ReviewController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@Autowired
	PostRepository postRepo;

	@Autowired
	TagRepository tagRepo;

	@RequestMapping("categories")
	public String listCourses(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}

	@RequestMapping("categories/{id}")
	public String listPerson(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("category", categoryRepo.findById(id).get());
		model.addAttribute("categories", categoryRepo.findAll());
		return "category";
	}

	@RequestMapping("/reviews")
	public String getContacts(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		model.addAttribute("categories", categoryRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/reviews/{id}")
	public String getContact(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("review", reviewRepo.findById(id).get());
		model.addAttribute("categories", categoryRepo.findAll());
		return "review";
	}

	@PostMapping("/reviews/{id}")
	public String addComment(@PathVariable(value = "id") Long id, String username, String content, Model model) {
		postRepo.save(new Comment(username, content, reviewRepo.findById(id).get()));
		return "redirect:/reviews/{id}";
	}

	@PostMapping("/reviews/{id}/tag")
	public String addTag(@PathVariable(value = "id") Long id, String tagName, Model model) {
		Tag tag = new Tag(tagName);
		reviewRepo.findById(id).get().addTag(tag);
		tagRepo.save(tag);
		return "redirect:/reviews/{id}";
	}

}
