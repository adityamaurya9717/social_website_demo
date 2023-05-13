package com.management.jpa.entity;

import com.management.request.CreatePostRequest;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_posts")
public class UserPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "user_id",updatable = false)
    Long userId;

    @Column(name = "user_email")
    String email;
    @Column(name = "post_description")
    String postDescription;

    @Column(name = "post_type")
    String postType;

    @Column(name = "postUrl",columnDefinition = "varchar(500) default '' ",updatable = false)
    String postUrl;

    @Column(name = "created_on")
    Long createdOn;

     public UserPostEntity(CreatePostRequest request){
      this.email =request.getEmail();
      this.postType = request.getPostType();
      this.postDescription = request.getPostDescription();
      this.createdOn = System.currentTimeMillis();
     }



}
