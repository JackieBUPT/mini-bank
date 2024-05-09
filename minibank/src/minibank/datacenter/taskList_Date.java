package minibank.datacenter;

/**
任务数据类
 */
public class taskList_Date {
    public String taskName;//任务名称
    public int reward;//任务奖励
    public String startTimeString;//任务创建时间(字符串)
    public String targetAccount;//任务目标账户
    public String path;
    /**
    * @param taskName 任务名称
     * @param reward 任务奖励
     */
    public taskList_Date(String taskName, int reward,String targetAccount){
        this.taskName = taskName;
        this.reward = reward;
        startTimeString = myFunctions.getSystemTime();
        this.targetAccount = targetAccount;
    }

}
