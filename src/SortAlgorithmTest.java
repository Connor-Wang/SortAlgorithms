import java.util.Arrays;

/**
 * @author Connor
 * @create 2021-06-18-19:44
 */
public class SortAlgorithmTest {

    private static void sortAlgorithmTest(SortAlgorithm sortAlgorithm){
        int[] Array = SortAlgorithm.getArray();
        System.out.println(Arrays.toString(Array));
        int[] sortedArray = sortAlgorithm.sort(Array);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static void main(String[] args) {
        sortAlgorithmTest(new BubbleSort());
        System.out.println();
        sortAlgorithmTest(new SelectionSort());
        System.out.println();
        sortAlgorithmTest(new InsertionSort());
        System.out.println();
        sortAlgorithmTest(new ShellSort());
        System.out.println();
        sortAlgorithmTest(new MergeSort());
        System.out.println();
        sortAlgorithmTest(new QuickSort());
        System.out.println();
        sortAlgorithmTest(new HeapSort());
        System.out.println();
        sortAlgorithmTest(new ContingSort());
        System.out.println();
        sortAlgorithmTest(new BucketSort());
        System.out.println();
        sortAlgorithmTest(new RadixSort());
    }
}
