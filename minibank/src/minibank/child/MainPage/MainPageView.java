package minibank.child.MainPage;


import minibank.util.OpenNewWindow;


import javax.swing.*;
import java.awt.*;


public class MainPageView extends JFrame {
    public MainPageView() {
        // 初始化用户界面
        initializeUI();
    }

    private void initializeUI() {
        setTitle("minibank");
        setSize(1200, 800); // 设置窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中窗口
        setLayout(null); // 设置布局管理器为 null，实现绝对定位
        setResizable(true); //不允许调整大小

        //右侧储蓄目标以及奖励和活期和存款显示   //(尚未完成，需要数据类)
        //JLabel goallabel = new JLabel("目标储蓄金额的变量");
        //goallabel.setBounds(100, 700, 1000, 50);
        //goallabel.setFont(new Font("Arial", Font.BOLD, 20));
        //goallabel.setForeground(Color.BLACK);
        //JLabel awardlabel = new JLabel("奖励金额的变量");
        //awardlabel.setBounds(100, 700, 1000, 50);
        //awardlabel.setFont(new Font("Arial", Font.BOLD, 20));
        //awardlabel.setForeground(Color.BLACK);

        //JLabel currentlabel = new JLabel("活期账户余额的变量");
        //currentlabel.setBounds(100, 700, 1000, 50);
        //currentlabel.setFont(new Font("Arial", Font.BOLD, 20));
        //currentlabel.setForeground(Color.BLACK);
        //JLabel savinglabel = new JLabel("储蓄账户余额的变量");
        //savinglabel.setBounds(100, 700, 1000, 50);
        //savinglabel.setFont(new Font("Arial", Font.BOLD, 20));
        //savinglabel.setForeground(Color.BLACK);
        //add();


        // 底层图片背景
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/MainPage.png"));

        // 创建一个标签并设置图片为标签的图标
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 1200, 800); // 设置图片位置和大小

        // 创建按钮并设置位置大小
        JButton buttonDeposit = createSwitchButton("Deposit", 150, 350, 150, 50);         //跳转存钱
        JButton buttonWithdraw = createSwitchButton("Withdraw", 465, 350, 150, 50);       //跳转取钱
        JButton buttonViewBalance = createSwitchButton("Task", 150, 570, 150, 50);        //跳转任务
        JButton buttonSettings = createSwitchButton("Movement", 465, 570, 150, 50);       //跳转明细
        JButton buttonBack = createSwitchButton("Return", 1030, 720, 80, 25);               //返回上一界面


        // 创建层级面板并添加组件
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 750));

        layeredPane.add(imageLabel, Integer.valueOf(0));

        layeredPane.add(buttonDeposit, Integer.valueOf(1));
        layeredPane.add(buttonWithdraw, Integer.valueOf(1));
        layeredPane.add(buttonViewBalance, Integer.valueOf(1));
        layeredPane.add(buttonSettings, Integer.valueOf(1));

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


    public static void main(String[] args) {
        // 使用 SwingUtilities.invokeLater 来确保 GUI 更新是线程安全的
        SwingUtilities.invokeLater(MainPageView::new);
    }
}

