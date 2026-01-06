class SearchingBase {
    int search(int[] arr, int target) {
        return -1;
    }
}

class LinearSearch extends SearchingBase {
    int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}

class BinarySearchIterative extends SearchingBase {
    int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;
            else if (target > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}

public class Searching {
    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8, 10, 12};

        SearchingBase s1 = new LinearSearch();
        System.out.println(s1.search(arr, 8));

        SearchingBase s2 = new BinarySearchIterative();
        System.out.println(s2.search(arr, 8));
    }
}
