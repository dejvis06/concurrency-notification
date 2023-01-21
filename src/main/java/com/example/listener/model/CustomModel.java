package com.example.listener.model;

import com.example.dto.ResourceDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Builder
@Getter
public class CustomModel {

    private ResourceDTO dto;
    private HttpServletRequest request;
    private HttpServletResponse response;
}
