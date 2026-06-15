package com.isabel.NexusApi.repository;

import com.isabel.NexusApi.dto.FollowerDto;
import com.isabel.NexusApi.model.FollowModel;
import com.isabel.NexusApi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FollowRepository extends JpaRepository<FollowModel, UUID> {
    boolean existsBySeguidorAndSeguido(
            UserModel seguidor,
            UserModel seguido
    );

    List<FollowModel> findAllBySeguidorUsername(String username);
}
