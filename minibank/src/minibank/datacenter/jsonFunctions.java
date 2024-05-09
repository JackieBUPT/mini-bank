package minibank.datacenter;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;
public  class jsonFunctions {
    public static childAccount_Date nowAccountDate=null;//当前登录的账户数据
    //防止实例化
    private  jsonFunctions(){}

///////////////////////////////////json数据创建//////////////////////////////////


     /**
      *创建新账户
      * @param account 账户
      * @param cry 密码
      */
    public static void creatNewAccount(String account,String cry){
        childAccount_Date childAccountDate=new childAccount_Date(account,cry);
        Gson gson=new Gson();

        try {
            Files.createDirectories(myFunctions.accountDatePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.createDirectories(Paths.get(myFunctions.accountDatePath.toString(),account));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filePath=myFunctions.accountDatePath.toString()+"/"+account+ "_j.json";
        childAccountDate.path=filePath;
        String json=gson.toJson(childAccountDate);
        // 将JSON字符串写入文件
        myFunctions.writeJson(json,filePath);

    }

     /**
      * 创建一个任务并绑定给特定账户
      * @param taskName 任务名称
      * @param reward   任务奖励
      * @param targetAccount 任务目标账户
      */
    public static void creatTask(String taskName, int reward,String targetAccount){
        //获取目标账户任务文件夹
        String targetAccountPath=Paths.get(myFunctions.accountDatePath.toString(),targetAccount).toString();
        File file=new File(targetAccountPath);
        //确定文件路径存在
        if(file.exists())
        {
        taskList_Date task=new taskList_Date(taskName,reward,targetAccount);
        Gson gson=new Gson();

        String filePath=targetAccountPath+"/"+taskName+".json";
        task.path=filePath;
        String json=gson.toJson(task);
        myFunctions.writeJson(json,filePath);
        }
    }

    /**
     * 创建操作记录数据
     * @param operationName 操作名称
     * @param currentAccountChange 活期存款变化
     * @param saveAccountChange 死期存款变化
     * @param targetAccount 操作对象账号名
     */
    public static void creatOperationRecord(String operationName,float currentAccountChange,float saveAccountChange,String targetAccount){
        try {
            Files.createDirectories(Paths.get(myFunctions.accountDatePath.toString(),"OperationRecord"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path =Paths.get(myFunctions.accountDatePath.toString(),"OperationRecord");
        File file=new File(myFunctions.operationDatePath.toString());
        File[] files=file.listFiles();
        String filePath=path.toString()+"/"+operationName+"_"+targetAccount+files.length+".json";
        operationRecord_Date operationRecordDate=new operationRecord_Date(operationName,currentAccountChange,saveAccountChange,targetAccount);
        Gson gson=new Gson();

        operationRecordDate.path=filePath;
        String json=gson.toJson(operationRecordDate);
        myFunctions.writeJson(json,filePath);
    }

////////////////////////////////////读取/搜索json文件//////////////////////////////////////////

                    ///////////////获取账户/////////////////
    /**
     * 获取所有账户信息
     * @return 所有账户信息类列表
     */
    public static List<childAccount_Date> getAllAccountDateList(){
        List<childAccount_Date> list=new ArrayList<>();
        File file=new File(myFunctions.accountDatePath.toString());
        File[] files=file.listFiles();
        if(files!=null){
            for (File f : files) {
                if(f.isFile() && f.getName().toLowerCase().endsWith(".json")){

                    try(FileReader reader=new FileReader(f.getAbsolutePath());) {
                        Gson gson=new Gson();
                        childAccount_Date childAccountDate=gson.fromJson(reader,childAccount_Date.class);
                        list.add(childAccountDate);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        return list;
    }
    /**
     * 根据账户的账号搜索并返回账号值对应的账户信息类
     * @param account 账户账号信息
     * @return 账户信息类
     */
    public static childAccount_Date getAccountDateByAccount( String account){
        List<childAccount_Date> list=getAllAccountDateList();
        for(childAccount_Date childAccountDate:list){
            if(childAccountDate.account.equals(account)){
                return childAccountDate;
            }
        }
        return null;
    }
                        //////////////获取任务///////////////////



    /**
     * 获取所有任务类列表
     * @return 所有任务类列表
     */
    public static  List<taskList_Date> getAllTaskDateList(){
        List<taskList_Date> list=new ArrayList<>();
        File file=new File(myFunctions.accountDatePath.toString());
        File[] files=file.listFiles();
        if(files!=null){
            for (File f : files) {
                    String accountFilePath= f.getAbsolutePath();
                    File accountFile=new File(accountFilePath);
                    File[] accountFiles=accountFile.listFiles();
                    if(accountFiles!=null){
                        for (File f2 : accountFiles) {
                            if(f2.isFile() && f2.getName().toLowerCase().endsWith(".json")){

                                try(FileReader reader=new FileReader(f2.getAbsolutePath());) {
                                    Gson gson=new Gson();
                                    taskList_Date taskListDate=gson.fromJson(reader,taskList_Date.class);
                                    list.add(taskListDate);
                                }
                                catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }

            }
        }
        return list;
    }

    /**
     * 获取某个账户的任务类列表
     * @param account 目标账户
     * @return 目标账户任务类列表
     */
    public static  List<taskList_Date> getTaskDateList(String account){
        List<taskList_Date> list=new ArrayList<>();
        File file=new File(myFunctions.accountDatePath.toString());
        File[] files=file.listFiles();
        if(files!=null){
            for (File f : files) {
                if( f.getName().equals(account)){
                    String accountFilePath= f.getAbsolutePath();
                    File accountFile=new File(accountFilePath);
                    File[] accountFiles=accountFile.listFiles();
                    if(accountFiles!=null){
                        for (File f2 : accountFiles) {
                            if(f2.isFile() && f2.getName().toLowerCase().endsWith(".json")){

                                try(FileReader reader=new FileReader(f2.getAbsolutePath());) {
                                    Gson gson=new Gson();
                                    taskList_Date taskListDate=gson.fromJson(reader,taskList_Date.class);
                                    list.add(taskListDate);
                                }
                                catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }
                }
            }
        }
        return list;
    }
                            /////////////获取操作记录//////////////

    /**
     * 获得所有操作记录类列表
     * @return 操作记录类列表
     */
    public static List<operationRecord_Date> getAllOperationRecord(){
        List<operationRecord_Date> list=new ArrayList<>();
        File file=new File(myFunctions.operationDatePath.toString());
        File[] files=file.listFiles();
        if(files!=null){
            for (File f : files) {
                if(f.isFile() && f.getName().toLowerCase().endsWith(".json")){
                    try(FileReader reader=new FileReader(f.getAbsolutePath());) {
                        Gson gson=new Gson();
                        operationRecord_Date operationRecordDate=gson.fromJson(reader,operationRecord_Date.class);
                        list.add(operationRecordDate);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return list;
    }

    /**
     * 根据账户的账号获取对应的操作记录类列表
     * @param account 账户的账号名
     * @return 操作记录类列表
     */
    public static List<operationRecord_Date> getOperationRecordByAccount(String account){
        List<operationRecord_Date> list=new ArrayList<>();
        File file=new File(myFunctions.operationDatePath.toString());
        File[] files=file.listFiles();
        if(files!=null){
            for (File f : files) {
                if(f.isFile() && f.getName().toLowerCase().endsWith(".json")){
                    try(FileReader reader=new FileReader(f.getAbsolutePath());) {
                        Gson gson=new Gson();
                        operationRecord_Date operationRecordDate=gson.fromJson(reader,operationRecord_Date.class);
                        if(operationRecordDate.account.equals(account)){
                        list.add(operationRecordDate);
                        }
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return list;
    }



  /////////////////////////////////////////////////实现操作和功能函数/////////////////////////////////////////////////
                            ///////////////////功能函数/////////////////////
    /**
     * 计算某个时间到当前系统时间的小时差值
     * @param time 传入的时间
     * @return 传入时间与当前系统时间的小时差
     */
    public static int calculateTimeDifferenceToNow(String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime dateTime = LocalDateTime.parse(time, formatter);
       return myFunctions.calculateTimeDifference(dateTime,LocalDateTime.now());
    }
                            //////////////////数据修改操作////////////////////

    /**
     * 在登录时初始化当前登录账户
     * @param account
     */
    public static void changeNowAccount(String account){
        childAccount_Date accountDate = jsonFunctions.getAccountDateByAccount(account);
        if(accountDate!=null){
            jsonFunctions.nowAccountDate=accountDate;
        }
    }

    /**
     * 计算并实现某个账户的活期存款利息并创建对应的操作记录
     * @param account 账户的账号名称
     * @param rateEveryHour 每小时的利率(如为百分制请转换为小数)
     * ps:已实现创建操作记录
     */
    public static void calculateCurrentMoneyRate(String account,float rateEveryHour){
         childAccount_Date accountDate = jsonFunctions.getAccountDateByAccount(account);
         if (accountDate!=null){
         int hours=calculateTimeDifferenceToNow(accountDate.lastLoginTime);
         if(hours>=1) {
             accountDate.currentDeposit += accountDate.currentDeposit * rateEveryHour * hours;
             accountDate.lastLoginTime = myFunctions.getSystemTime();
             Gson gson = new Gson();
             String json = gson.toJson(accountDate);
             myFunctions.writeJson(json, accountDate.path);
             jsonFunctions.creatOperationRecord("interest", accountDate.currentDeposit * rateEveryHour * hours, 0, account);
            }
         }
    }

    /**
     * 向某个账户中的活期存款修改金额
     * @param account 账户的账号名
     * @param num 修改金额数
     */
    public static void changeCurrentDeposit(String account,float num){
        childAccount_Date accountDate = jsonFunctions.getAccountDateByAccount(account);
        if (accountDate != null) {
            accountDate.currentDeposit+=num;
            String json=myFunctions.gson.toJson(accountDate);
             myFunctions.writeJson(json, accountDate.path);
        }
    }

    /**
     * 向某个账户中的死期存款修改金额
     * @param account 账户的账号名
     * @param num 修改金额数
     */
    public static void changeStoredDeposit(String account,float num){
        childAccount_Date accountDate = jsonFunctions.getAccountDateByAccount(account);
        if (accountDate != null) {
            accountDate.storedDeposit += num;
            String json = myFunctions.gson.toJson(accountDate);
            myFunctions.writeJson(json, accountDate.path);
        }
    }

}
