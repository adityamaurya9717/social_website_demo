package com.management.mongodocument.user;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "post_like")
public class PostLikeModel {

    @MongoId
    private String id;

    @Field(value ="postId")
    Long postId;

    @Field(value = "likeEmail")
    String likeEmail;

    @Field(value = "createdAt")
    Long createdAt = System.currentTimeMillis();
}
