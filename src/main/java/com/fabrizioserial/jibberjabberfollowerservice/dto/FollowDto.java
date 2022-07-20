package com.fabrizioserial.jibberjabberfollowerservice.dto;

import com.fabrizioserial.jibberjabberfollowerservice.model.Follow;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FollowDto {

    private UUID id;

    private String followerId;

    private UUID followingId;

    public static FollowDto from(Follow follow) {
        return FollowDto.builder()
                .id(follow.getId())
                .followerId(follow.getFollowerUserName())
                .followingId(follow.getFollowingId())
                .build();
    }
}
