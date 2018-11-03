package org.wecancodeit.grandsonofreviewssite.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.grandsonofreviewssite.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findByTagName(String tagName);

}
