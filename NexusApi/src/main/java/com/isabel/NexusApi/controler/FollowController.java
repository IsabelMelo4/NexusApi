package com.isabel.NexusApi.controler;

import com.isabel.NexusApi.dto.FollowerDto;
import com.isabel.NexusApi.dto.UserDto;
import com.isabel.NexusApi.model.FollowModel;
import com.isabel.NexusApi.model.UserModel;
import com.isabel.NexusApi.repository.FollowRepository;
import com.isabel.NexusApi.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/followers")

public class FollowController {

@Autowired
    FollowRepository followRepository;

@Autowired
    UserRepository userRepository;


@GetMapping("/{usuario}")
public ResponseEntity followList(@PathVariable String usuario){

    //saber o usuario que vai pegar a lista
    Optional<UserModel> userModel = userRepository.findByUsername(usuario);
    //criar a lista e filtrar de qual usuario a lista vai pegar
    List <FollowerDto> userListFollow = followRepository.findAllBySeguidorUsername(usuario).stream().map(FollowerDto::new).toList();

    if(userListFollow.isEmpty()){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("sem seguidores");
    }

    //pegar a lista de usuarios daquele seguidor
    return ResponseEntity.status(HttpStatus.OK).body(userListFollow);

}


@PostMapping("/{usuario}")
public ResponseEntity FollowCreate(@PathVariable String usuario, @RequestBody FollowerDto dto ){

    //saber quem é o usuario que vai seguir
    Optional<UserModel> Userseguidor = userRepository.findByUsername(usuario);

    if (Userseguidor.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario inválido");
    }
    //saber o usuario que vai ser seguido

    Optional<UserModel> Userseguido = userRepository.findByUsername(dto.seguido());

    if (Userseguido.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não existe");
    }

    UserModel responseSeguidor= Userseguidor.get();
    UserModel responseSeguido = Userseguido.get();

    //verificar e indexar o usuario seguidor do usuario seguido

    FollowModel follow = new FollowModel();

    if (responseSeguido.getId().equals(responseSeguidor.getId())){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("não autorizado");
    }

    follow.setSeguidor(responseSeguidor);
    follow.setSeguido(responseSeguido);
    follow.setStatus("Seguindo");
    follow.setDate_follow(LocalDateTime.now());

//seguir

    if (followRepository.existsBySeguidorAndSeguido(responseSeguidor, responseSeguido)){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Você  já segue " + responseSeguido.getUsername());
    }

    followRepository.save(follow);
    return ResponseEntity.status(HttpStatus.OK).body("vc seguiu " + responseSeguido.getUsername());
}

}

