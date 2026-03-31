public class HeapSort {
    // Main HeapSort method
    public static void HeapSort(String[] arr, int order) {
        int n = arr.length;

        // Build heap
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i, order);
        }

        // Extract 
        for (int i = n - 1; i > 0; i--) {
            String temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0, order);
        }
    }
    // Heapify method
    static void heapify(String[] arr, int n, int i, int order) {
        int extreme = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        // Ascending for max heap
        if (order == 0) {
            if (l < n && arr[l].compareTo(arr[extreme]) > 0) extreme = l;
            if (r < n && arr[r].compareTo(arr[extreme]) > 0) extreme = r;
        }
        // Descending for min heap
        else {
            if (l < n && arr[l].compareTo(arr[extreme]) < 0) extreme = l;
            if (r < n && arr[r].compareTo(arr[extreme]) < 0) extreme = r;
        }

        // swap if necessary
        if (extreme != i) {
            String temp = arr[i];
            arr[i] = arr[extreme];
            arr[extreme] = temp;

            heapify(arr, n, extreme, order);
        }
    }
    // Quick test
    public static void main(String[] args) {
        String[] arr = {"Banana", "Apple", "Carrot", "Eggplant","Date"};

        HeapSort(arr, 0); // ascending
        for (String s : arr) System.out.print(s + " ");

        System.out.println();

        HeapSort(arr, 1); // descending
        for (String s : arr) System.out.print(s + " ");
    }
}