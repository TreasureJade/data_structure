package algorithm;

/**
 * 归并排序
 */
public class MergeSort {

    public static int[] mergeSort(int[] data) {
        sout(data, 0, data.length - 1);
        return data;
    }

    // 对左右两边进行递归
    private static void sout(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        // 找出中间序列
        int center = (left + right) / 2;
        // 左边进行递归
        sout(data, left, center);
        // 右边进行递归
        sout(data, center + 1, right);
        // 合并两个数组
        merge(data, left, center, right);
    }

    /**
     * 将两个数组进行合并，两个数组合并前是有序数组，在归并后依然是有序数组
     *
     * @param data
     * @param left
     * @param center
     * @param right
     */
    private static void merge(int[] data, int left, int center, int right) {
        int[] tmpArr = new int[data.length];
        // 右边数组第一个元素的索引
        int mid = center + 1;
        // 记录临时数组的索引
        int third = left;
        // 缓存左边数组的第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {

            if (data[left] < data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }

        }

        // 将剩余部分依次放入临时数组（实际上两个while只会执行其中一个）中
        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }
        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
        // 将临时数组中的内容复制到原数组中
        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }

    }

}
