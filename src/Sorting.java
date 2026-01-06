import java.util.Arrays;

abstract class SortingBase {
    abstract void sort(int[] arr);

    void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}

class BubbleSort extends SortingBase {
    void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
}

class SelectionSort extends SortingBase {
    void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int t = arr[i];
            arr[i] = arr[min];
            arr[min] = t;
        }
    }
}

class InsertionSort extends SortingBase {
    void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

class MergeSort extends SortingBase {
    void sort(int[] arr) {
        divide(arr, 0, arr.length - 1);
    }

    void divide(int[] arr, int si, int ei) {
        if (si >= ei)
            return;
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }

    void conquer(int[] arr, int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1];
        int i = si, j = mid + 1, k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j])
                merged[k++] = arr[i++];
            else
                merged[k++] = arr[j++];
        }

        while (i <= mid)
            merged[k++] = arr[i++];

        while (j <= ei)
            merged[k++] = arr[j++];

        for (int x = 0, y = si; x < merged.length; x++, y++)
            arr[y] = merged[x];
    }
}

class QuickSort extends SortingBase {
    void sort(int[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    void quick(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quick(arr, low, p - 1);
            quick(arr, p + 1, high);
        }
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

public class Sorting {
    public static void main(String[] args) {

        int[] a1 = {5, 3, 4, 1};
        int[] a2 = a1.clone();
        int[] a3 = a1.clone();
        int[] a4 = a1.clone();
        int[] a5 = a1.clone();

        SortingBase s1 = new BubbleSort();
        s1.sort(a1);
        s1.print(a1);

        SortingBase s2 = new SelectionSort();
        s2.sort(a2);
        s2.print(a2);

        SortingBase s3 = new InsertionSort();
        s3.sort(a3);
        s3.print(a3);

        SortingBase s4 = new MergeSort();
        s4.sort(a4);
        s4.print(a4);

        SortingBase s5 = new QuickSort();
        s5.sort(a5);
        s5.print(a5);
    }
}
