package com.isabel.NexusApi.repository;

import com.isabel.NexusApi.model.PublicationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serial;
import java.util.List;
import java.util.Optional;

public interface PublicationRepository extends JpaRepository<PublicationModel, Integer> {

    List<PublicationModel> findByUserModelUsername (String username);
}
