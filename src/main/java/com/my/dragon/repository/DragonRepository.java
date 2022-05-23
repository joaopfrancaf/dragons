package com.my.dragon.repository;


import com.my.dragon.model.Dragon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DragonRepository extends MongoRepository<Dragon, String> {

    List<Dragon> findByNameOrType(String name, String type);
}
