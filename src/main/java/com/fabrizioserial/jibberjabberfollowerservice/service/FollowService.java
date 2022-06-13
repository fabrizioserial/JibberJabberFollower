package com.fabrizioserial.jibberjabberfollowerservice.service;

import com.fabrizioserial.jibberjabberfollowerservice.dto.CreateFollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.dto.DeleteFollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.dto.FollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.entity.Follow;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface FollowService {
    Follow createFollow(CreateFollowDto createFollowDto);

    void deleteFollow(DeleteFollowDto deleteFollowDto);

    List<FollowDto> getFollowersList(UUID followedId);

    List<FollowDto> getFollowedList(UUID followerId);

}
