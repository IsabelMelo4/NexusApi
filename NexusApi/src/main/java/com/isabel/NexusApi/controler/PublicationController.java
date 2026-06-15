package com.isabel.NexusApi.controler;
import com.isabel.NexusApi.dto.PubliDto;
import com.isabel.NexusApi.dto.UserDto;
import com.isabel.NexusApi.model.PublicationModel;
import com.isabel.NexusApi.model.UserModel;
import com.isabel.NexusApi.repository.PublicationRepository;
import com.isabel.NexusApi.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{usernamePubli}")
    public ResponseEntity getPost(@PathVariable String usernamePubli){
        Optional <UserModel> userPublication = userRepository.findByUsername(usernamePubli);
        List<PublicationModel> publicationResponse = publicationRepository.findByUserModelUsername(usernamePubli);

        if(userPublication.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não existe");
        }

        if(publicationResponse.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario sem publicação");
        }

        var user = userPublication.get();
        PublicationModel publication = null ;
        List<PubliDto> response = new ArrayList<>();

        for (Integer i= 0; i <  publicationResponse.size(); i++){
            publication = publicationResponse.get(i);
            response.add(new PubliDto(publication.getText(), user.getUsername(),publication.getDatePublication()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity create (@RequestBody PubliDto dto) {

        UserModel userModel = userRepository.findByUsername(dto.user()).orElseThrow();

       var post = new PublicationModel();

       post.setUserModel(userModel);
       post.setText(dto.text());
       post.setDatePublication(LocalDateTime.now());

      return ResponseEntity.status(HttpStatus.CREATED).body(publicationRepository.save(post));

    }

    @DeleteMapping ("/{id}/{username}")
    public ResponseEntity dellPost(@PathVariable Integer id, @PathVariable String username){
        Optional <PublicationModel> publicationResponse = publicationRepository.findById(id);
        Optional<UserModel> userResponse = userRepository.findByUsername(username);


        if(publicationResponse.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Essa publicação não existe ");
        }

        if(userResponse.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não existe");
        }

        PublicationModel publication = publicationResponse.get();
        UserModel user = userResponse.get();


        if(!publication.getUserModel().getId().equals(user.getId())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Essa publicação não existe ");
        }

       publicationRepository.delete(publication);
        return ResponseEntity.status(HttpStatus.OK).body("publicação deletada");
    }

}

