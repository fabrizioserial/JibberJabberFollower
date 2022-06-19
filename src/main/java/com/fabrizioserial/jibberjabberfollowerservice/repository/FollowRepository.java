package com.fabrizioserial.jibberjabberfollowerservice.repository;

import com.fabrizioserial.jibberjabberfollowerservice.entity.Follow;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FollowRepository extends PagingAndSortingRepository<Follow, UUID> {
}
