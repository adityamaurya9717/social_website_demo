package com.management.mybatis;

import com.management.jpa.entity.UserPostEntity;
import com.management.model.UserFriendModel;
import com.management.model.UserModel;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface SocialMybatisMapper {
    @Results(
            value = {
                    @Result(property = "id",column = "id"),
                    @Result(property = "email", column = "email"),
                    @Result(property = "lastName", column = "last_name"),
                    @Result(property = "firstName", column = "first_name"),
                    @Result(property = "userFriendsEntity", javaType = List.class,column = "id",many = @Many(
                            select = "userFriends"
                    ))
            })
    @Select("select * from user")
    public List<UserModel> findUsers();

    @Results(
            value = {
                    @Result(property = "id", column = "id"),
                    @Result(property = "userId", column = "user_id"),
                    @Result(property = "friendUserId", column = "friend_user_id"),
                    @Result(property = "accepted", column = "is_accepted")
            })
    @Select("select * from user_friends where user_id = #{userId} and is_accepted = true")
   public List<UserFriendModel> userFriends(@Param("userId") Integer userId);

    @Results(
        value = {
          @Result(property = "email",column = "user_email"),
          @Result(property = "postDescription",column = "post_description"),
          @Result(property = "postType",column = "post_type")
        }
    )
    @Select("select * from  user_posts")
    public List<UserPostEntity> findUsersPost();
}
