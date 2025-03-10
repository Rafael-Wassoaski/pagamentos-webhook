package com.rafaelwassoaski.webhook.Webhook.application.service;

import jakarta.websocket.Session;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SessionsSingleton {
    private static Set<Session> userSessions;

    public static Set<Session> getUserSessions(){

        if(SessionsSingleton.userSessions == null){
            SessionsSingleton.userSessions = Collections.synchronizedSet(new HashSet<Session>());
        }

        return userSessions;

    }

}
