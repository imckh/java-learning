

## 判断线程是否停止

1. `static`this.interrupted() 执行后将状态清除
2. this.isInterrupted() 不清除状态


## 停止线程的方法
1. 异常法
    1. `interrupt`后抛出`InterruptedException`异常
    2. sleep中中断会抛出`InterruptedException`异常
2. 暴力停止-- `stop()` 
    1. 会给数据造成不一致的结果, 已被弃用
3. 使用return