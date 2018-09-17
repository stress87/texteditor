package ru.kveri;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EditorMenuBar extends JMenuBar {
    private JMenuBar menuBar = new JMenuBar();
    private JFileChooser fileChooser = new JFileChooser();

    public EditorMenuBar() {
        JMenu fileMenu = new JMenu("File");

        JMenuItem newFile = new JMenuItem("New");
        fileMenu.add(newFile);
        JMenuItem open = new JMenuItem("Open");
        fileMenu.add(open);
        fileMenu.addSeparator();
        JMenuItem save = new JMenuItem("Save");
        fileMenu.add(save);
        JMenuItem saveAs = new JMenuItem("Save As...");
        fileMenu.add(saveAs);
        fileMenu.addSeparator();
        JMenuItem exit = new JMenuItem("Exit");
        fileMenu.add(exit);

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ret = fileChooser.showDialog(null, "Open file");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    String fileName = fileChooser.getSelectedFile().toString();
                    EditorGUI.getInstance().setLabel(fileName);
                    EditorTextArea.getEditorInstance().fillTextFromFile(Paths.get(fileName));
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(fileMenu);

        JMenu editMenu = new JMenu("Edit");

        JMenuItem copy = new JMenuItem("Copy");
        //copy.setAccelerator(new KeyStroke()); разобраться с "горячими" клавишами
        editMenu.add(copy);
        JMenuItem cut = new JMenuItem("Cut");
        editMenu.add(cut);
        JMenuItem paste = new JMenuItem("Paste");
        editMenu.add(paste);

        menuBar.add(editMenu);

        JMenu view = new JMenu("View");

        JCheckBox lineWrapping = new JCheckBox("Line wrapping");
        view.add(lineWrapping);

        menuBar.add(view);

        lineWrapping.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                EditorTextArea textArea = EditorTextArea.getEditorInstance();
                if (lineWrapping.isSelected()) {
                    textArea.setLineWrap(true);
                } else {
                    textArea.setLineWrap(false);
                }
            }
        });
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
}