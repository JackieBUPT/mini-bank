
package minibank.datacenter;
import java.util.List;

public class test {
    public static void main(String[] args) {
        jsonFunctions.creatTask("clean",10,"Qia");
        List<childAccount_Date> list = jsonFunctions.getAllAccountDateList();
        for(childAccount_Date c:list){
            System.out.println(c.account);
        }

        List<operationRecord_Date> list1=jsonFunctions.getAllOperationRecord();
        for(operationRecord_Date o:list1){
            System.out.println(o.operationName);
        }
        jsonFunctions.calculateCurrentMoneyRate("Qia",1);

    }
}
