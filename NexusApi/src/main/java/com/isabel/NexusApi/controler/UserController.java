package com.isabel.NexusApi.controler;

import com.isabel.NexusApi.dto.User.UserDto;
import com.isabel.NexusApi.model.UserModel;
import com.isabel.NexusApi.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{username}")
        public ResponseEntity buscarUsuario (@PathVariable String username){
        Optional user =  userRepository.findByUsername(username);

        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não existe");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

  @PostMapping
    public ResponseEntity create(@RequestBody UserModel dto ){

      if(userRepository.existsByUsername(dto.getUsername())){
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
      };

      var userModel = new UserModel();
      BeanUtils.copyProperties(dto, userModel);
      return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
  }

   //verificar se o usuario já existe
}
