package sort;

import java.util.Arrays;

/**
 * Created by Dengxin on 2019/8/5 2:55 PM
 * 选择法排序
 * 步骤 1.分区 2.比较 3.选数 4.添加
 * 时间复杂度 O^2
 * 空间复杂度 O 1 是原地排序
 * 不稳定排序 相同元素多次排序可能在不同位置
 *
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {5,1,8,2,0,3,7,6,4,9};
        System.out.println(Arrays.toString(sort(array)));
    }

    private static int[] sort(int[] arr) {
        int n = arr.length;
        if (n<=1) {
            return arr;
        }
        for (int i=0;i<n;i++) {
            int min = i;                //记录当前最小值坐标
            for (int j=i+1;j<n;j++) {
                if (arr[j]<arr[min]) {
                    min = j;            //如果当前元素小于最小值，更新最小值坐标
                }
            }
            if (min!=i){                //如果最小值坐标发生了变化，交换未排序区最小值元素到排序区的末尾
                swap(arr,min,i);
            }
        }
        return arr;
    }

    private static void swap(int[] arr,int min,int i) {
        arr[min] = arr[min] + arr[i];
        arr[i] = arr[min] - arr[i];
        arr[min] = arr[min] - arr[i];
    }
}
