package test;

import java.util.LinkedList;

//测试把一个对象放进两个list里面，在一个里面删除，另外一个还有吗？
public class TestList {


    public static void main(String[] args) {

        Dog dog=new Dog();

        LinkedList<Dog> list1=new LinkedList<>();
        LinkedList<Dog> list2=new LinkedList<>();
        list1.add(dog);
        list2.add(dog);
        System.out.println(list1.size());
        System.out.println(list2.size());
        list1.remove(dog);
        System.out.println(list1.size());
        System.out.println(list2.size());
    }

    public static class Dog {
        private String name;

        public Dog() {
        }
    }
}
