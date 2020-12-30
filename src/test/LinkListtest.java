package test;

import java.util.LinkedList;
import java.util.List;

public class LinkListtest {

    public static void main(String[] args) {

        LinkedList<Cat> list=new LinkedList<>();
        LinkedList<Cat> list2=new LinkedList<>();

        list.addAll(list2);
        System.out.println("list的长度是"+list.size());
        list2.add(new Cat());
        list2.add(new Cat());
        System.out.println("再次打印list的长度是"+list.size());

    }

    public static class Cat{
        private String name;

        public Cat() {
        }
    }
}
