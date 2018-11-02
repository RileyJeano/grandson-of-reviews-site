package org.wecancodeit.grandsonofreviewssite.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.grandsonofreviewssite.model.Category;
import org.wecancodeit.grandsonofreviewssite.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Resource
	CategoryRepository repo;

	@Test
	public void shouldReturnAllContacts() {
		// Arrange
		Category category = repo.save(new Category());
		Category category2 = repo.save(new Category());

		// Act
		Iterable<Category> result = repo.findAll();

		// Assert
		assertThat(result, hasItems(category));
	}
}
