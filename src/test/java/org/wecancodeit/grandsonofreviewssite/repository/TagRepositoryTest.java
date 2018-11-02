package org.wecancodeit.grandsonofreviewssite.repository;

import static org.hamcrest.Matchers.hasItem;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.grandsonofreviewssite.model.Review;
import org.wecancodeit.grandsonofreviewssite.model.Tag;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TagRepositoryTest {

	@Resource
	TagRepository tagRepo;

	@Test
	public void shouldAddATag() {
		Tag tag1 = new Tag("tag");
		tagRepo.save(tag1);

		Iterable<Tag> result = tagRepo.findAll();
		Assert.assertThat(result, hasItem(tag1));

	}

	public void shouldAddATagToReview() {
		Tag tag1 = new Tag("tag");

		Review review = new Review();
		review.addTag(tag1);

		Assert.assertThat(review.getTags(), hasItem(tag1));
	}
}
