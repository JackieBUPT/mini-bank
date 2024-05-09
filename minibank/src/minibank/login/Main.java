package minibank.login;
import javax.swing.JFrame;
public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("儿童虚拟银行系统");
        Navigator navigator = new Navigator(mainFrame);
        Controller controller = new Controller(navigator);
        navigator.setController(controller);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLocationRelativeTo(null); // 居中显示
        controller.startApplication(); // 启动应用程序
        mainFrame.setVisible(true);

    }
}

