import java.util.Arrays;

/**
 * Created by Dengxin on 2019/8/5 4:29 PM
 * 归并排序
 * 步骤 1.拆分 2.两两排序 3.合并(合并小值，再将剩余的子数组添加到合并后的数组尾部)
 * 时间复杂度 O logN*N
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5,1,8,2,0,3,7,6,4,9};
        System.out.println(Arrays.toString(sort(array)));
    }

    private static int[] sort(int[] arr) {
        int n= arr.length;
        if (n<=1){
            return arr;
        }
        int[] tempArr = Arrays.copyOf(arr,n);                       //复制临时数组，避免影响原数组
        int middle = (int)Math.floor(n/2);                          //获取中间位置值，以便数组拆分
        int[] left = Arrays.copyOfRange(tempArr,0,middle);      //将原数组拆分为两个子数组
        int[] right = Arrays.copyOfRange(tempArr,middle,n);
        return merge(sort(left),sort(right));                       //在子数组完成排序后进行合并
    }

    private static int[] merge(int[] left,int[] right) {
        int[] result = new int[left.length+right.length];           //创建结果数组
        int i=0;                                                    //结果数组从第一个元素开始接收排序后的值
        while(left.length >0 && right.length>0) {
            if (left[0] <= right[0]){
                result[i++]=left[0];
                left = Arrays.copyOfRange(left,1,left.length);      //如果左半数组的首个元素小于右半数组的首个元素，将左半数组的元素赋值给结果数组，并更新左半数组
            } else {                                                        //反之同理
                result[i++]=right[0];
                right = Arrays.copyOfRange(right,1,right.length);
            }
        }
        while(left.length>0){       //如果左半数组尚存元素(已排序)，则顺序直接添加到result现有元素之后
            result[i++]=left[0];
            left = Arrays.copyOfRange(left,1,left.length);
        }
        while (right.length>0){     //右半数组同理
            result[i++]=right[0];
            right = Arrays.copyOfRange(right,1,right.length);
        }
        return result;
    }
}
