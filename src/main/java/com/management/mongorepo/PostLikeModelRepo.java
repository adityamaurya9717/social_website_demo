package com.management.mongorepo;

import com.management.mongodocument.user.PostLikeModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeModelRepo extends MongoRepository<PostLikeModel,String> {
}
