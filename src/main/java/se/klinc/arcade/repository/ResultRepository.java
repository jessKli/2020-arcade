package se.klinc.arcade.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.klinc.arcade.domain.ResultContenstant;

@Repository
public interface ResultRepository extends MongoRepository<ResultContenstant, String> {
}
