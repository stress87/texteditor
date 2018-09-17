package ru.kveri;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class EditorPopupMenu extends JPopupMenu {
    private JPopupMenu popup = new JPopupMenu();

    public EditorPopupMenu() {
        JMenuItem copy = new JMenuItem("Copy");
        popup.add(copy);
        JMenuItem cut = new JMenuItem("Cut");
        popup.add(cut);
        JMenuItem paste = new JMenuItem("Paste");
        popup.add(paste);

        popup.addSeparator();

        JMenuItem selectAll = new JMenuItem("Select all");
        popup.add(selectAll);
    }

    public JPopupMenu getEditorPopupMenu() {
        return popup;
    }

    public void showPopup (MouseEvent event) {
        if (event.isPopupTrigger()) {
            popup.show(event.getComponent(), event.getX(), event.getY());
        }
    }
}
