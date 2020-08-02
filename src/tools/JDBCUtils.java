package tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * @projectName:
 * @fileName:
 * @packageName: JDBCUtils
 * @author: Mr.乐
 * @date: 2020/7/13 20:25
 * @copyright(c): 无
 * @versions: 1.0版本
 * @instructions:
 *      获取数据库连接的工具类
 *      实现连接池，DBCP连接池
 */

public class JDBCUtils {
    //创建BasicDataSource对象
    private static BasicDataSource datasource = new BasicDataSource();
    //静态代码块，实现必要参数设置
    static {
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/gjp");
        datasource.setUsername("root");
        datasource.setPassword("root");
        //最大激活5个
        datasource.setMaxIdle(5);
        //最小激活2个
        datasource.setMinIdle(2);
        //初始化10个
        datasource.setInitialSize(10);
    }

    public static DataSource getDataSource(){
        //返回一个实现列的对象
        return datasource;
    }
}
