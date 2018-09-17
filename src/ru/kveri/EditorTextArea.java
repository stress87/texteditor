package ru.kveri;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;

public class EditorTextArea extends JTextArea {
    private static EditorTextArea textArea = null;

    private EditorTextArea() {
        super();
    }

    public static EditorTextArea getEditorInstance() {
        if (textArea == null) {
            textArea = new EditorTextArea();
        }
        return textArea;
    }

    public void fillTextFromFile(Path file) {
        try {
            BufferedReader r = new BufferedReader(new FileReader(file.toFile()));
            read(r, null);
            requestFocus();
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}