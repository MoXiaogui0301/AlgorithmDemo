package sort;

import java.util.Arrays;

/**
 * Created by Dengxin on 2019/8/7 4:01 PM
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5,1,8,2,0,3,7,6,4,9};
        System.out.println(Arrays.toString(sort(array,0,array.length-1)));
    }

    private static int[] sort(int[] arr, int left, int right) {
        int n = arr.length;
        if (n <= 1)
            return arr;
        if (left < right) {
            int index = partition(arr,left,right);
            sort(arr,0,index-1);
            sort(arr, index+1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = right;
        int index = left;
        for (int i=index;i<right;i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,index,pivot);
        return index;
    }

    private static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
