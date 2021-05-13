package com.example.adapter.gui;

import com.example.adapter.gui.button.Button;
import com.example.adapter.gui.button.CheckBox;

public interface GUIFactory {
    Button createButton();

    CheckBox createCheckBox();
}
