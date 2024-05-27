package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 为UserService接口中定义的方法添加动态代理，使得调用方法时可以统计进行处理，
 * 从而，不必为每个方法编写相同的逻辑
 * 值得注意的是，代理本质返回的依旧是传入的类或接口，因此，返回值类型必须与传入的类或接口一致
 */
public class Proxy {
    public static UserService CreateDynamicProxy(UserService userService){
        UserService userServiceProxy = (UserService) java.lang.reflect.Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("addUser")){
                    long start_time = System.currentTimeMillis();
                    method.invoke(userService, args);
                    long end_time = System.currentTimeMillis();
                    System.out.println("添加用户总计耗时:" + (end_time - start_time));
                }else if (method.getName().equals("deleteUser")){
                    long start_time = System.currentTimeMillis();
                    method.invoke(userService, args);
                    long end_time = System.currentTimeMillis();
                    System.out.println("删除用户总计耗时:" + (end_time - start_time));
                } else{
                    System.out.println("查询成功!");
                }
                return "good job!";
            }
        });
        //返回创建的UserService类型的动态代理对象
        return userServiceProxy;
    }
}
