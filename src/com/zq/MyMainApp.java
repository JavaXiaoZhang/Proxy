package com.zq;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.Callback;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ZQ
 * @Date 2020/4/8
 */
public class MyMainApp {
    public static void main(String[] args) {
        //静态代理
       // MyProxy myProxy = new MyProxy();
        //myProxy.add();

        //JDK动态代理
//        IUserDao userA = new UserA();
//        IUserDao proxyInstance = (IUserDao) Proxy.newProxyInstance(UserA.class.getClassLoader(), UserA.class.getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                if (method.getName().equals("add")){
//                    System.out.println("before...");
//                    method.invoke(userA, args);
//                }
//                return null;
//            }
//        });
//        proxyInstance.add();
        MyCGLibProxy myCGLibProxy = new MyCGLibProxy(new UserA());
        IUserDao proxy = myCGLibProxy.getProxy();
        proxy.add();
    }

}
class MyCGLibProxy implements MethodInterceptor{

    private IUserDao userDao;

    public MyCGLibProxy(IUserDao userDao) {
        this.userDao = userDao;
    }

    public IUserDao getProxy(){
        //CGLib动态代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(IUserDao.class);
        enhancer.setCallback(new MyCGLibProxy(new UserA()));
        return  (IUserDao) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before...");
        method.invoke(userDao, args);
        return null;
    }
}