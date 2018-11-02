package org.wecancodeit.grandsonofreviewssite.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.grandsonofreviewssite.repository.CategoryRepository;
import org.wecancodeit.grandsonofreviewssite.repository.ReviewRepository;

@Controller
public class ReviewController {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

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
}
