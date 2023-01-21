package com.example.listener;

import com.example.listener.model.CustomModel;
import com.example.listener.model.event.CustomEventModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Component
public class CustomListener implements ApplicationListener<CustomEventModel> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(CustomEventModel event) {
        System.err.println("-- RequestHandledEvent --");
        OutputStream outputStream = event.getCustomModel().getResponse().getOutputStream();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, "Error (test)");
        outputStream.flush();

        System.err.println("test");
    }
}
