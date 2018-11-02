package org.wecancodeit.grandsonofreviewssite;

import java.util.ArrayList;

import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.grandsonofreviewssite.model.Category;
import org.wecancodeit.grandsonofreviewssite.model.Review;
import org.wecancodeit.grandsonofreviewssite.model.Tag;
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

	}

}
