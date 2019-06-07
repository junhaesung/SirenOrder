package com.haeseong.sirenorder.view;

import com.haeseong.sirenorder.controller.SignupController;
import com.haeseong.sirenorder.controller.dto.CheckIdRequest;
import com.haeseong.sirenorder.controller.dto.MemberResponse;
import com.haeseong.sirenorder.controller.dto.SignupRequest;
import com.haeseong.sirenorder.model.exception.SignupFailureException;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SignupView extends JPanel {
    private static final int MINIMUM_LENGTH_OF_ID = 2;
    private final ViewChanger viewChanger;
    private final SignupController signupController;

    private JLabel idLabel;
    private JLabel firstPasswordLabel;
    private JLabel secondPasswordLabel;
    private JLabel nameLabel;
    private JLabel phoneNumberLabel;

    private JTextField idField;
    private JPasswordField firstPasswordField;
    private JPasswordField secondPasswordField;
    private JTextField nameField;
    private JTextField phoneNumberField;

    private JButton cancelButton;
    private JButton signupButton;
    private JButton checkIdButton;

    public SignupView(final ViewChanger viewChanger,
                      final SignupController signupController) {
        this.viewChanger = viewChanger;
        this.signupController = signupController;
        init();
    }

    public void init() {
        viewChanger.addView(SignupView.class.getName(), this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        idLabel = new JLabel("아이디");
        firstPasswordLabel = new JLabel("비밀번호");
        secondPasswordLabel = new JLabel("비밀번호 확인");
        nameLabel = new JLabel("이름");
        phoneNumberLabel = new JLabel("연락처");

        idField = new JTextField(20);
        firstPasswordField = new JPasswordField(20);
        secondPasswordField = new JPasswordField(20);
        nameField = new JTextField(20);
        phoneNumberField = new JTextField(20);

        cancelButton = new JButton("돌아가기");
        cancelButton.addActionListener(e -> cancelButtonClicked());
        signupButton = new JButton("회원가입");
        signupButton.addActionListener(e -> signupButtonClicked());
        checkIdButton = new JButton("중복 확인");
        checkIdButton.addActionListener(e -> checkIdButtonClicked());

        add(createPanel(idLabel, idField, checkIdButton));
        add(createPanel(firstPasswordLabel, firstPasswordField));
        add(createPanel(secondPasswordLabel, secondPasswordField));
        add(createPanel(nameLabel, nameField));
        add(createPanel(phoneNumberLabel, phoneNumberField));
        add(createPanel(cancelButton, signupButton));
    }

    public Panel createPanel(final Component... components) {
        final Panel panel = new Panel();
        panel.setLayout(new FlowLayout());
        for (final Component component : components) {
            panel.add(component);
        }
        return panel;
    }

    public void checkIdButtonClicked() {
        final String id = idField.getText();
        final CheckIdRequest checkIdRequest = CheckIdRequest.from(id);
        final Boolean isIdAvailable = signupController.checkIdIsAvailable(checkIdRequest);
        if (isIdAvailable) {
            JOptionPane.showMessageDialog(this, "사용할 수 있는 아이디입니다.");
        } else {
            JOptionPane.showMessageDialog(this, "이미 사용중인 아이디입니다.");
        }
    }

    public void signupButtonClicked() {
        if (!Arrays.equals(firstPasswordField.getPassword(), secondPasswordField.getPassword())) {
            firstPasswordField.setText("");
            secondPasswordField.setText("");
            JOptionPane.showMessageDialog(this, "비밀번호가 맞지 않습니다. ");
            return;
        }
        final SignupRequest signupRequest = SignupRequest.of(
                idField.getText(),
                Arrays.toString(firstPasswordField.getPassword()),
                nameField.getText(),
                phoneNumberField.getText()
        );

        final MemberResponse memberResponse;
        try {
            memberResponse = signupController.signup(signupRequest);
        } catch (final SignupFailureException ex) {
            JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다. " + ex.getMessage());
            return;
        }
        viewChanger.moveTo(MenuView.class.getName());
    }

    public void cancelButtonClicked() {
        viewChanger.moveTo(LoginView.class.getName());
    }
}
