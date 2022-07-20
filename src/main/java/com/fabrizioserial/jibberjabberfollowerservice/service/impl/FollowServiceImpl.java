package com.fabrizioserial.jibberjabberfollowerservice.service.impl;

import com.fabrizioserial.jibberjabberfollowerservice.dto.CreateFollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.dto.DeleteFollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.dto.FollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.model.Follow;
import com.fabrizioserial.jibberjabberfollowerservice.repository.FollowRepository;
import com.fabrizioserial.jibberjabberfollowerservice.service.FollowService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Service
public class FollowServiceImpl implements FollowService {


    private final FollowRepository followRepository;
    private final Logger logger = Logger.getLogger(FollowServiceImpl.class.getName());

    public FollowServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    public void follow(UUID userId) {
        Follow follow = followRepository.findByFollowerUserNameAndFollowingId(getUserData(), userId);
        if(follow != null) {
            followRepository.delete(follow);
            logger.info("User " + getUserData() + " unfollowed user " + userId);
        } else {
            follow = Follow.builder()
                    .followerUserName(getUserData())
                    .followingId(userId)
                    .build();
            logger.info("New Follow Started");
            follow = followRepository.save(follow);
            logger.info("User " + follow.getFollowerUserName() + " is now following " + follow.getFollowingId());
        }
    }

    private String getUserData() {
        KeycloakPrincipal principal = (KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        KeycloakSecurityContext context = (KeycloakSecurityContext) principal.getKeycloakSecurityContext();
        AccessToken token = context.getToken();
        return token.getPreferredUsername();
    }

    @Override
    public Page<FollowDto> getFollowers(UUID userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Follow> follows = followRepository.findByFollowingId(userId, pageable);
        return follows.map(FollowDto::from);
    }

    @Override
    public Page<FollowDto> getFollowing(UUID userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Follow> follows = followRepository.findByFollowingId(userId, pageable);
        return follows.map(FollowDto::from);
    }

    @Override
    public void unfollow(UUID userId, UUID followingId) {
        logger.info("New Unfollow Started");
        Follow follow = followRepository.findByFollowerIdAndFollowingId(userId, followingId).orElseThrow(() -> new IllegalArgumentException("No follow found"));
        followRepository.delete(follow);
        logger.info("User " + userId + " is no longer following " + followingId);
    }

    @Override
    public boolean isFollowed(UUID userId) {
        return followRepository.findByFollowerUserNameAndFollowingId(getUserData(), userId) != null;
    }
}
