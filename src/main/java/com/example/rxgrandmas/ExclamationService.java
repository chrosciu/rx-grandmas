package com.example.rxgrandmas;

import org.springframework.stereotype.Service;

@Service
public class ExclamationService {
    public String addExclamation(String gossip) {
        return gossip + "!!!";
    }
}
