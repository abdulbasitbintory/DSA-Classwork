class SearchingRecursionBase {
    int search(int[] arr, int target) {
        return -1;
    }
}

class LinearSearchRecursive extends SearchingRecursionBase {
    int search(int[] arr, int target) {
        return helper(arr, target, 0);
    }

    int helper(int[] arr, int target, int index) {
        if (index == arr.length)
            return -1;
        if (arr[index] == target)
            return index;
        return helper(arr, target, index + 1);
    }
}

class BinarySearchRecursive extends SearchingRecursionBase {
    int search(int[] arr, int target) {
        return helper(arr, 0, arr.length - 1, target);
    }

    int helper(int[] arr, int low, int high, int target) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == target)
            return mid;

        if (target < arr[mid])
            return helper(arr, low, mid - 1, target);

        return helper(arr, mid + 1, high, target);
    }
}

public class SearchingRecursion {
    public static void main(String[] args) {

        int[] arr = {2, 4, 6, 8, 10, 12};

        SearchingRecursionBase s1 = new LinearSearchRecursive();
        System.out.println(s1.search(arr, 10));

        SearchingRecursionBase s2 = new BinarySearchRecursive();
        System.out.println(s2.search(arr, 10));
    }
}
