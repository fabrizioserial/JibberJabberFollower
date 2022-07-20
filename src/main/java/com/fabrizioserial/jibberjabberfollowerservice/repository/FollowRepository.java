package com.fabrizioserial.jibberjabberfollowerservice.repository;

import com.fabrizioserial.jibberjabberfollowerservice.model.Follow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface FollowRepository extends PagingAndSortingRepository<Follow, UUID> {
    Follow findByFollowerUserNameAndFollowingId(String username, UUID userId);

    Page<Follow> findByFollowingId(UUID userId, Pageable pageable);

    Optional<Follow> findByFollowerIdAndFollowingId(UUID userId, UUID followingId);
}
