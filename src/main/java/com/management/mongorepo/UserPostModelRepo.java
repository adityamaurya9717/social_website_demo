package com.management.mongorepo;

import com.management.mongodocument.user.UserPostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostModelRepo extends MongoRepository<UserPostModel,String> {
}
