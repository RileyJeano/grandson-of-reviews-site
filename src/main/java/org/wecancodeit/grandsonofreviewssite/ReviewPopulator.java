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
				"I'd love to see more games that explore her character.", "10/10", "max.png", category1);
		Review reviewKid2 = new Review("Freddi: Freddy Fish Series",
				"Freddi Fish was the first female video game character I ever encountered. My sister was surpirsed when she learned that Freddy was a girl. I'm not sure why I picked up on it and my sister didn't. But Freddy was always my favorite character. She was smart and kind. She solved mysteries to help peopl. It was through these games I developed a love of detectives and point-and-click adventure games. She truely is an icon. ",
				"I wish there were still games being made about her", "10/10", "freddi.gif", category1);

		reviewKid1 = reviewRepo.save(reviewKid1);
		reviewKid2 = reviewRepo.save(reviewKid2);
		// Puzzle/
		Review reviewKid3 = new Review("Chell: Portal",
				"Chell is a hard one. She has no lines of dialogue. Which severarly limits her character. But, that being said. There is somehting interesting about this silent protagonist, bulldosing her way through the lab without a word. She's hard to judge because of this though. ",
				"I mean... I wish I had more of a character here to work with.", "5/10", "chell.png", category2);
		Review reviewKid4 = new Review("Laura Croft: Tomb Raider",
				"She's a tough, no nonsense lady. She is in many ways one of the ideal female main characters. But, the writers never really let you forget that she is a women. They consistanly put her in situations that highlight her gender and use it as a weapon against her. While in many games she is one kick but hero, in other's she becomes a damsil in distress. She is one of the more incosistant characters on the list. ",
				"Stop putting her in weird situations!", "7/10", "laura.jpg", category2);

		reviewKid3 = reviewRepo.save(reviewKid3);
		reviewKid4 = reviewRepo.save(reviewKid4);

		// RPG
		Review reviewKid5 = new Review("Shepard: Mass Effect",
				"It's hard not to like a character that you can customize. You get to choose what kind of hero your Sheppard is. Having your character progress through three games is a wonderful way of shaping your own character progression and growth. You can shape your own narrative as you go. It is rare for this is video games and therefor a refreshing scenario. Although there is little emphesis put on you character as a women, the sci-fi setting mitigates that. \r\n"
						+ "",
				"Talk more about her being a female in the context of the society.", "7/10", "mass.jpg", category3);
		Review reviewKid6 = new Review("Hero Of Ferelden: Dragon Age: Origins",
				"As per usual I am very biased when it comes to Dragon Age. It has been my favorite game for many years. The female character toes the line between being seperate from their gender and being related to their gender. Specific female backgrounds open differnet endings. This small detail adds much to the overall feeling of the game.\r\n"
						+ "",
				"Bring this character back!", "9/10", "dragon.jpg", category3);

		reviewKid5 = reviewRepo.save(reviewKid5);
		reviewKid6 = reviewRepo.save(reviewKid6);

		// Arcade
		Review reviewKid7 = new Review("Ms. Pac-Man", "She's Pack-Man... with a bow... not much more to say.",
				"I don't know, she's Ms. ", "3/10", "pac.png", category4);
		reviewKid7 = reviewRepo.save(reviewKid7);

		// Action Adventure
		Review reviewKid8 = new Review("Jade: Good and Evil", "I've never played the game but she looks cool.",
				"I should play it!", "Pending", "jade.jpg", category5);
		reviewKid8 = reviewRepo.save(reviewKid8);

	}

}
