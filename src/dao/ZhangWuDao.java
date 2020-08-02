package dao;

import domain.ZhangWu;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import tools.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @projectName:
 * @fileName:
 * @packageName: ZhangWudao
 * @author: Mr.乐
 * @date: 2020/7/13 20:38
 * @copyright(c): 无
 * @versions: 1.0版本
 * @instructions: 实现对象表gjp_zhangwu 数据的增删改查
 * dbuils 工具类，类成员创建QueryRunner对象，指定数据源
 */

public class ZhangWuDao {
    /**
     * JDBC的静态方法拿到数据源
     */
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月21日  08点45分
     * @Description: 定义方法，实现删除业务
     * 业务层调用，传递主键值
     */
    public void deleteZhangWu(int zwid) {
        try {
            String sql = "DELETE FROM gjp_zhangwu Where zwid=?";
            qr.update(sql, zwid);
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException("删除站务失败!");
        }

    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月15日 11点38分
     * @Description: 实现编辑账务功能，由业务层调用，传递ZhangWu对象
     * 将对象中的数据，更新到数据表中
     */
    public void editZhangWu(ZhangWu zw) {
        try {

            //更新数据的SQL语句
            String sql = "UPDATE gjp_zhangwu SET flname = ?,money = ?,zhangHu = ?,createtime = ?," +
                    "description = ? where zwid = ?";
            //定义对象数组，将所有的参数
            Object[] params = {zw.getFlname(), zw.getMoney(), zw.getZhanghu(), zw.getCreatetime(),
                    zw.getDescription(), zw.getZwid()};

            //调用qr对象，调用update执行更新
            qr.update(sql, params);
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException("账务编辑失败!");
        }
    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月14日 09点56分
     * @Description: 由业务层调用，传递ZhangWu对象
     * 将ZhangWu对象中的数据，添加到数据表
     */
    public void addZhangWu(ZhangWu zw) {
        try {
            //拼写添加数据的SQL
            String sql = "INSERT  INTO gjp_zhangwu(flname,money,zhangHu,createtime,description) ALUES(?,?,?,?,?))";
            //创建对象数组，存储5个占位符的实际参数
            //实际参数来源，传递过来的ZhangWu
            Object[] params = {zw.getFlname(), zw.getMoney(), zw.getZhanghu(), zw.getCreatetime(), zw.getDescription()};

            //调用qr对象中的方法，执行添加即可
            qr.update(sql, params);
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException("账务数据添加失败!");
        }
    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月14日 00点20分
     * @Description: 带条件去查询账务表，由业务层调用，查询结果集存储到Bean对象，存储到List集合
     * 调用者床底2个日期字符串
     */
    public List<ZhangWu> select(String startDate, String endDate) {
        try {

            //拼写条件查询的SQL语句
            String sql = "SELECT * FROM `gjp_zhangwu` WHERE createtime BETWEEN ? AND ?";
            //定义对象数组，来存储?占位符
            Object[] params = {startDate, endDate};
            //调用qr对象，获取结果集
            return qr.query(sql, new BeanListHandler<>(ZhangWu.class), params);
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new RuntimeException("条件查询失败!");
        }
    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月13日 21点40分
     * @Description: 查询数据库，获取所有的账务数据
     * 由业务层调用
     * 结果集，将所有的账务数据，村粗到Bean对象中，存储到集合中
     */
    public List<ZhangWu> selectAll() {

        try {
            //查询账务的SQL语句
            String sql = "SELECT * FROM gjp_zhangwu;";
            //调用qr对象的方法，query方法，结果集BeanListHandler
            //这个地方的异常，不能抛，如果抛，则所有相关的都会抛出，直接try{}
            List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
            return list;
        } catch (SQLException ex) {

            throw new RuntimeException("查询所有账务失败!");
        }

    }

}
