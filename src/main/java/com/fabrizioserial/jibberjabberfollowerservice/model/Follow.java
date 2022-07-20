package com.fabrizioserial.jibberjabberfollowerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Follow {

    @Id
    @GeneratedValue
    private UUID id;

    private String followerUserName;

    private UUID followingId;

    private UUID followerId;

}
