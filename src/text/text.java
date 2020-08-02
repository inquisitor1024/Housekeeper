package text;

import java.util.Scanner;

/**
 * @projectName:
 * @fileName:
 * @packageName: text
 * @author: Mr.乐
 * @date: 2020/7/21 8:54
 * @copyright(c): 无
 * @versions: 1.0版本
 * @instructions:
 */

public class text {
    public static void main(String[] arge){
        Scanner sc = new Scanner(System.in);
        String sys = sc.nextLine();
        if ("是".equals(sys)) {
            System.out.println("删除中...");
            //调用控制层方法，传递主键ID

            //删除成功
            System.out.println("删除成功!");
        } else {
            System.out.println("取消删除");
        }
    }
}
