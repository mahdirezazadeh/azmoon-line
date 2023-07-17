package com.mahdi.azmoonline.service;

import com.mahdi.azmoonline.config.i18n.MessagesResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoadLabels {
    @Autowired
    MessagesResourceBundle messagesResourceBundle;

    //
    @GetMapping("/guest/label")
    public Result loadLabels() {
        return new Result(messagesResourceBundle.getMessages());
    }

    record Result(Map<String, String> labels) {
    }
}
