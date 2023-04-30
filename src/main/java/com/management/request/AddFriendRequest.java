package com.management.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddFriendRequest {

    @NotNull(message = " userId cannot be null")
    @Positive
    Long userId;

    @NotNull(message = "friend userId cannot be null")
    @Positive
    Long friendUserId;

    boolean accepted = false;
}
