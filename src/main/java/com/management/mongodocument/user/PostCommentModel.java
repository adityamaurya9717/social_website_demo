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
@Document(collection = "post_comment")
public class PostCommentModel {

    @MongoId
    String id;

    @Field(value = "postId") // this post id comes from mysql
    Long postId;

    @Field(value = "email") // person email who comment on a post
    String email ;

    @Field(value = "comment") // what person comment
    String comment = "";

    @Field(value = "likeCount")  // is that comment how many people liked it
    Long likeCount = 0L;

    @Field(value = "disLikeCount") // in that comment how many people dislike it
    Long disLikeCount = 0L;

    @Field(value = "createdOn")
    Long createdOn = System.currentTimeMillis(); // at what time does person comment on post


}
