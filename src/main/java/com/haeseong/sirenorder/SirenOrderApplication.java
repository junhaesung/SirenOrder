package com.haeseong.sirenorder;

import com.haeseong.sirenorder.controller.LoginController;
import com.haeseong.sirenorder.controller.MenuController;
import com.haeseong.sirenorder.controller.SignupController;
import com.haeseong.sirenorder.controller.assembler.BeverageAssembler;
import com.haeseong.sirenorder.controller.assembler.CategoryAssembler;
import com.haeseong.sirenorder.controller.assembler.LoginAssembler;
import com.haeseong.sirenorder.controller.assembler.MemberAssembler;
import com.haeseong.sirenorder.model.repository.*;
import com.haeseong.sirenorder.model.service.*;
import com.haeseong.sirenorder.util.Context;
import com.haeseong.sirenorder.view.LoginView;
import com.haeseong.sirenorder.view.MenuView;
import com.haeseong.sirenorder.view.SignupView;
import com.haeseong.sirenorder.view.ViewChanger;

import javax.swing.*;

public class SirenOrderApplication {
    private Context applicationContext = new Context();
    private Context swingContext = new Context();

    public static void main(final String[] args) {
        final SirenOrderApplication application = new SirenOrderApplication();
        application.setupApplicationContext();
        application.setupSwingContext();

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(application::run);
    }

    public void setupApplicationContext() {
        // repository
        final MemberRepository memberRepository = new MemberRepositoryImpl();
        applicationContext.put(memberRepository);
        final CategoryRepository categoryRepository = new CategoryRepositoryImpl();
        applicationContext.put(categoryRepository);
        final BeverageRepository beverageRepository = new BeverageRepositoryImpl();
        applicationContext.put(beverageRepository);

        // service
        final MemberService memberService = new MemberServiceImpl(memberRepository);
        applicationContext.put(memberService);
        final CategoryService categoryService = new CategoryServiceImpl(categoryRepository);
        applicationContext.put(categoryService);
        final BeverageService beverageService = new BeverageServiceImpl(beverageRepository);
        applicationContext.put(beverageService);

        // assembler
        final MemberAssembler memberAssembler = new MemberAssembler();
        applicationContext.put(memberAssembler);
        final LoginAssembler loginAssembler = new LoginAssembler(memberAssembler);
        applicationContext.put(loginAssembler);
        final BeverageAssembler beverageAssembler = new BeverageAssembler();
        applicationContext.put(beverageAssembler);
        final CategoryAssembler categoryAssembler = new CategoryAssembler();
        applicationContext.put(categoryAssembler);

        // controller
        final LoginController loginController = new LoginController(memberService, loginAssembler);
        applicationContext.put(loginController);
        final SignupController signupController = new SignupController(memberService, memberAssembler);
        applicationContext.put(signupController);
        final MenuController menuController = new MenuController(categoryService, beverageService, categoryAssembler, beverageAssembler);
        applicationContext.put(menuController);
    }

    public void setupSwingContext() {
        final ViewChanger viewChanger = new ViewChanger();
        swingContext.put(viewChanger);

        // view
        final LoginView loginView = new LoginView(viewChanger, applicationContext.get(LoginController.class));
        swingContext.put(loginView);
        final SignupView signupView = new SignupView(viewChanger, applicationContext.get(SignupController.class));
        swingContext.put(signupView);
        final MenuView menuView = new MenuView(viewChanger, applicationContext.get(MenuController.class));
        swingContext.put(menuView);
    }

    public void run() {
        final JFrame mainFrame = new JFrame("SirenOrderApplication");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final ViewChanger viewChanger = swingContext.get(ViewChanger.class);
        mainFrame.getContentPane().add(viewChanger.getCardPanel());

        //Display the window.
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

}
