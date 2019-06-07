package com.haeseong.sirenorder.view;

import com.haeseong.sirenorder.controller.LoginController;
import com.haeseong.sirenorder.controller.dto.LoginRequest;
import com.haeseong.sirenorder.controller.dto.LoginResponse;
import com.haeseong.sirenorder.model.exception.LoginFailureException;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class LoginView extends JPanel {
    private final ViewChanger viewChanger;
    private final LoginController loginController;

    private JTextField idField;
    private JPasswordField passwordField;

    public LoginView(final ViewChanger viewChanger,
                     final LoginController loginController) {
        this.viewChanger = viewChanger;
        this.loginController = loginController;
        init();
    }

    private void init() {
        viewChanger.addView(LoginView.class.getName(), this);

        final JLabel idLabel = new JLabel("아이디");
        final JLabel passwordLabel = new JLabel("비밀번호");

        idField = new JTextField(20);
        idField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        passwordField = new JPasswordField(20);
        passwordField.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

        final JButton loginButton = new JButton("로그인");
        loginButton.setForeground(Color.DARK_GRAY);
        loginButton.setBackground(SystemColor.activeCaption);
        loginButton.addActionListener(e -> loginButtonClicked());

        final JButton signupButton = new JButton("회원가입");
        signupButton.setForeground(Color.DARK_GRAY);
        signupButton.setBackground(SystemColor.activeCaption);
        signupButton.addActionListener(e -> signupButtonClicked());

        add(idLabel);
        add(idField);

        add(passwordLabel);
        add(passwordField);

        add(loginButton);
        add(signupButton);
    }

    public void loginButtonClicked() {
        final String id = idField.getText();
        final String password = Arrays.toString(passwordField.getPassword());
        final LoginRequest loginRequest = LoginRequest.of(id, password);
        try {
            final LoginResponse loginResponse = loginController.login(loginRequest);
            JOptionPane.showMessageDialog(this, loginResponse.getMember().getName() + "님 환영합니다. ");
            final String name = MenuView.class.getName();
            viewChanger.moveTo(name);
        } catch (final LoginFailureException ex) {
            JOptionPane.showMessageDialog(this, "로그인에 실패했습니다. " + ex.getMessage());
        }
    }

    public void signupButtonClicked() {
        final String name = SignupView.class.getName();
        viewChanger.moveTo(name);
    }

}
