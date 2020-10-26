package com.zq;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ZQ
 * @Date 2020/4/15
 */
public class MyTest {
        public final static ArrayList<Cat> CATS = new ArrayList<>();

        public static void main(String[] args)  {
            Scanner sc = new Scanner(System.in);

            while (true) {
                String name = sc.nextLine();

                if (name ==null || name.isEmpty()){
                    break;
                }
                else{
                    int age = sc.nextInt();
                    int  weight = sc.nextInt();
                    int tailLength = sc.nextInt();
                    Cat cat = new Cat(name,age,weight,tailLength);
                    CATS.add(cat);
                }

            }

            printList();
        }

        public static void printList() {
            for (Cat cat :CATS) {
                System.out.println(cat);
            }
        }

        public static class Cat {
            private String name;
            private int age;
            private int weight;
            private int tailLength;

            Cat(String name, int age, int weight, int tailLength) {
                this.name = name;
                this.age = age;
                this.weight = weight;
                this.tailLength = tailLength;
            }



            @Override
            public String toString() {
                return "猫的名字：" + name + "，年龄：" + age + "，体重：" + weight + "，尾巴：" + tailLength;
            }
        }
}
