package com.haeseong.sirenorder.view;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ViewChanger {
    private final JPanel cardPanel;

    public ViewChanger() {
        this.cardPanel = new JPanel(new CardLayout());
    }

    public ViewChanger(final Map<String, JPanel> panelMap) {
        this();
        if (panelMap == null) {
            throw new IllegalArgumentException("'panels' must not be null");
        }
        panelMap.forEach(cardPanel::add);
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public void addView(final String name, final JPanel jPanel) {
        cardPanel.add(name, jPanel);
    }

    public void moveTo(final String name) {
        final CardLayout cardLayout = (CardLayout) (cardPanel.getLayout());
        cardLayout.show(cardPanel, name);
    }
}
