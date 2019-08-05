import java.util.Arrays;

/**
 * Created by Dengxin on 2019/8/5 9:28 AM
 * 冒泡排序
 * 时间复杂度 O n^2
 * 是原地排序 空间复杂度 O 1
 * 是有序排序 经过排序后，相等元素之间原有的先后顺序不变
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {5,1,8,2,0,3,7,6,4,9};
//        int[] sortedArray = sort(array);
//        int[] sortedArray = optimizedSort(array);
//        System.out.println(Arrays.toString(sortedArray));
        long start = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            optimizedSort(array);
        }
        System.out.println("优化后耗时：" + (System.currentTimeMillis() - start));    //Result: 4-5
        start = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            sort(array);
        }
        System.out.println("优化前耗时：" + (System.currentTimeMillis() - start));    //Result: 9-10
        start = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            optimizedSort(array);
        }
        System.out.println("优化后耗时：" + (System.currentTimeMillis() - start));    //Result: 2
}

    private static int[] sort(int[] array) {
        int i = 0;
        int temp;
        for (;i<array.length;i++) {
            for (int j=0;j<array.length-i-1;j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    private static int[] optimizedSort(int[] array) {
        int n = array.length;
        //optimize1:when array.length<=1, return array immediately
        if (n<=1){
            return array;
        }

        for (int i=0; i<n; i++) {
            //optimize2:flag for non-swap
            boolean flag =true;
            for (int j=0; j<n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    //optimize3:swap 2 vars without using temp var
                    array[j] = array[j] + array[j+1];
                    array[j+1] = array[j] - array[j+1];
                    array[j] = array[j] - array[j+1];
                    flag = false;   //set flag to false when var swap
                }
            }
            if (flag) break;
        }
        return array;

    }
}
