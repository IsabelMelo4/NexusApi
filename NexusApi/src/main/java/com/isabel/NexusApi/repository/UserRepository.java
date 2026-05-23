package com.isabel.NexusApi.repository;
import java.util.Optional;
import com.isabel.NexusApi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> { //informo a enity que vai ser chamada e o tipo de id

    Optional<UserModel> findByUsername(String username);
    Optional<UserModel> findById(UUID id);
    boolean existsByUsername(String username);

}
//essa classe é responsavel por fazer contato com o banco, cria deleta e atualiza os dados do banco