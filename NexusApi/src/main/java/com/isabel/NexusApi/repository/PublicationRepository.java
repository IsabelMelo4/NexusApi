package com.isabel.NexusApi.repository;

import com.isabel.NexusApi.model.PublicationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serial;

public interface PublicationRepository extends JpaRepository<PublicationModel, Integer> {


}
