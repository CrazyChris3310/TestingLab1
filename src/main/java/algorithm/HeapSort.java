package algorithm;

public class HeapSort {

    private static void heapify(int[] array, int len, int root) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int minimal = root;
        if (left < len && array[left] > array[minimal]) {
            minimal = left;
        }
        if (right < len && array[right] > array[minimal]) {
            minimal = right;
        }
        if (minimal != root) {
            int temp = array[root];
            array[root] = array[minimal];
            array[minimal] = temp;
            heapify(array, len, minimal);
        }
    }

    public static int[] heapSort(int[] src) {
        int[] array = new int[src.length];
        System.arraycopy(src, 0, array, 0, src.length);

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
        return array;
    }
}
