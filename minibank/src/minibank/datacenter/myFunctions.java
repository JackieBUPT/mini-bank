package minibank.datacenter;
import com.google.gson.Gson;

import java.time.Duration;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class myFunctions {
    public static Path accountDatePath= Paths.get("src/resources/date");
    public static Path operationDatePath= Paths.get("src/resources/date/OperationRecord");
    public static Gson gson = new Gson();
    /**
     * 写json文件
     * @param content json写入的内容
     * @param path json路径
     */
    public  static void writeJson(String content,String path){
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(content);
            System.out.println("JSON文件已保存到：" + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获得系统时间的字符串形式
     * @return 当前系统时间(精确到小时)
     */
    public static String getSystemTime(){
        LocalDateTime now = LocalDateTime.now();
        // 调整时间，使其只精确到分
        LocalDateTime hourPrecision = now.withSecond(0).withNano(0);
        // 格式化时间输出
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return hourPrecision.format(formatter);
    }

    /**
     *
     * 获取两时间的小时差值
     * @param time1
     * @param time2
     * @return 小时差(int)
     */
    public  static int calculateTimeDifference(LocalDateTime time1, LocalDateTime time2){
        Duration duration = Duration.between(time1, time2);
        long hours = duration.toHours();
        return (int)hours;
    }

}
