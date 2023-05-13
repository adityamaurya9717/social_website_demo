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
@ToString
public class PostLikeModel {

    @MongoId
    private String id;

    @Field(value ="postId") // postId this is given by mysql
    Long postId;

    @Field(value = "likeEmail") // person email who liked a post
    String likeEmail;

    @Field(value = "createdAt")
    Long createdAt = System.currentTimeMillis();
}
