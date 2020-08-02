package service;

import dao.ZhangWuDao;
import domain.ZhangWu;

import java.util.List;

/**
 * @projectName:
 * @fileName:
 * @packageName: ZhangWUService
 * @author: Mr.乐
 * @date: 2020/7/13 20:41
 * @copyright(c): 无
 * @versions: 1.0版本
 * @instructions:
 *      业务层:
 *          接收上一层，控制层controller的数据
 *          经过计算，传递给dao层，操作数据库
 *          调用dao层红的类，类成员位置，创建Dao类的对象
 */

public class ZhangWuService {
    private ZhangWuDao dao = new ZhangWuDao();

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月21日 08点42分
     * @Description:
     *     定义方法，实现删除账务功能，控制层调用
     *     调用ZhangWuDao 层方法，传递int主键
     */
    public  void deleteZhangWu(int zwid){
        dao.deleteZhangWu(zwid);
    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月14日 23点59分
     * @Description:
     *   实现编辑账务，由控制层调用，传递ZhangWu对象
     *   调用dao层的方法，床底ZhangWu对象
     */
    public  void editZhangWu(ZhangWu zw){
        dao.editZhangWu(zw);
    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月14日 09点54分
     * @Description:
     *      由控制层调用，传递ZhangWu类型的对象
     *      调用dao层方法，传递ZhangWu对象
     */
    public void addZhangWu(ZhangWu zw){
        dao.addZhangWu(zw);
    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月14日 00点10分
     * @Description:
     *  实现条件查询账务
     *    方法由控制层调用，传递2个日期字符串
     *    调用dao层的方法，床底2个日期字符串
     *    获取查询的结果集
     */
    public List<ZhangWu> select(String startDate,String endDate){
        return dao.select(startDate,endDate);
    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月13日 21点30分
     * @Description:
     *      实现查询所有账务数据，此方法由控制层调用，去调用dao层方法
     *      返回存储账务的List集合
     */
    public List<ZhangWu> selectAll(){

        return dao.selectAll();
    }


}

