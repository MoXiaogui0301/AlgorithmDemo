package sort;

import java.util.Arrays;

/**
 * Created by Dengxin on 2019/8/5 11:30 AM
 * 插入法排序
 * 步骤：1.分区 2.取数 3.比较 4.定位(插入)
 * 时间复杂度 O n^2
 * 是原地排序法 空间复杂度 O 1
 * 是有序排序法 将后面出现的元素插入到前面出现元素的后面，这样就可以保持原有的前后顺序不变
 *
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {5,1,8,2,0,3,7,6,4,9};
        System.out.println(Arrays.toString(sort(array)));
    }

    private static int[] sort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return arr;
        }
        for (int i = 1; i<n;i++){
            int value = arr[i];
            int j=i-1;
            //查找插入的位置
            for (; j>=0; j--){
                if (arr[j] > value) {
                    arr[j+1] = arr[j];  //如果有序区的当前元素大于当前从无序区取出的元素，则将有序区元素后移一位
                }else {
                    break;              //如果有序区的当前元素不大于当前从无序区取出的元素，则应该将从无序区取出的元素插入到有序区当前元素之后
                }
            }
            arr[j+1] = value;           //插入数据
        }
        return arr;
    }
}
