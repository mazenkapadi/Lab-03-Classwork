import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Get the size of the array and the values
        System.out.print("Enter the size of the array: ");
        int size = scnr.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the values of the array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scnr.nextInt();
        }

        // Sort the array
        sortArray(array);

        // Get the value to search for
        System.out.print("Enter the value to search for: ");
        int value = scnr.nextInt();

        System.out.println("Sorted Array: ");
        for (int j = 0; j < size; j++) {
            System.out.println(array[j]);
        }

        // Search for the value using binary search
        int binaryIndex = binarySearch(array, value);
        if (binaryIndex != -1) {
            System.out.println("Binary search: Value found at index " + binaryIndex);
        } else {
            System.out.println("Binary search: Value not found");
        }

        // Search for the value using linear search
        int linearIndex = linearSearch(array, value);
        if (linearIndex != -1) {
            System.out.println("Linear search: Value found at index " + linearIndex);
        } else {
            System.out.println("Linear search: Value not found");
        }
    }

    // Sorts the array using bubble sort
    public static void sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Searches for the value using binary search
    public static int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] < value) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    // Searches for the value using linear search
    public static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
