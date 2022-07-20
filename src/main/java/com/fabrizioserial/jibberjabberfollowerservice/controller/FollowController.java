package com.fabrizioserial.jibberjabberfollowerservice.controller;

import com.fabrizioserial.jibberjabberfollowerservice.dto.CreateFollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.dto.FollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.service.FollowService;
import com.fabrizioserial.jibberjabberfollowerservice.service.impl.FollowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/follow")
public class FollowController {


    private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/{followId}")
    public void follow(@Valid @PathVariable("followId") UUID userId) {
        followService.follow(userId);
    }

    @GetMapping("/followers/{userId}")
    public Page<FollowDto> getFollowers(@Valid @PathVariable UUID userId,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        return followService.getFollowers(userId, page, size);
    }

    @GetMapping("/following/{userId}")
    public Page<FollowDto> getFollowing(@Valid @PathVariable UUID userId,
                                        @RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        return followService.getFollowing(userId, page, size);
    }

    @DeleteMapping("/user/{userId}/unfollow/{followingId}")
    public void unfollow(@Valid @PathVariable UUID userId, @Valid @PathVariable UUID followingId) {
        followService.unfollow(userId, followingId);
    }

    @GetMapping("/isFollowed/{userId}")
    public boolean isFollowed(@PathVariable UUID userId) {
        return followService.isFollowed(userId);
    }

}
