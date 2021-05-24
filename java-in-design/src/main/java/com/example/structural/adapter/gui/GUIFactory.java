package com.example.structural.adapter.gui;

import com.example.structural.adapter.gui.button.Button;
import com.example.structural.adapter.gui.button.CheckBox;

public interface GUIFactory {
    Button createButton();

    CheckBox createCheckBox();
}
