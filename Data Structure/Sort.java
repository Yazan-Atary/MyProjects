import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        int[] sizes = {10000, 100000, 1000000};

        for (int size : sizes) {
            System.out.println("\nTesting arrays of size: " + size);

            int[] sortedArray = generateSortedArray(size);
            int[] reversedArray = generateReversedArray(size);
            int[] randomArray = generateRandomArray(size);
            int[] partiallySortedArray = generatePartiallySortedArray(size);

            System.out.println("QuickSort Results:");
            testSortingAlgorithm("QuickSort", "Sorted Array", sortedArray);
            testSortingAlgorithm("QuickSort", "Reversed Array", reversedArray);
            testSortingAlgorithm("QuickSort", "Random Array", randomArray);
            testSortingAlgorithm("QuickSort", "Partially Sorted Array", partiallySortedArray);

            System.out.println("SelectionSort Results:");
            testSortingAlgorithm("SelectionSort", "Sorted Array", sortedArray);
            testSortingAlgorithm("SelectionSort", "Reversed Array", reversedArray);
            testSortingAlgorithm("SelectionSort", "Random Array", randomArray);
            testSortingAlgorithm("SelectionSort", "Partially Sorted Array", partiallySortedArray);
        }
    }

    public static void testSortingAlgorithm(String algorithm, String arrayType, int[] array) {
        int[] arrayCopy = array.clone();
        long startTime = System.currentTimeMillis();

        switch (algorithm) {
            case "QuickSort":
                QuickSort.quickSort(arrayCopy, 0, arrayCopy.length - 1);
                break;
            case "SelectionSort":
                SelectionSort.selectionSort(arrayCopy);
                break;
        }

        long endTime = System.currentTimeMillis();
        System.out.println(arrayType + " sorted using " + algorithm + " in: " + (endTime - startTime) + " ms");
    }

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] generateReversedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size) + 1;
        }
        return array;
    }

    public static int[] generatePartiallySortedArray(int size) {
        int[] array = new int[size];
        int partSortedSize = size / 2;
        for (int i = 0; i < partSortedSize; i++) {
            array[i] = i + 1;
        }
        Random random = new Random();
        for (int i = partSortedSize; i < size; i++) {
            array[i] = random.nextInt(size) + 1;
        }
        return array;
    }
}

class QuickSort {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = medianOfThreePartition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int medianOfThreePartition(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;
        if (array[mid] < array[low]) swap(array, mid, low);
        if (array[high] < array[low]) swap(array, high, low);
        if (array[high] < array[mid]) swap(array, high, mid);
        swap(array, mid, high - 1);
        return partition(array, low, high - 1);
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

class SelectionSort {
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            swap(array, i, minIdx);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}