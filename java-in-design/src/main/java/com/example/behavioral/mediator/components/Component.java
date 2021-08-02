package com.example.behavioral.mediator.components;

import com.example.behavioral.mediator.mediators.Mediator;

/**
 * Common component interface.
 */
public interface Component {
    void setMediator(Mediator mediator);

    String getName();
}
