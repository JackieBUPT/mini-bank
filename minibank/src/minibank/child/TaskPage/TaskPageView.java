package minibank.child.TaskPage;

import minibank.child.OpenNewWindow.OpenNewWindow;

import javax.swing.*;
import java.awt.*;

public class TaskPageView extends JFrame {
    public TaskPageView() {
        // 初始化用户界面
        initializeUI();
    }

    private void initializeUI() {
        setTitle("minibank");
        setSize(1200, 800); // 设置窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中窗口
        setLayout(null); // 设置布局管理器为 null，实现绝对定位
        setResizable(false); //不允许调整大小

        // 底层图片背景
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/TaskPage.png"));

        // 创建一个标签并设置图片为标签的图标
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 1200, 800); // 设置图片位置和大小

        JButton buttonBack = createSwitchButton("Back", 1030, 720, 80, 25);               //返回上一界面

        // 图片中任务显示的和parent部分一致
        // 这里为任务显示部分的代码
        // 这里为任务显示部分的代码
        // 这里为任务显示部分的代码
        // 这里为任务显示部分的代码
        // 这里为任务显示部分的代码
        // 这里为任务显示部分的代码
        // 额外可增加翻页功能，若时间不足则单页显示，过期的记录自动删除无法查看

        // 创建层级面板并添加组件
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 750));
        layeredPane.add(imageLabel, Integer.valueOf(0));

        layeredPane.add(buttonBack, Integer.valueOf(1));
        // 设置层级面板为内容面板
        setContentPane(layeredPane);

        // 设置窗口可见
        setVisible(true);
    }

    //按钮创建方法
    private JButton createSwitchButton(String name, int x, int y, int width, int height) {
        JButton button = new JButton(name);
        button.setBounds(x, y, width, height); // 设置按钮的位置和尺寸
        button.addActionListener(e -> OpenNewWindow.openNew(name,this));
        return button;
    }



    //public static void main(String[] args) {
        // 使用 SwingUtilities.invokeLater 来确保 GUI 更新是线程安全的
    //    SwingUtilities.invokeLater(TaskPageView::new);
    //}
}
