package com.isabel.NexusApi.dto;

import com.isabel.NexusApi.model.FollowModel;
import com.isabel.NexusApi.model.UserModel;

public record FollowerDto (String seguido){
public  FollowerDto(FollowModel followModel){
    this(followModel.getSeguido().getUsername());
}

}

