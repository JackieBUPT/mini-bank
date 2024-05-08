package minibank.child.WithdrawPage;

import minibank.util.OpenNewWindow;

import javax.swing.*;
import java.awt.*;

import static minibank.util.Dialog.showDepositDialog;

public class WithdrawPageView extends JFrame {
    private JTextField inputTextField;
    public WithdrawPageView() {
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
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/WithdrawPage.png"));

        // 创建一个标签并设置图片为标签的图标
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 1200, 800); // 设置图片位置和大小

        inputTextField = new JTextField();
        inputTextField.setEditable(false);
        inputTextField.setBounds(115, 300, 240, 150);
        add(inputTextField);

        // 创建输入按钮并设置位置大小
        // 设置字体样式：字体名称，样式（普通，粗体，斜体），字体大小
        //button7.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton button7 = createButton("7", 115, 385, 80, 50);
        JButton button8 = createButton("8", 195, 385, 80, 50);
        JButton button9 = createButton("9", 275, 385, 80, 50);
        JButton button4 = createButton("4", 115, 435, 80, 50);
        JButton button5 = createButton("5", 195, 435, 80, 50);
        JButton button6 = createButton("6", 275, 435, 80, 50);
        JButton button1 = createButton("1", 115, 485, 80, 50);
        JButton button2 = createButton("2", 195, 485, 80, 50);
        JButton button3 = createButton("3", 275, 485, 80, 50);
        JButton button0 = createButton("0", 115, 535, 80, 50);
        JButton buttonDelete = createButton("←", 195, 535, 50, 50);
        JButton buttonDeposit = createButton("withdraw", 245, 535, 110, 50);
        JButton buttonBack = createSwitchButton("Back", 1030, 720, 80, 25);               //返回上一界面

        //显示输入的取钱额度  //（尚未完成，需要实现点击对应的按钮，文本就会显示出对应的数字，此时输入的数字字符串啊转化为整数型，并被记录为取钱的金额）
//        JTextField inputTextField = createTextField(115, 260, 240, 150);
//        Color lightBlue = new Color(217, 228, 239); // 设置颜色
//        inputTextField.setBackground(lightBlue);
//        inputTextField.setEditable(false);
//        add(inputTextField);

        // 创建最下方提示取钱的JLabel以及sure/not按钮  //(尚未完成，需要实现点击buttonDeposit按钮才显示下方的提示文本以及输入的内容和按钮，文本deposit后边显示取钱数额的变量)
//        JLabel promptlabel = new JLabel("Your want to withdraw  这里为取钱金额变量, are you sure?");
//        promptlabel.setBounds(100, 700, 1000, 50);  // 设置标签的位置和大小（x, y, width, height）
//        promptlabel.setFont(new Font("Arial", Font.BOLD, 20));
//        promptlabel.setForeground(Color.BLACK);
//        add(promptlabel);
//        JButton buttonSure = createButton("Sure", 600, 710, 80, 30);  //点击后应立即计算活期余额和储蓄金额
//        JButton buttonNot = createButton("Not", 730, 710, 80, 30);    //点击后回到显示提示取钱确定与否之前

        //右侧活期和存款显示   //(尚未完成，需要数据类)
        //JLabel currentlabel = new JLabel("活期账户余额的变量");
        //currentlabel.setBounds(100, 700, 1000, 50);
        //currentlabel.setFont(new Font("Arial", Font.BOLD, 20));
        //currentlabel.setForeground(Color.BLACK);
        //JLabel savinglabel = new JLabel("储蓄账户余额的变量");
        //savinglabel.setBounds(100, 700, 1000, 50);
        //savinglabel.setFont(new Font("Arial", Font.BOLD, 20));
        //savinglabel.setForeground(Color.BLACK);
        //add();

        // 创建层级面板并添加组件
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 750));
        layeredPane.add(imageLabel, Integer.valueOf(0));
        layeredPane.add(button9, Integer.valueOf(1));
        layeredPane.add(button8, Integer.valueOf(1));
        layeredPane.add(button7, Integer.valueOf(1));
        layeredPane.add(button6, Integer.valueOf(1));
        layeredPane.add(button5, Integer.valueOf(1));
        layeredPane.add(button4, Integer.valueOf(1));
        layeredPane.add(button3, Integer.valueOf(1));
        layeredPane.add(button2, Integer.valueOf(1));
        layeredPane.add(button1, Integer.valueOf(1));
        layeredPane.add(button0, Integer.valueOf(1));
        layeredPane.add(buttonDeposit, Integer.valueOf(1));
        layeredPane.add(buttonDelete, Integer.valueOf(1));
        layeredPane.add(buttonBack, Integer.valueOf(1));

        layeredPane.add(inputTextField, Integer.valueOf(1));
//        layeredPane.add(promptlabel, Integer.valueOf(1));
//        layeredPane.add(buttonNot, Integer.valueOf(1));
//        layeredPane.add(buttonSure, Integer.valueOf(1));

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
    private JButton createButton(String name, int x, int y, int width, int height){
        JButton button = new JButton(name);
        button.setBounds(x, y, width, height);
        button.addActionListener(e -> {
            if (name.equals("←")) {
                String text = inputTextField.getText();
                if (text.length() > 0) {
                    inputTextField.setText(text.substring(0, text.length() - 1));  // 删除最后一个字符
                }
            }
            else if(name.equals("withdraw")){
                acknowledgeWindow(Integer.parseInt(inputTextField.getText()));
                inputTextField.setText("");
            }else {
                inputTextField.setText(inputTextField.getText() + name);
            }
        });
        return button;
    }
    private void acknowledgeWindow(int name){
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            showDepositDialog(frame,name,"withdraw");
            frame.setVisible(false);
        });
    }
}