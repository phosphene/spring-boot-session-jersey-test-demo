package com.phosphene.rest.view;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class SessionList {

    private List<Session> sessions;


    public SessionList(){}

    public SessionList(String email, String sessionId){
        Session session = new Session(email, sessionId);
        this.sessions = new ArrayList<>();
        this.sessions.add(session);
    }

    public SessionList(Long userId, String sessionId){
        Session session = new Session(userId, sessionId);
        this.sessions = new ArrayList<>();
        this.sessions.add(session);
    }

    public List<Session> getSessions(){
        return this.sessions;
    }

}

