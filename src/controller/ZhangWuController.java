package controller;

import dao.ZhangWuDao;
import domain.ZhangWu;

import java.util.List;

/**
 * @projectName:
 * @fileName:
 * @packageName: ZhangWuController
 * @author: Mr.乐
 * @date: 2020/7/13 20:48
 * @copyright(c): 无
 * @versions: 1.0版本
 * @instructions:
 *      控制器层
 *          接受试图层的数据，数据传递给Service层
 *          成员位置，创建Service对象
 */

public class ZhangWuController {
    private ZhangWuDao service = new ZhangWuDao();


    /**
     * @Author: Mr.乐
     * @Date: 2020年7月21日 08点38分
     * @Description:
     *      定义方法，实现删除账务功能
     *      视图层调用，传递int类型的主键
     *      调用serivce层方法，传递int主键
     */
    public  void deleteZhangWu(int zwid){
        service.deleteZhangWu(zwid);
    }

    /**
     * @Author: Mr.乐
     * @Date: 2020年7月14日 23点44分
     * @Description:
     *  由视图层调用，传递参数，也是ZhangWu对象
     *  嗲用service 层，传递ZhangWu对象
     */
    public void editZhangWu(ZhangWu zw){
        service.editZhangWu(zw);
    }


    /**
     * @Author: Mr.乐
     * @Date: 2020年7月14日 09点51分
     * @Description:
     *     由视图层调用，传递参数(传递过来的参数不能是5个参数，传递一个ZhangWu类型的对象)
     *     方法调用service层的方法，传递ZhangWu对象，获取到添加后的结果集(添加成功的行数，int)
     */
    public void addZhangWu(ZhangWu zw){
        service.addZhangWu(zw);
    }


    /**
     * @Author: Mr.乐
     * @Date: 2020年7月14日 00点06分
     * @Description:
     *      实现条件查询账务，定义由视图层调用，传递2个日期的字符串
     *      结果集返回给试图层
     */
    public List<ZhangWu> select(String startDate,String endDate){
        return service.select(startDate,endDate);
    }
    
    /**
     * @Author: Mr.乐 
     * @Date:  2020年7月13日 21点28分
     * @Description:
     *      控制层类定义方法，实现查询所有的账务数据
     *      方法由视图层调用，方法调用Service层
     */
    public List<ZhangWu> selectAll(){
        return service.selectAll();
    }



}
