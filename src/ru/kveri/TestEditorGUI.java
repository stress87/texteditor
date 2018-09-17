package ru.kveri;

import java.awt.*;

public class TestEditorGUI {
    public static void main(String[] args) {
        EditorGUI gui = EditorGUI.getInstance();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui.setVisible(true);
            }
        });
    }
}