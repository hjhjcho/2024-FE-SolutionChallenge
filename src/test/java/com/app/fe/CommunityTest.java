package com.app.fe;

import com.app.fe.Controller.CommunityController;
import com.app.fe.entity.Community;
import com.app.fe.service.CommunityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.app.fe.entity.Member;

import java.util.Collections;

import static org.mockito.Mockito.when;

@WebMvcTest(CommunityController.class)
public class CommunityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommunityService communityService;

    @Test
    public void testGetAllCommunities() throws Exception {

        Community community = Community.builder()
                .member(Mockito.mock(Member.class))
                .communityType("Type")
                .communityTitle("Title")
                .communityContent("Content")
                .build();

        when(communityService.getAllCommunities()).thenReturn(Collections.singletonList(community));

        mockMvc.perform(MockMvcRequestBuilders.get("/communities")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].communityType").value("Type"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].communityTitle").value("Title"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].communityContent").value("Content"));
    }
}
