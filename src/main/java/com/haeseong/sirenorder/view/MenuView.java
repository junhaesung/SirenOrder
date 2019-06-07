package com.haeseong.sirenorder.view;

import com.haeseong.sirenorder.controller.MenuController;
import com.haeseong.sirenorder.controller.dto.BeverageResponse;
import com.haeseong.sirenorder.controller.dto.CategoryResponse;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MenuView extends JPanel {
    private final ViewChanger viewChanger;
    private final MenuController menuController;

    public MenuView(final ViewChanger viewChanger,
                    final MenuController menuController) {
        this.viewChanger = viewChanger;
        this.menuController = menuController;
        init();
    }

    private void init() {
        viewChanger.addView(MenuView.class.getName(), this);
        final List<BeverageResponse> beverages = new ArrayList<>(menuController.getBeverages());
        final List<CategoryResponse> categories = new ArrayList<>(menuController.getCategories());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel jLabel = new JLabel("MenuView");
        add(jLabel);

        final JTabbedPane tabbedPane = new JTabbedPane();
        add(tabbedPane);

        categories.forEach(category -> {
            final JPanel panel = new JPanel();
            panel.setLayout(new GridLayout());
            beverages.stream()
                    .filter(beverage -> beverage.getCategoryId().equals(category.getId()))
                    .forEach(beverage -> {
                        final JButton beverageButton = new JButton();
                        beverageButton.setText(beverage.getName());
                        final URL url = getClass().getResource(beverage.getImageUrl());
                        final Icon imageIcon = new ImageIcon(url);
                        beverageButton.setIcon(imageIcon);
                        panel.add(beverageButton);
                    });
            tabbedPane.addTab(category.getName(), panel);
        });

        final JButton logoutButton = new JButton("로그아웃");
        logoutButton.addActionListener(e -> logoutButtonClicked());
        add(logoutButton);
    }

    public void logoutButtonClicked() {
        viewChanger.moveTo(LoginView.class.getName());
    }
}
