package minibank.datacenter;

/**
 * 操作记录数据类
 */
public class operationRecord_Date {
    public String operationName;//操作名称
    public float currentAccountChange;//活期存款变化
    public float saveAccountChange;//死期存款变化
    public String account;//操作对象账号名
    public String path;

    operationRecord_Date(String operationName, float currentAccountChange, float saveAccountChange, String account) {
        this.operationName = operationName;
        this.currentAccountChange = currentAccountChange;
        this.saveAccountChange = saveAccountChange;
        this.account = account;
    }
}
