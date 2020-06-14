package learn.yyc.test.demo.sort;

import java.util.Arrays;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/6/4 0004 上午 9:49
 */
public class Test {

    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 2, 8, 3, 6, 5, 11, 9};

        HeapSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }


    //插入排序
    //最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
    private static int[] sort_insert(int[] array) {
        int length = array.length;
        int temp;
        for (int i = 1; i < length; i++) {
            //待排元素小于有序序列的最后一个元素时，向前插入
            if (array[i] < array[i - 1]) {
                temp = array[i];
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && array[j - 1] > temp) {
                        array[j] = array[j - 1];
                    } else {
                        array[j] = temp;
                        break;
                    }
                }
            }
        }
        return array;
    }


    //希尔排序
    //最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　
    private static int[] sort_shell(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }


    //归并算法
    //最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
    private static int[] sort_merge(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] intLeft = Arrays.copyOfRange(array, 0, mid);
        int[] intRight = Arrays.copyOfRange(array, mid, array.length);
        return sort_merge2(sort_merge(intLeft), sort_merge(intRight));
    }

    //归并算法
    private static int[] sort_merge2(int[] arrayLeft, int[] arrayRight) {
        int[] merageArray = new int[arrayLeft.length + arrayRight.length];
        for (int i = 0, l = 0, r = 0; i < merageArray.length; i++) {
            if (l >= arrayLeft.length) {
                merageArray[i] = arrayRight[r++];
            } else if (r >= arrayRight.length) {
                merageArray[i] = arrayLeft[l++];
            } else if (arrayLeft[l] > arrayRight[r]) {
                merageArray[i] = arrayRight[r++];
            } else {
                merageArray[i] = arrayLeft[l++];
            }
        }
        return merageArray;
    }


    /**
     * 快速排序方法
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static void quickSort(int[] array, int start, int end) {

        if (start < end) {
            int index = partition(array, start, end);
            quickSort(array, start, index - 1);
            quickSort(array, index + 1, end);
        }
    }

    /**
     * 快速排序算法——partition
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] array, int start, int end) {
        int s = array[start];
        int i = start;
        int j = end;

        while (i < j) {
            // 从右往左找第一个小于基数的数
            while (array[j] >= s && i < j) {
                j--;
            }
            // 从左往右找第一个大于基数的数
            while (array[i] <= s && i < j) {
                i++;
            }
            // 找到后交换两个数
            swap(array, i, j);


        }
// 使划分好的数分布在基数两侧
        swap(array, start, i);
        return i;

    }

    /**
     * 交换数组内两个元素
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     * 堆排序算法
     * 最佳情况：T(n) = O(nlogn) 最差情况：T(n) = O(nlogn) 平均情况：T(n) = O(nlogn)
     * @param array
     * @return
     */

    static int len;
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1) return array;
        //1.构建一个最大堆
        buildMaxHeap(array);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            swap(array, 0, len - 1);
            len--;
            adjustHeap(array, 0);
        }
        return array;
    }
    /**
     * 建立最大堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        //从最后一个非叶子节点开始向上构造最大堆
        for (int i = (len/2 - 1); i >= 0; i--) { //感谢 @让我发会呆 网友的提醒，此处应该为 i = (len/2 - 1)
            adjustHeap(array, i);
        }
    }
    /**
     * 调整使之成为最大堆
     *
     * @param array
     * @param i
     */
    public static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        //如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (i * 2 < len && array[i * 2] > array[maxIndex])
            maxIndex = i * 2;
        //如果有右子树，且右子树大于父节点，则将最大指针指向右子树
        if (i * 2 + 1 < len && array[i * 2 + 1] > array[maxIndex])
            maxIndex = i * 2 + 1;
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }
    }



}
