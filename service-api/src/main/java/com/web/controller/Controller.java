package com.web.controller;

import com.web.model.MyMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author david
 */
@RestController
@RequestMapping("/")
@Slf4j
public class Controller {

    private final static AtomicLong counter = new AtomicLong(0);

    @GetMapping
    public MyMessage getMessage(@RequestParam String name) {
        log.info("GET: /?name={}", name);
        return MyMessage.builder()
            .count(counter.getAndIncrement())
            .name(name)
            .build();
    }

}
