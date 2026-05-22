package com.isabel.NexusApi.controler;

import com.isabel.NexusApi.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/followers")

public class FollowController {

@Autowired
    FollowRepository followRepository;

}
