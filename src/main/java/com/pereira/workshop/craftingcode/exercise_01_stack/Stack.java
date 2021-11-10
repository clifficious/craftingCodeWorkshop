package com.pereira.workshop.craftingcode.exercise_01_stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack {

    private final List<Object> objects = new ArrayList<>();

    public Object pop() {
        if (objects.isEmpty()) {
            throw new EmptyStackException();
        }
        return objects.remove(objects.size() - 1);
    }

    public void push(Object object) {
        objects.add(object);
    }
}
