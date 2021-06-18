/**
 * 归并排序
 * 将数组分成两个部分，分别排序，再进行合并
 * @author Connor
 * @create 2021-06-18-20:39
 */
public class MergeSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] array) {
        System.out.println("Merge Sort");
        mergeSort(array, 0, array.length-1);
        return array;
    }

    private void mergeSort(int[] arr, int start, int end){
        if(start == end) return;
        int mid = start + (end-start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        int[] temp = new int[end-start+1];
        int s1 = start, s2 = mid+1;
        int index = 0;
        while(index <= (end-start)){
            if(s1 > mid){
                temp[index++] = arr[s2++];
            } else if(s2 > end){
                temp[index++] = arr[s1++];
            } else if(arr[s1] < arr[s2]) {
                temp[index++] = arr[s1++];
            } else if(arr[s1] >= arr[s2]){
                temp[index++] = arr[s2++];
            }
        }
        for(int i = start; i <= end; i++){
            arr[i] = temp[i-start];
        }
    }
}
