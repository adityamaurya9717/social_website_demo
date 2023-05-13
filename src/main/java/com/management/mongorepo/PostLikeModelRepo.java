package com.management.mongorepo;

import com.management.mongodocument.user.PostLikeModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostLikeModelRepo extends MongoRepository<PostLikeModel,String> {

    @Query("{postId : ?0 }")
    public List<PostLikeModel> getPostLikeByPostId(Long postId);

    @Query(value="{postId : ?0 }",count = true)
    public long getCountPostLikeByPostId(Long postId);


}
