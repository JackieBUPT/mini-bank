package minibank.child.OpenNewWindow;

import minibank.child.DepositPage.DepositPageView;
import minibank.child.MainPage.MainPageView;
import minibank.child.MovementPage.MovementPageView;
import minibank.child.TaskPage.TaskPageView;
import minibank.child.WithdrawPage.WithdrawPageView;

import javax.swing.*;
import java.util.Objects;

public class OpenNewWindow {
    public static void openNew(String name, JFrame mainFrame) {
        mainFrame.setVisible(false);
        switch (name) {
            case "Deposit":
                new DepositPageView();
                break;
            case "Movement":
                new MovementPageView();
                break;
            case "Task":
                new TaskPageView();
                break;
            case "Withdraw":
                new WithdrawPageView();
                break;
            case "Back":
                new MainPageView();
                break;
            case "Task Management":
                System.exit(0);
                break;
            case "Saving Goals Setting":
                System.exit(0);
                break;
            case "Transaction Approval":
                System.exit(0);
                break;
            case "User Settings":
                System.exit(0);
                break;
            case "Kid's Accounts":
                System.exit(0);
                break;
            case "Home":
                System.exit(0); //房子按钮
                break;
            case "Return":
                System.exit(0); //电源按钮和return
                break;
            default:
                System.out.println("Invalid option: " + name);
                break;
        }
    }
}