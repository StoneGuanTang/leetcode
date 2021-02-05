package sort;

import java.util.Random;

/**
 * 归并排序
 * create by tgss on 2021/2/5 10:02
 **/
public class MergeSort {

    public static void main(String[] args) {
        int size = 100000000;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt();
        }

//        int[] array = {9, 3, 1, 8, 4, 2, 10};

        long start = System.currentTimeMillis();
        sort(array);
        System.out.println("cost：" + (System.currentTimeMillis() - start));
        //Arrays.stream(array).forEach(e -> System.out.print(e + ";"));
    }

    public static void sort(int[] array) {
        int end = array.length - 1;
        int start = 0;
        sort(array, start, end);
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;

        // 分前面
        sort(array, start, mid);
        // 分后面
        sort(array, mid + 1, end);
        // 合并
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        // i, j分别表示的是两个数组第一个元素下标
        int i = start, j = mid + 1;
        int[] tmp = new int[end - start + 1];
        int k = 0;

        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        // 判断哪个数组还有剩余
        int s = i, e = mid;

        // 右边数组还有剩余
        if (j <= end) {
            s = j;
            e = end;
        }

        while (s <= e) {
            tmp[k++] = array[s++];
        }

        int length = tmp.length;
        System.arraycopy(tmp, 0, array, start, length);
    }

    /**
     * 哨兵模式归并
     */
    private static void mergeBySentry(int[] array, int start, int mid, int end) {
        int[] left = new int[mid - start + 2];
        System.arraycopy(array, start, left, 0, mid - start + 2);
        left[mid - start + 1] = Integer.MAX_VALUE;

        int[] right = new int[end - mid + 1];
        System.arraycopy(array, mid + 1, right, 0, end - mid);
        right[end - mid] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = start;
        while (k <= end) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
    }

}
