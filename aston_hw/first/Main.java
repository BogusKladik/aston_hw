package aston_hw.first;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Примеры работы с моей коллекцией");
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(2);
        System.out.println(arrayList.toString());
        System.out.println("Удаляем элемент с индексом 1:");
        arrayList.remove(1);
        System.out.println(arrayList.toString());
        LinkedList<Integer> linkedList1 = new LinkedList<>(Arrays.asList(6, 8));
        System.out.println("Добавляем элементы 6 и 8:");
        arrayList.addAll(linkedList1);
        System.out.println(arrayList.toString());

        System.out.println("\nПеред сортировкой:");
        System.out.println(arrayList.toString());
        arrayList.bubbleSort();
        System.out.println("После сортировки:");
        System.out.println(arrayList.toString());

        LinkedList<Integer> linkedList2 = new LinkedList<>(Arrays.asList(5, 2, 3, 4, 1, 7));
        System.out.println("\nПеред сортировкой другой коллекции с помощью статического метода:");
        System.out.println(linkedList2.toString());
        MyArrayList.bubbleSort(linkedList2);
        System.out.println("После сортировки:");
        System.out.println(linkedList2.toString());
    }
}