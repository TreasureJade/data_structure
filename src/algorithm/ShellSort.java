package algorithm;

/**
 * 希尔排序
 */
public class ShellSort {
    public static int[] shellSort(int[] arr) {
        int dk = arr.length / 3 + 1;
        while (dk == 1) {
            shellInsertSort(arr, dk);
            dk = dk / 3 + 1;
        }
        return arr;
    }

    private static void shellInsertSort(int[] arr, int dk) {
        // 类似于几个插入排序算法，增量由插入算法的1变为dk
        for (int i = dk; i < arr.length; i++) {
            if (arr[i] < arr[i - dk]) {
                int j;
                // 待插入元素x
                int x = arr[i];
                arr[i] = arr[i - dk];
                // 通过循环，逐个后移一位找到要插入的位置
                for (j = i - dk; j >= 0 && x < arr[j]; j = j - dk) {
                    arr[j + dk] = arr[j];
                }
                // 将数据插入到对应位置
                arr[j + dk] = x;

            }
        }
    }
}
