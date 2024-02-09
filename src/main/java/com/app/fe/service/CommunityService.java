package com.app.fe.service;

import com.app.fe.entity.Community;
import com.app.fe.CommunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {
    private final CommunityRepository communityRepository;

    @Autowired
    public CommunityService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    // 커뮤니티 게시글 조회
    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }
}
