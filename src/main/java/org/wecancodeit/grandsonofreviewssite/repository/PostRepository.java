package org.wecancodeit.grandsonofreviewssite.repository;

import org.wecancodeit.grandsonofreviewssite.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Comment, Long> {

}
