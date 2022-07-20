package com.fabrizioserial.jibberjabberfollowerservice.service;

import com.fabrizioserial.jibberjabberfollowerservice.dto.CreateFollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.dto.DeleteFollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.dto.FollowDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface FollowService {
    void follow(UUID userId);

    Page<FollowDto> getFollowers(UUID userId, int page, int size);

    Page<FollowDto> getFollowing(UUID userId, int page, int size);

    void unfollow(UUID userId, UUID followingId);

    boolean isFollowed(UUID userId);

}
