package dev.buddly.factorycrm.educator;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EducatorRepository extends MongoRepository<Educator, String> {
    Educator findByLessonsId(Integer id);
}
