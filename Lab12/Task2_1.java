package Lab12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Task2_1 {
    /*
    1. У колі стоять N людей, пронумерованих від 1 до N. При веденні програм повинна використовувати клас ArrayList,
    а друга - LinkedList. Яка з двох програм працює швидше? Чому?
    */
    public static void main(String[] args) {
        Integer[] people = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 500;
        ArrayList<Integer> ArrLst = new ArrayList<>(Arrays.asList(people));
        long m1 = System.currentTimeMillis();
        for (int j=0;j<n;j++) {
            for (Integer integer : ArrLst) System.out.print(integer);
        }
        System.out.println();
        double time1 = (double) (System.currentTimeMillis() - m1)/n;

        // LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(people));
        long m2 = System.currentTimeMillis();
        for (int j=0;j<n;j++) {
            for (Integer integer : linkedList) System.out.print(integer);
        }
        System.out.println();
        double time2 = (double) (System.currentTimeMillis() - m2)/n;

        // Compare time
        System.out.println("ArrayList: "+ time1 +"\nLinkedList: "+time2);
        if (time1 > time2)
            System.out.println("LinkedList is faster!");
        else if (time2 > time1)
            System.out.println("ArrayList is faster!");

        /*
        * For LinkedList<E>
        get(int index) is O(n) (with n/4 steps on average), but O(1) when index = 0 or index = list.size() - 1.
        * One of the main benefits of LinkedList<E>
        add(int index, E element) is O(n) (with n/4 steps on average), but O(1)
        * when index = 0 or index = list.size() - 1. One of the main benefits of LinkedList<E>
        remove(int index) is O(n) (with n/4 steps on average), but O(1) when index = 0 or index = list.size() - 1.
        * One of the main benefits of LinkedList<E>
           ListIterator.add(E element) is O(1). One of the main benefits of LinkedList<E>

        * For ArrayList<E>
        get(int index) is O(1). Main benefit of ArrayList<E>
        add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
        add(int index, E element) is O(n) (with n/2 steps on average)
        remove(int index) is O(n) (with n/2 steps on average)
        Iterator.remove() is O(n) (with n/2 steps on average)
        ListIterator.add(E element) is O(n) (with n/2 steps on average)
        *
        * ArrayList with ArrayDeque are preferable in many more use-cases than LinkedList
        * */
    }
}
