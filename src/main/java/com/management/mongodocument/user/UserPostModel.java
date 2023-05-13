package com.management.mongodocument.user;

import com.management.jpa.entity.UserPostEntity;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "users_post")
public class UserPostModel {

    @MongoId
    private String id;

    @Field(value ="postId")
    @Indexed(unique = true)
    Long postId;

    @Field(value = "userEmail")
    String userEmail;

    @Field(value = "postType")
    String postType;

    @Field(value = "postDescription")
    String postDescripion;
    @Field(value = "postUrl")
    String postUrl = "";

    @Field(value = "createdOn")
    Long createdOn;

    @DBRef
    List<PostLikeModel> postLikeModelList;

    @DBRef
    List<PostCommentModel> postCommentModels;

    public UserPostModel(UserPostEntity userPostEntity) {
        this.postId = userPostEntity.getId();
        this.userEmail = userPostEntity.getEmail();
        this.postDescripion = userPostEntity.getPostDescription();
        this.postType = userPostEntity.getPostType();
        this.createdOn = System.currentTimeMillis();
    }
}
