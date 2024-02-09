package com.app.fe;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.app.fe.Controller.ConsumeController;
import com.app.fe.entity.Consume;
import com.app.fe.entity.Nation;
import com.app.fe.service.ConsumeService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ConsumeController.class)
public class ConsumeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConsumeService consumeService;

    @Test
    public void testGetAllConsumes() throws Exception {
        Nation nation = new Nation(); // Nation 객체 생성
        Consume consume1 = Consume.builder().productName("Product1").productType("Type1").productOriginalPrice(100).productKoreaPrice(90).nation(nation).build();
        Consume consume2 = Consume.builder().productName("Product2").productType("Type2").productOriginalPrice(150).productKoreaPrice(120).nation(nation).build();
        List<Consume> mockConsumes = Arrays.asList(consume1, consume2);
        when(consumeService.getAllConsumes()).thenReturn(mockConsumes);

        mockMvc.perform(MockMvcRequestBuilders.get("/consumes").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productName", is("Product1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productOriginalPrice", is(100)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productKoreaPrice", is(90)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].productName", is("Product2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].productOriginalPrice", is(150)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].productKoreaPrice", is(120)));

        verify(consumeService, times(1)).getAllConsumes();
    }
}
