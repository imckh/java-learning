package designpattern.behavioral_pattern.visitor.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description:员工列表类：对象结构 </p>
 *
 * @author Cui Kaihui
 * @date 2019/6/27 22:21
 */
public class EmployeeList {
    //定义一个集合用于存储员工对象
    private List<Employee> list = new ArrayList<Employee>();

    public void addEmployee(Employee employee) {
        list.add(employee);
    }

    //遍历访问员工集合中的每一个员工对象
    public void accept(Department handler) {
        for (Object obj : list) {
            ((Employee) obj).accept(handler);
        }
    }
}
