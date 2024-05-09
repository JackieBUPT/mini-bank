package minibank.login;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import minibank.datacenter.jsonFunctions;
public class RegisterPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public RegisterPanel(Navigator navigator, Controller controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // 用户名输入
        add(new JLabel("用户名:"));
        usernameField = new JTextField();
        add(usernameField);

        // 密码输入
        add(new JLabel("密码:"));
        passwordField = new JPasswordField();
        add(passwordField);

        // 确认密码输入
        add(new JLabel("确认密码:"));
        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        // 注册按钮
        JButton registerButton = new JButton("注册");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (!password.equals(confirmPassword)) {
                    navigator.showError("错误", "两次输入的密码不匹配，请重新输入！");
                    return;
                }
                jsonFunctions.creatNewAccount(username, password);
                controller.register(username, password);
            }
        });
        add(registerButton);

        // 返回登录界面按钮
        JButton backButton = new JButton("返回登录");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigator.navigateToLogin();
            }
        });
        add(backButton);
    }
}
