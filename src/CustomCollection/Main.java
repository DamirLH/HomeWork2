package CustomCollection;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(10);
        listOfIntegers.add(20);
        listOfIntegers.add(30);
        listOfIntegers.add(40);


        CustomArrayList<Integer> list1 =new CustomArrayList<>(listOfIntegers);
        System.out.println("Конструктор принимающий другую коллекцию в качестве параметра: "+list1);


        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(5);
        list.add(251);
        list.add(15);
        list.add(8);
        System.out.println("Коллекция до сортировки: "+list);

        CustomArrayList.bubbleSort(list);
        System.out.println("Коллекция после сортировки: "+list);




    }
}