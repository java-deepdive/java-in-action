package com.example.structural.adapter.gui;

import com.example.structural.adapter.gui.button.Button;
import com.example.structural.adapter.gui.button.CheckBox;

public class Application {
    private final CheckBox checkBox;
    private final Button button;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void paint() {
        button.paint();
        checkBox.paint();
    }
}
