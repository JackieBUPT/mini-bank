package minibank.login;
import minibank.child.MainPage.MainPageView;
import minibank.datacenter.jsonFunctions;
import minibank.datacenter.childAccount_Date;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class LoginPanel extends JPanel {



    private void openMainPage() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainPageView();  // 创建并显示主页面
            }
        });
    }

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPanel(Navigator navigator, Controller controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("用户名:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("密码:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // 使用 jsonFunctions 的验证方法
                List<childAccount_Date> childAccountDates=jsonFunctions.getAllAccountDateList();
                for(int i=0;i<childAccountDates.size();i++){
                    System.out.println(childAccountDates.get(i).account);
                    System.out.println(username);
                    if(childAccountDates.get(i).account.equals(username))
                    {
                        System.out.println(username);
                        if(childAccountDates.get(i).cryptographic.equals(password))
                        {
                            System.out.println("coreect");
                            JOptionPane.showMessageDialog(null, "登录成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
                            navigator.navigateToHome(); // 假设有方法来导航到主页
                            break;
                        }

                    }
                    if(i==childAccountDates.size()-1) {
                        JOptionPane.showMessageDialog(null, "用户名或密码错误！", "登录失败", JOptionPane.ERROR_MESSAGE);
                    }

                }

            }
        });
        add(loginButton);

        JButton registerButton = new JButton("注册新账户");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigator.navigateToRegister();
            }
        });
        add(registerButton);
    }
}
