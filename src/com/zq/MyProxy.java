package com.zq;

/**
 * @author ZQ
 * @Date 2020/4/8
 */
public class MyProxy implements IUserDao {

    private UserA userA;

    public MyProxy(){
        this.userA = new UserA();
    }

    public void before(){
        System.out.println("before...");
    }

    @Override
    public void add() {
        before();
        userA.add();
    }
}
