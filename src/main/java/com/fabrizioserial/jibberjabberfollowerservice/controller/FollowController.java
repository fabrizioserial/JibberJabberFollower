package com.fabrizioserial.jibberjabberfollowerservice.controller;

import com.fabrizioserial.jibberjabberfollowerservice.dto.CreateFollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.dto.FollowDto;
import com.fabrizioserial.jibberjabberfollowerservice.entity.Follow;
import com.fabrizioserial.jibberjabberfollowerservice.service.FollowService;
import com.fabrizioserial.jibberjabberfollowerservice.service.impl.FollowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/follow")
public class FollowController {


    @Autowired
    private final FollowServiceImpl followService;

    public FollowController(FollowServiceImpl followService){
        this.followService = followService;
    }

    @PostMapping (path = "/follow")
    public ResponseEntity<Follow> createFollow(CreateFollowDto createFollowDto){
        return ResponseEntity.status(HttpStatus.OK).body(followService.createFollow(createFollowDto));
    }

    @GetMapping (path = "/followers/{uuid}")
    public ResponseEntity<List<FollowDto>> getFollowersByUuid(@PathVariable UUID uuid){
        return ResponseEntity.status(HttpStatus.OK).body(followService.getFollowersList(uuid));
    }

}
