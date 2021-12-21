package com.example.planningpoker.factory;

import org.springframework.stereotype.Component;

@Component
public interface Factory {
    Object factory(Object obj);
}
