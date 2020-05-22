package com.example.rxgrandmas;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GossipService {
    public Flux<String> getGossips() {
        return Flux.just("Cos mi sie powiedzialo", "Cos tam plote");
    }
}
