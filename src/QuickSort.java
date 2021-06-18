/**
 * 快速排序
 * 找一个pivot基数，将数组按比pivot大和小分成两个数组，分治
 * @author Connor
 * @create 2021-06-18-21:39
 */
public class QuickSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] array) {
        System.out.println("Quick Sort");
        quickSort(array, 0, array.length-1);
        return array;
    }

    private void quickSort(int[] arr, int start, int end){
        if(start > end) return;
        int lIndex = start;
        int rIndex = end;
        int pivot = arr[start];
        while(lIndex < rIndex){
            while(arr[rIndex] >= pivot && lIndex < rIndex){
                rIndex--;
            }
            while(arr[lIndex] <= pivot && lIndex < rIndex){
                lIndex++;
            }
            if(lIndex < rIndex){
                int temp = arr[rIndex];
                arr[rIndex] = arr[lIndex];
                arr[lIndex] = temp;
            }
        }
        arr[start] = arr[lIndex];
        arr[lIndex] = pivot;
        quickSort(arr, start, lIndex-1);
        quickSort(arr, lIndex+1, end);
    }
}
