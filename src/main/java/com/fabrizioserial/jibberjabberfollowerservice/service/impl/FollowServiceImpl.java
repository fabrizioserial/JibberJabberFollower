package com.fabrizioserial.jibberjabberfollowerservice.service.impl;

import com.fabrizioserial.jibberjabberfollowerservice.dto.CreateFollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.dto.DeleteFollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.dto.FollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.entity.Follow;
import com.fabrizioserial.jibberjabberfollowerservice.repository.FollowRepository;
import com.fabrizioserial.jibberjabberfollowerservice.service.FollowService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    public FollowServiceImpl(FollowRepository followRepository){
        this.followRepository = followRepository;
    }

    @Override
    public Follow createFollow(CreateFollowDto createFollowDto) {
        Follow follow = Follow.builder()
                .followedUuid(createFollowDto.getFollowedUuid())
                .followerUuid(createFollowDto.getFollowerUuid())
                .build();
        return followRepository.save(follow);
    }

    @Override
    public void deleteFollow(DeleteFollowDto deleteFollowDto) {
//        Follow followToDelete = followRepository.findById(deleteFollowDto.getFollowerUuid()).get();
//        if(followRepository.existsById(deleteFollowDto.getFollowerUuid())){
//            followRepository.delete(deleteFollowDto.getFollowedUuid());
//        }
//        }
    }

    @Override
    public List<FollowDto> getFollowersList(UUID followedId) {
        return null;
    }

    @Override
    public List<FollowDto> getFollowedList(UUID followerId) {
        return null;
    }
}
