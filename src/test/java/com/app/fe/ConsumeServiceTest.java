package com.app.fe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.app.fe.entity.Consume;
import com.app.fe.entity.Nation;

import com.app.fe.service.ConsumeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ConsumeServiceTest {

    @Mock
    private ConsumeRepository consumeRepository;

    @InjectMocks
    private ConsumeService consumeService;

    @Test
    public void testGetAllConsumes() {
        Consume consume1 = Consume.builder().productName("Product1").productOriginalPrice(100).productKoreaPrice(90).nation(new Nation()).build();
        Consume consume2 = Consume.builder().productName("Product2").productOriginalPrice(150).productKoreaPrice(120).nation(new Nation()).build();
        List<Consume> mockConsumes = Arrays.asList(consume1, consume2);
        when(consumeRepository.findAll()).thenReturn(mockConsumes);

        List<Consume> result = consumeService.getAllConsumes();

        assertEquals(2, result.size());
        assertEquals("Product1", result.get(0).getProductName());
        assertEquals(100, result.get(0).getProductOriginalPrice());
        assertEquals(90, result.get(0).getProductKoreaPrice());
        assertEquals("Product2", result.get(1).getProductName());
        assertEquals(150, result.get(1).getProductOriginalPrice());
        assertEquals(120, result.get(1).getProductKoreaPrice());

        verify(consumeRepository, times(1)).findAll();
    }
}
