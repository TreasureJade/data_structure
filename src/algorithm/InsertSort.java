package algorithm;

/**
 * 插入排序算法
 */
public class InsertSort {

    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 插入的数
            int insertVal = arr[i];
            // 插入为止
            int index = i - 1;
            // 插入的数比被插入的数小
            while (index > 0 && insertVal < arr[index]) {
                // arr[index] 左移
                arr[index + 1] = arr[index];
                index--;
            }
            // 插入的数值放在合适的为止
            arr[index + 1] = insertVal;
        }
        return arr;
    }

}
