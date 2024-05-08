package minibank.child.MovementPage;

import minibank.util.OpenNewWindow;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class MovementPageView extends JFrame {
    public MovementPageView() {
        // 初始化用户界面
        initializeUI();
    }

    private JTable table;  // 表格组件
    private DefaultTableModel model;  // 表格的数据模型
    private JScrollPane scrollPane;  // 滚动面板

    private void initializeUI() {
        setTitle("minibank");
        setSize(1200, 800); // 设置窗口大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中窗口
        setLayout(null); // 设置布局管理器为 null，实现绝对定位
        setResizable(false); //不允许调整大小

        // 底层图片背景
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/MovementPage.png"));

        // 创建一个标签并设置图片为标签的图标
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 1200, 800); // 设置图片位置和大小

        JButton buttonBack = createSwitchButton("Back", 1030, 720, 80, 25);               //返回上一界面

        //创建表格模型
        model = new DefaultTableModel();
        model.addColumn("Events");
        model.addColumn("Current Accounts");
        model.addColumn("Saving Accounts");

        table = new JTable(model);
        table.setBounds(200, 200, 600, 400); // 调整位置和大小
        table.setOpaque(false);
        table.setShowGrid(true); // 显示网格线
        table.setGridColor(Color.BLACK); // 设置网格线的颜色
        table.getColumnModel().getColumn(0).setPreferredWidth(280);
        table.getColumnModel().getColumn(1).setPreferredWidth(280);
        table.getColumnModel().getColumn(2).setPreferredWidth(280);
        table.setRowHeight(80);


        // 添加数据到表格手动添加只为展示效果，实际应该自动添加后端加油
        model.addRow(new Object[]{"Deposit", "100", "500"});
        model.addRow(new Object[]{"Withdraw", "50", "450"});
        model.addRow(new Object[]{"Deposit", "100", "500"});
        model.addRow(new Object[]{"Withdraw", "50", "450"});
        model.addRow(new Object[]{"Deposit", "100", "500"});
        model.addRow(new Object[]{"Withdraw", "50", "450"});
        model.addRow(new Object[]{"Deposit", "100", "500"});
        model.addRow(new Object[]{"Withdraw", "50", "450"});



        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(210, 180, 840, 450);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);



        // 创建层级面板并添加组件
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 750));
        layeredPane.add(imageLabel, Integer.valueOf(0));

        layeredPane.add(buttonBack, Integer.valueOf(1));
        layeredPane.add(scrollPane, Integer.valueOf(1));



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
    //    SwingUtilities.invokeLater(MovementPageView::new);
    //}
}







