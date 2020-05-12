import java.time.ZonedDateTime;

/**
 *  生成gateway路由中 时间
 */
public class T2
{
    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);

       //2020-05-12T20:30:58.944+08:00[Asia/Shanghai]
    }
}
