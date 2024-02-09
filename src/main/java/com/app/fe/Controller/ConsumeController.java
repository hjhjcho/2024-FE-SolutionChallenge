package com.app.fe.Controller;

import com.app.fe.entity.Consume;
import com.app.fe.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumes")
public class ConsumeController {
    private final ConsumeService consumeService;

    @Autowired
    public ConsumeController(ConsumeService consumeService) {
        this.consumeService = consumeService;
    }

    @GetMapping
    public List<Consume> getAllConsumes() {
        return consumeService.getAllConsumes();
    }
}
