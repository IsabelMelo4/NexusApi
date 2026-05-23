package com.isabel.NexusApi.controler;
import com.isabel.NexusApi.dto.PubliDto;
import com.isabel.NexusApi.model.PublicationModel;
import com.isabel.NexusApi.model.UserModel;
import com.isabel.NexusApi.repository.PublicationRepository;
import com.isabel.NexusApi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity create (@RequestBody PubliDto dto) {

        UserModel userModel = userRepository.findById(dto.usuarioId()).orElseThrow();;

       var post = new PublicationModel();

       post.setUserModel(userModel);
       post.setText(dto.text());
       post.setDatePublication(LocalDateTime.now());

      return ResponseEntity.status(HttpStatus.CREATED).body(publicationRepository.save(post));

    }}
