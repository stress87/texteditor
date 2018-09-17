package ru.kveri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class EditorGUI extends JFrame {
    private static EditorGUI gui = null;

    private static final Logger logger = Logger.getGlobal();

    private Path file = null;

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 800;
    private String title = "";
    private Container pane = null;

    private EditorGUI() {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(WIDTH, HEIGHT));

        EditorMenuBar menuBar = new EditorMenuBar();

        setJMenuBar(menuBar.getMenuBar());

        EditorTextArea textArea = EditorTextArea.getEditorInstance();

        JScrollPane sp = new JScrollPane(textArea); //разобраться с прокруткой текста

        EditorPopupMenu popupMenu = new EditorPopupMenu();

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                popupMenu.showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                popupMenu.showPopup(e);
            }
        });

        pane = getContentPane();
        pane.add(sp);
        pane.add(textArea, BorderLayout.CENTER);
    }

    public static EditorGUI getInstance() {
        if (gui == null) {
            gui = new EditorGUI();
        }
        return gui;
    }

    public void setFile(String pathToFile) {
        file = Paths.get(pathToFile);
        //logger.info(file.toString());
    }

    public void setLabel(String label) {
        title = label;
    }
}
