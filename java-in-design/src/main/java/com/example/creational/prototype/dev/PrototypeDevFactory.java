package com.example.creational.prototype.dev;

import com.example.creational.prototype.dev.concrete.BackEnd;
import com.example.creational.prototype.dev.concrete.Client;
import com.example.creational.prototype.dev.concrete.FrontEnd;

/**
 * SimpleFactory
 */
public class PrototypeDevFactory {
    private final BackEnd backEnd;
    private final FrontEnd frontEnd;
    private final Client client;

    public PrototypeDevFactory(BackEnd backEnd, FrontEnd frontEnd, Client client) {
        this.backEnd = backEnd;
        this.frontEnd = frontEnd;
        this.client = client;
    }

    public BackEnd backEnd() {
        return backEnd.clone();
    }

    public FrontEnd frontEnd() {
        return frontEnd.clone();
    }

    public Client client() {
        return client.clone();
    }
}
