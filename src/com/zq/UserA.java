package com.zq;

/**
 * @author ZQ
 * @Date 2020/4/8
 */
public class UserA implements IUserDao {
    @Override
    public void add() {
        System.out.println("hello world");
    }
}
