package com.example.behavioral.memento.history;

import com.example.behavioral.memento.editor.Editor;

/**
 * 스냅 샷
 */
public class Memento {

    private final String backup;
    private final Editor editor;

    public Memento(Editor editor) {
        this.editor = editor;
        this.backup = editor.backup();
    }

    public void restore() {
        editor.restore(backup);
    }
}
