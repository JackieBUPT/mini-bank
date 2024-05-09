package minibank.login;
import minibank.child.MainPage.MainPageView;
import javax.swing.*;

public class Navigator {
    private JFrame frame;
    private Controller controller;

    public Navigator(JFrame frame) {
        this.frame = frame;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void navigateToLogin() {
        LoginPanel loginPanel = new LoginPanel(this, controller);
        frame.setContentPane(loginPanel);
        frame.revalidate();
    }

    public void navigateToHome() {
        MainPageView mainPageView = new MainPageView(); // 假设 MainPageView 修改为 JPanel
        frame.setContentPane(mainPageView);
        frame.validate();
    }


    public void navigateToRegister() {
        RegisterPanel registerPanel = new RegisterPanel(this, controller);
        frame.setContentPane(registerPanel);
        frame.revalidate();
    }

    public void showError(String title, String message) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public void showInfo(String title, String message) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
