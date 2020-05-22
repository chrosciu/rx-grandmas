package com.example.rxgrandmas;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/gossips")
@RequiredArgsConstructor
public class GossipController {
    private final GossipService gossipService;
    private final ExclamationService exclamationService;

    @GetMapping
    public Flux<GossipWrapper> getAllGossips() {
        Flux<String> gossips = gossipService.getGossips().log();
        Flux<String> gossipsWithExclamation = gossips.map(exclamationService::addExclamation).log();
        Flux<GossipWrapper> wrapped = gossipsWithExclamation.map(this::mapGossip);
        return wrapped;
    }

    private GossipWrapper mapGossip(String gossip) {
        GossipWrapper gossipWrapper = new GossipWrapper();
        gossipWrapper.setMessage(gossip);
        return gossipWrapper;
    }
}
