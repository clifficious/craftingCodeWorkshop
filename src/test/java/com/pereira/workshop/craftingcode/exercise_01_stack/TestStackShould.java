package com.pereira.workshop.craftingcode.exercise_01_stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.assertj.core.api.Assertions.*;

class TestStackShould {

    private Stack stack;
    private final Object object1 = new Object();
    private final Object object2 = new Object();

    @BeforeEach
    void initStack() {
        stack = new Stack();
    }

    @Test
    void throwExceptionIfPoppedWhenEmpty() {
        assertThatExceptionOfType(EmptyStackException.class).isThrownBy(() -> stack.pop());
    }

    @Test
    void pop_the_last_element_pushed() {
        stack.push(object1);

        assertThat(stack.pop()).isEqualTo(object1);
    }

    @Test
    void pop_elements_in_reverse_order_they_were_pushed() {
        stack.push(object1);
        stack.push(object2);

        assertThat(stack.pop()).isEqualTo(object2);
        assertThat(stack.pop()).isEqualTo(object1);
    }

}