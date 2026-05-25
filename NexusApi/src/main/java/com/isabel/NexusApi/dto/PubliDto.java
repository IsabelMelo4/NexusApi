package com.isabel.NexusApi.dto;

import com.isabel.NexusApi.model.UserModel;

import java.time.LocalDateTime;
import java.util.UUID;

public record PubliDto(String text, String user, LocalDateTime dateTime) {


}