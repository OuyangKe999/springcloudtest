import com.sun.javaws.Main;

import java.time.ZonedDateTime;

/**
 * @author: OuYangKe
 * @date:2020-07-25 02:17
 * @description:获取时间
 */
public class T {
    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); //默认时区
        System.out.println(zbj);
        //2020-07-25T02:21:23.487+08:00[Asia/Shanghai]
    }
}
