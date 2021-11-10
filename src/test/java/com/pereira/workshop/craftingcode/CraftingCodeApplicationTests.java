package com.pereira.workshop.craftingcode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CraftingCodeApplicationTests {

    @Autowired
    private ApplicationContext appContext;

    @Test
    void contextLoads() {
        assertThat(appContext).isNotNull();
    }

}
