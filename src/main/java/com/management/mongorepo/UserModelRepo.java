package com.management.mongorepo;

import com.management.mongodocument.user.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelRepo extends MongoRepository<UserModel,String> {
}
