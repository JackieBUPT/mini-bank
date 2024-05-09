package minibank.child;

import javax.swing.*;
import java.awt.*;

public class Dialog {
    public static void showDepositDialog(JFrame parent, int Amount, String name) {
        // 准备对话框内容
        JLabel promptLabel = new JLabel("Your want to "+ name + " "+ Amount + ", are you sure?");
        promptLabel.setFont(new Font("Arial", Font.BOLD, 20));
        promptLabel.setForeground(Color.BLACK);

        // 创建按钮
        JButton buttonSure = new JButton("Sure");
        JButton buttonNot = new JButton("Not");

        // 创建监听器
        buttonSure.addActionListener(e -> {
            // 处理确认操作
            System.out.println(name + " confirmed: " + Amount);
            // 在这里添加更新账户余额的代码
            closeDialog(buttonSure); // 关闭对话框
        });

        buttonNot.addActionListener(e -> {
            // 处理取消操作
            closeDialog(buttonNot); // 关闭对话框
        });

        // 创建面板并添加组件
        JPanel panel = new JPanel();
        panel.add(promptLabel);
        panel.add(buttonSure);
        panel.add(buttonNot);

        // 显示对话框
        JOptionPane.showOptionDialog(parent, panel, name+" Confirmation",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{}, null);
    }

    private static void closeDialog(Component component) {
        Window dialog = SwingUtilities.getWindowAncestor(component);
        if (dialog != null) {
            dialog.dispose();
        }
    }
}
