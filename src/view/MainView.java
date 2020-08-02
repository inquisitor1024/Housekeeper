package view;

import controller.ZhangWuController;
import domain.ZhangWu;

import java.util.List;
import java.util.Scanner;

/**
 * @projectName:
 * @fileName:
 * @packageName: MainView
 * @author: Mr.乐
 * @date: 2020/7/13 20:46
 * @copyright(c): 无
 * @versions: 1.0版本
 * @instructions: 视图层，，用户看到和操作的界面
 * 数据传递给Controller层实现
 * 成员位置，创建Contrller对象
 */

public class MainView {
    private ZhangWuController controller = new ZhangWuController();
    Scanner sc = new Scanner(System.in);

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月13日 20点55分
     * @Description: 实现界面效果
     * 接受用户输入
     * 根据数据，调用不同的功能方法
     */
    public void run() {

        //创建Canner类对象，反复键盘输入
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("1.添加账务\n2.编辑账务\n3.删除账务\n4.查询账务\n5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");
            //接收用户的菜单选择
            int choose = sc.nextInt();

            //对选择的菜单判断，调用不同的功能
            switch (choose) {
                case 1:
                    System.out.println("添加账务");
                    addZhangWu();
                    break;
                case 2:
                    selectAll();
                    System.out.println("编辑账务");
                    editZhangWu();
                    break;
                case 3:
                    System.out.println("删除账务");
                    deleteZhangWu();
                    break;
                case 4:
                    System.out.println("查询账务");
                    selectZhangWu();
                    break;
                case 5:
                    System.exit(0);

                default:
                    System.out.println("请输入有效数字");
                    break;

            }

        }

    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月21日 08点26分
     * @Description: 实现账务的删除，接受用户的输入一个主键数
     * 调用控制层方法传递一个主键
     */
    public void deleteZhangWu() {
        selectAll();
        System.out.println("请输入需要删除的内容，的主键ID编号");
        int zwid = sc.nextInt();

        //调用控制层方法，传递主键ID
        controller.deleteZhangWu(zwid);

    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月21日 08点33分
     * @Description: 再次确定时候真要删除此内容
     */
    public void reconfirm() {

    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月14日 22点24分
     * @Description: 实现对账务的编辑功能
     * 实现思想:
     * 接受用户的信息，封装成Z'hangWu对象
     * 调用控制层的方法，传递封装好ZhangWu对象，实现编辑
     */
    public void editZhangWu() {
        //调用查询所有账务数据的功能，显示所哟出来
        //看到所有数据，从中选择一项，进行修改
        System.out.println("选择编辑功能，请输入数据");
        System.out.println("请输入ID:");
        int zwid = sc.nextInt();
        System.out.println("请输入类别名称");
        String flname = sc.next();
        System.out.println("请输入金额");
        double money = sc.nextDouble();
        System.out.println("请输入账户");
        String zhangHu = sc.next();
        System.out.println("请输入日期:XXXX-XX-XX");
        String createtime = sc.next();
        System.out.println("输入具体描述");
        String description = sc.next();
        //将用户输入的所有参数，封装陈ZhangWu对象
        //输入的ID，必须封装对象，不然就会由风险
        ZhangWu zw = new ZhangWu(zwid, flname, money, zhangHu, createtime, description);
        //调用controller层
        controller.editZhangWu(zw);
        System.out.println("账务编辑成功!");

    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月14日 09点35分
     * @Description: 添加账务方法，用户在界面中选择菜单1的时候调用
     * 接收到用户的项目输入的5项内容，调用controller层方法
     */
    public void addZhangWu() {
        System.out.println("选择添加账务功能，请输入以下内容");
        System.out.println("请输入类别名称");
        String flname = sc.next();
        System.out.println("请输入金额");
        double money = sc.nextDouble();
        System.out.println("请输入账户");
        String zhangHu = sc.next();
        System.out.println("请输入日期:XXXX-XX-XX");
        String createtime = sc.next();
        System.out.println("输入具体描述");
        String description = sc.next();
        //接收到的数据，调用controller层的方法，传递数据增加
        //将用户输入的所有参数，封装陈ZhangWu对象
        ZhangWu zw = new ZhangWu(0, flname, money, zhangHu, createtime, description);
        controller.addZhangWu(zw);
        System.out.println("账务数据添加成功!");
    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月13日 21点17分
     * @Description: 显示查询方式
     */

    public void selectZhangWu() {
        System.out.println("1、查询所有信息\n2、按照条件查询");
        int selectChooser = sc.nextInt();
        switch (selectChooser) {
            case 1:
                //调用查询所有的方法
                selectAll();
                break;
            case 2:
                //调用按照条件查询的方法
                select();
                break;
            default:
                System.out.println("请输入有效数字");

        }
    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月13日 21点23分
     * @Description: 按照条件查询数据库中的表
     * 提供用户的输入日期区间范围,开始与结束日期
     * 将2个日期，传递到controller方法，传递2个日期参数
     * 获取到controller查询的结果集，打印出来
     */
    public void select() {
        System.out.println("按照'XXXX-XX-XX'格式输入");
        System.out.println("请输入开始日期");
        String startDate = sc.nextLine();
        System.out.println("请输入结束日期");
        String endDate = sc.nextLine();
        //调用controller层方法，传递日期，获取查询结果集
        List<ZhangWu> list = controller.select(startDate, endDate);
        if (list.size() != 0) {
            print(list);
        } else {
            System.out.println("提示:你查找的信息不存在!");
        }

    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月13日 21点22分
     * @Description: 查询所有
     */
    public void selectAll() {
        //调用控制层的方法，查询所有数据
        List<ZhangWu> list = controller.selectAll();
        //输出表头
        print(list);
    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月14日 09点21分
     * @Description: 表的遍历
     */
    private void print(List<ZhangWu> list) {
        //输出表头
        System.out.println("ID\t\t类别\t\t\t账户\t\t\t金额\t\t\t时间\t\t\t说明");
        //遍历集合
        for (ZhangWu zw : list) {
            System.out.println(zw.getZwid() + "\t\t" + zw.getFlname() +
                    "\t\t" + zw.getMoney() + "\t\t" + zw.getZhanghu() +
                    "\t\t" + zw.getCreatetime() + "\t\t" + zw.getDescription());

        }
    }
}
