package com.example.controller;

import com.example.dto.ResourceDTO;
import com.example.listener.model.CustomModel;
import com.example.listener.model.event.CustomEventModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody ResourceDTO dto, HttpServletRequest request, HttpServletResponse response) throws IOException {

        applicationEventPublisher.publishEvent(new CustomEventModel(this, CustomModel.builder()
                .dto(dto)
                .request(request)
                .response(response)
                .build()));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
