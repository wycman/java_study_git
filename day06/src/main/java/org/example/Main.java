package org.example;

public class Main {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] array2 = CopyOfRange(array, 2, 8);
        print_array(array2);

    }
    public static void print_array(int[] array){
        System.out.print('[');
        for (int i = 0; i < array.length; i++){
            if (i < array.length - 1)
                System.out.print(array[i] + ", ");
            else
                System.out.print(array[i] + "]");
        }
    }
    public static void compare(int a, int b) {
        System.out.println(a == b);
    }
    public static void compare(short a, short b) {
        System.out.println(a == b);
    }
    public static void compare(double a, double b) {
        System.out.println(a == b);
    }

    public static void look_up_array(int[] array) {
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static boolean is_exist_for_array(int element, int[] array) {
        int i = 0;
        for (; i < array.length; i++) {
            if(array[i] == element){
                return true;
            }
        }
        return false;
    }

    public static int[] CopyOfRange(int[] array, int from, int to){
        int[] new_array = new int[to - from + 1];
        for(int i = from, k = 0;i <= to;i++, k++){
            new_array[k] = array[i];
        }
        return new_array;
    }

}