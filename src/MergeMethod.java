import java.util.Scanner;
public class MergeMethod {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();

            int[] array = new int[n];

            for (int i = 0; i < n; i++) {

                array[i] = scanner.nextInt();
            }
            sort(array);
            for (int element : array) {
                System.out.print(element + " ");
            }

            scanner.close();
        }
    public static void sort(int[] x) {
        sort(x, 0, x.length - 1);
    }

    private static void sort(int[] x, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            sort(x, start, middle);
            sort(x, middle + 1, end);

            merge(x, start, end, middle);
        }
    }

    public static void merge(int[] x, int start, int end, int middle) {
        int leftSize = middle - start + 1;
        int rightSize = end - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; ++i) {
            leftArray[i] = x[start + i];
        }
        for (int j = 0; j < rightSize; ++j) {
            rightArray[j] = x[middle + 1 + j];
        }

        int i = 0, j = 0;

        int k = start;

        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                x[k] = leftArray[i];
                i++;
            } else {
                x[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            x[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            x[k] = rightArray[j];
            j++;
            k++;
        }
    }
}