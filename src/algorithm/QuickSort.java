package algorithm;

/**
 * 快速排序
 */
public class QuickSort {

    public static int[] quickSort(int[] arr, int low, int high) {
        // 从前向后比较的索引
        int start = low;
        // 从后向前比较的索引
        int end = high;
        // 基准值
        int key = arr[low];
        while (end > start) {
            // 从前向后比较
            while (end > start && arr[end] >= key) {
                end--;
            }
            // 若没有比基准值小的，则比较下一个，直到有比基准值小的，则交换位置，然后从前向后比较
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            // 从前向后比较
            while (end > start && arr[start] > key) {
                start++;
            }
            // 若没有比基准值大的，则比较下一个，直到有比基准值大的，则交换位置，然后从前向后比较
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            // 此时第1次循环比较结束，基准值的位置已经确定。左边的值都比基准值小
            // 右边的值都比基准值大，但两边的顺序还有可能不一样，接着进行下面的递归调用
        }
        // 递归左边序列，从第1个索引位置到 基准值索引-1
        if (start < low) {
            quickSort(arr, low, start - 1);
        }
        if (end < high) {
            quickSort(arr, end + 1, high);
        }
        return arr;
    }

}
