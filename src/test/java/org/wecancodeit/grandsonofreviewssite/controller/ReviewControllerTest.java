package org.wecancodeit.grandsonofreviewssite.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.grandsonofreviewssite.controller.ReviewController;
import org.wecancodeit.grandsonofreviewssite.model.Category;
import org.wecancodeit.grandsonofreviewssite.model.Review;
import org.wecancodeit.grandsonofreviewssite.repository.CategoryRepository;
import org.wecancodeit.grandsonofreviewssite.repository.ReviewRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ReviewRepository reviewRepo;
	@MockBean
	private CategoryRepository categoryRepo;

	@Mock
	Review reviewOne;

	@Mock
	Category categoryOne;

	@Test
	public void shouldBeOkWhenAccessingRewiews() throws Exception {
		mockMvc.perform(get("/reviews")).andExpect(status().isOk());
	}

	@Test
	public void shouldBeOkWhenAccessingCategories() throws Exception {
		mockMvc.perform(get("/categories")).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnReviewsTemplateWhenAccessingReviews() throws Exception {
		mockMvc.perform(get("/reviews")).andExpect(view().name("reviews"));
	}

	@Test
	public void shouldReturnCategoriesTemplateWhenAccessingCategories() throws Exception {
		mockMvc.perform(get("/categories")).andExpect(view().name("categories"));
	}
	/*
	 * 
	 * @Test public void shouldBeOkWhenAccessingRewiew() throws Exception {
	 * when(reviewRepo.findById(9L).get()).thenReturn(reviewOne);
	 * mockMvc.perform(get("/reviews/9")).andExpect(status().isOk()); }
	 * 
	 * @Test public void shouldBeOkWhenAccessingCategory() throws Exception {
	 * when(categoryRepo.findById(1L).get()).thenReturn(categoryOne);
	 * mockMvc.perform(get("/categories/1")).andExpect(status().isOk()); }
	 * 
	 * @Test
	 * 
	 * public void shouldReturReviewTemplateWhenAccessingReview() throws Exception {
	 * when(reviewRepo.findById(6L).get()).thenReturn(reviewOne);
	 * mockMvc.perform(get("/reviews/6")).andExpect(view().name("review")); }
	 * 
	 * @Test
	 * 
	 * public void shouldReturCateogryTemplateWhenAccessingCategory() throws
	 * Exception { when(categoryRepo.findById(1L).get()).thenReturn(categoryOne);
	 * mockMvc.perform(get("/categories/1")).andExpect(view().name("category")); }
	 */
}
