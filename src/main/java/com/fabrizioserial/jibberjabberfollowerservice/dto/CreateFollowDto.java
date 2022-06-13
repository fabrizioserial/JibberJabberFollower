package com.fabrizioserial.jibberjabberfollowerservice.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateFollowDto {
    private UUID followerUuid;
    private UUID followedUuid;
}
