package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * create by tgss on 2021/2/5 15:56
 **/
public class QuickSort {

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
//        Arrays.stream(array).forEach(e -> System.out.print(e + ";"));
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(array, start, end);

        sort(array, start, pivot -1);
        sort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int i = start, pivot = array[end];
        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }

        // 把选中的下标和最后一个i（这个值比选中的下标值大）交换，这样下标的左边比他小，右边比他大
        swap(array, i, end);
        return i;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
