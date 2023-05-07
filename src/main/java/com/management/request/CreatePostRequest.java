package com.management.request;

import lombok.*;

import java.util.Map;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostRequest {

    private Long id;
    private String email;

    private String postDescription;

    private String postType;

    public CreatePostRequest(Map<String,Object> request){
        this.email = (String) request.get("email");
        this.postDescription = (String) request.get("postDescription");
        this.postType = (String) request.get("postType");
    }

}
