package com.example.rxgrandmas;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import reactor.core.publisher.Flux;

//@Component
@Slf4j
@RequiredArgsConstructor
public class GrandmasRunner implements CommandLineRunner {
    private final GossipService gossipService;
    private final ExclamationService exclamationService;

    @Override
    public void run(String... args) throws Exception {
        Flux<String> gossips = gossipService.getGossips().log();
        Flux<String> gossipsWithExclamation = gossips.map(exclamationService::addExclamation).log();
        gossipsWithExclamation.subscribe(gossip -> log.info("Odebrano: " + gossip));
        //log.info(gossips.toString());
    }
}
