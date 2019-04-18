package designpattern.creational_pattern.singleton_pattern.v0;

public class TaskManager {
    private static TaskManager tm = null;
    private TaskManager() {} //初始化窗口
    public void displayProcesses() {} //显示进程
    public void displayServices() {} //显示服务
    public static TaskManager getInstance()
    {
        if (tm == null)
        {
            tm = new TaskManager();
        }
        return tm;
    }

}
