package org.wecancodeit.grandsonofreviewssite.repository;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.grandsonofreviewssite.model.Comment;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {
	@Resource
	PostRepository repo;

	@Test
	public void shouldReturnAllComments() {
		// Arrange
		Comment comment = repo.save(new Comment());
		Comment comment2 = repo.save(new Comment());

		// Act
		Iterable<Comment> result = repo.findAll();

		// Assert
		assertThat(result, hasItems(comment2));
	}
}
