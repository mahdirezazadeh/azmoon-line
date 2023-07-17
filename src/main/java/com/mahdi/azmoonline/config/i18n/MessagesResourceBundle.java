package com.mahdi.azmoonline.config.i18n;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MessagesResourceBundle {

    private static final String BASE_NAME = "i18n/labels";
    private Map<String, String> messages;

    public MessagesResourceBundle() {
        messages = new HashMap<>();
        List<Locale> locales = Arrays.asList(Locale.forLanguageTag("en"));
        locales.stream().map(l -> ResourceBundle.getBundle(BASE_NAME, l))
                .forEach(bundle -> Collections.list(bundle.getKeys()).forEach(key -> messages.put(key, bundle.getString(key))));
    }

    public Map<String, String> getMessages() {
        return Collections.unmodifiableMap(messages);
    }
}