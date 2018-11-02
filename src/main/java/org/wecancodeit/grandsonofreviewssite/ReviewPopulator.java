package org.wecancodeit.grandsonofreviewssite;

import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.grandsonofreviewssite.model.Category;
import org.wecancodeit.grandsonofreviewssite.model.Review;
import org.wecancodeit.grandsonofreviewssite.repository.CategoryRepository;
import org.wecancodeit.grandsonofreviewssite.repository.ReviewRepository;

@Service
public class ReviewPopulator implements CommandLineRunner {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@Override

	public void run(String... args) throws Exception {
		Category category1 = new Category("Point and Click");
		Category category2 = new Category("Puzzle/Platformer");
		Category category3 = new Category("RPG");
		Category category4 = new Category("Acade");
		Category category5 = new Category("Action Adventure");

		category1 = categoryRepo.save(category1);
		category2 = categoryRepo.save(category2);
		category3 = categoryRepo.save(category3);
		category4 = categoryRepo.save(category4);
		category5 = categoryRepo.save(category5);

		// point and click
		Review reviewKid1 = new Review("Max: Life is Strange",
				"It's no surprise that since Life is Strange is one of my favorite games of all time, Max is also one of my favorite protagonist in video games of all time. The character development that is explored within her is nothing short of breathtaking. Playing as Max put me back in the headspace of being a teenage girl. I remember feeling the same things Max felt; the uncertantity of youth, the heavy weight of decisions. She is by far one of the most realistic female characters in video games or in media in general. ",
				"I'd love to see more games that explore her character.", "10/10", "image", category1);
		Review reviewKid2 = new Review("Freddy: Freddy Fish Series",
				"Freddy Fish was the first female video game character I ever encountered. My sister was surpirsed when she learned that Freddy was a girl. I'm not sure why I picked up on it and my sister didn't. But Freddy was always my favorite character. She was smart and kind. She solved mysteries to help peopl. It was through these games I developed a love of detectives and point-and-click adventure games. She truely is an icon. ",
				"I wish there were still games being made about her", "10/10", "image", category1);

		reviewKid1 = reviewRepo.save(reviewKid1);
		reviewKid2 = reviewRepo.save(reviewKid2);
		// Puzzle/
		Review reviewKid3 = new Review("Chell: Portal",
				"Chell is a hard one. She has no lines of dialogue. Which severarly limits her character. But, that being said. There is somehting interesting about this silent protagonist, bulldosing her way through the lab without a word. She's hard to judge because of this though. ",
				"I mean... I wish I had more of a character here to work with.", "5/10", "image", category2);
		Review reviewKid4 = new Review("Laura Croft: Tomb Raider", "description",
				"Stop putting her in weird situations!", "7/10", "image", category2);

		reviewKid3 = reviewRepo.save(reviewKid3);
		reviewKid4 = reviewRepo.save(reviewKid4);

		// RPG
		Review reviewKid5 = new Review("Chell: Portal", "description", "recomendation", "rating", "image", category3);
		Review reviewKid6 = new Review("Chell: Portal", "description", "recomendation", "rating", "image", category3);

		reviewKid5 = reviewRepo.save(reviewKid5);
		reviewKid6 = reviewRepo.save(reviewKid6);

		// Aracde
		Review reviewKid7 = new Review("Chell: Portal", "description", "recomendation", "rating", "image", category4);
		reviewKid7 = reviewRepo.save(reviewKid7);

		// Action Adventure
		Review reviewKid8 = new Review("Chell: Portal", "description", "recomendation", "rating", "image", category5);
		reviewKid8 = reviewRepo.save(reviewKid8);

	}

}
