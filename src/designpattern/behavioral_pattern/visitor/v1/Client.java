package designpattern.behavioral_pattern.visitor.v1;

import designpattern.util.XMLUtil;

/**
 * <p>Description: </p>
 *
 * @author Cui Kaihui
 * @date 2019/6/27 22:23
 */
public class Client {
    public static void main(String args[]) {
        EmployeeList list = new EmployeeList();
        Employee fte1, fte2, fte3, pte1, pte2;
        fte1 = new FulltimeEmployee("张无忌", 3200.00, 45);
        fte2 = new FulltimeEmployee("杨过", 2000.00, 40);
        fte3 = new FulltimeEmployee("段誉", 2400.00, 38);
        pte1 = new ParttimeEmployee("洪七公", 80.00, 20);
        pte2 = new ParttimeEmployee("郭靖", 60.00, 18);
        list.addEmployee(fte1);
        list.addEmployee(fte2);
        list.addEmployee(fte3);
        list.addEmployee(pte1);
        list.addEmployee(pte2);
        Department dep;
        dep = (Department) XMLUtil.getBean("designpattern.behavioral_pattern.visitor.v1.Department");
        list.accept(dep);
        /*
        正式员工张无忌实际工作时间为：45小时。
        正式员工张无忌加班时间为：5小时。
        正式员工杨过实际工作时间为：40小时。
        正式员工段誉实际工作时间为：38小时。
        正式员工段誉请假时间为：2小时。
        临时工洪七公实际工作时间为：20小时。
        临时工郭靖实际工作时间为：18小时。
         */
    }
}
