package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int [] array = { 42,43,24, 54,3,5,56,4 ,65,34};
        MergeSort(array);
        for(int i: array){
            System.out.print(i + " ");
        }
    }
    private static void MergeSort(int[] array){
        if (array.length <=1){
            return;
        }
        int length = array.length;
        int middle = length/2;

        int[] leftarray;
        int[] rightarray;

        leftarray = new int[middle];
        rightarray = new int[length -middle];
        int j = 0;
        for (int i = 0; i<= length-1; i++){
            if(i<= middle-1){
                leftarray[i] = array[i];
            }
            else{
                rightarray[j] = array[i];
                j++;
            }
        }
        MergeSort(leftarray);
        MergeSort(rightarray);
        merge(leftarray, rightarray, array);
        /*
        2 Method MergeSort Recursive bên trên ( right and left ) cho đến khi nó chạm base case nó sẽ không gọi thêm method nữa
        và cùng lúc đó Method merge cùng cấp với 2 Method recursive đã chạm tới base case kia sẽ bắt đầu đi vào hoạt động
        sau đó khi Method Merge này hoàn thành công việc thì cx là lúc Method Mergesort chứa nó hoàn thành việc sort array nó pass in
        vào, => Method Merge cùng cấp đi vào hoạt động cho đến khi Method MergeSort gốc hoàn thành công việc 
         */

    }
    private static void merge(int[] leftarray, int[] rightarray, int[] array){
        int i = 0, j = 0, k= 0;
        while(i<= leftarray.length-1 && j <= rightarray.length-1){
            if(leftarray[i] < rightarray[j]){
                array[k] = leftarray[i];
                k++;
                i++;
            }
            else {
                array[k] = rightarray[j];
                k++;
                j++;
            }
        }
        while (i <= leftarray.length-1){
            array[k] = leftarray[i];
            k++;
            i++;
        }
        while (j <= rightarray.length -1){
            array [k] = rightarray[j];
            k++;
            j++;
        }
    }
}