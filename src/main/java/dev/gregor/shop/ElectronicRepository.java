package dev.gregor.shop;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElectronicRepository extends MongoRepository<Electronic, ObjectId> {
    Optional<Electronic> findByElectronicId(String electronicId);
    void deleteByElectronicId(String electronicId);
}
