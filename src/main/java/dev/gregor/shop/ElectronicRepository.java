package dev.gregor.shop;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicRepository extends MongoRepository<Electronic, ObjectId> {
}
