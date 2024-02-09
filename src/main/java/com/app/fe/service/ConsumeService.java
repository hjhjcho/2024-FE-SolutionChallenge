package com.app.fe.service;

import com.app.fe.entity.Consume;
import com.app.fe.entity.Nation;
import com.app.fe.ConsumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ConsumeService {
    private final ConsumeRepository consumeRepository;

    @Autowired
    public ConsumeService(ConsumeRepository consumeRepository) {
        this.consumeRepository = consumeRepository;
    }

    public List<Consume> getAllConsumes() {
        return consumeRepository.findAll();
    }
}
