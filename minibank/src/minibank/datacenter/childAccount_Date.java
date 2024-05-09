package minibank.datacenter;

/**
 * 账户数据类
 */
public class childAccount_Date {
    public String account;//账号名
    public String cryptographic;//密码
    public float currentDeposit;//活期存款
    public float storedDeposit;//死期存款
    public String lastLoginTime;//上次登录时间（用来计算利息）
    public String path;

    public childAccount_Date(String account, String cry){
        this.account=account;
        cryptographic=cry;
        currentDeposit =0;
        storedDeposit=0;
        lastLoginTime=myFunctions.getSystemTime();
    }

}
