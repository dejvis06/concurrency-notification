package com.example.listener.model.event;

import com.example.listener.model.CustomModel;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

public class CustomEventModel extends ApplicationEvent {

    private CustomModel customModel;

    public CustomEventModel(Object source, CustomModel customModel) {
        super(source);
        this.customModel = customModel;
    }

    public CustomModel getCustomModel() {
        return customModel;
    }
}
