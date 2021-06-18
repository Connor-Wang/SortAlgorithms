/**
 * 堆排序
 * 维护一个大顶堆，每次将堆顶的最大元素取出，再重新构成大顶堆
 * @author Connor
 * @create 2021-06-18-22:32
 */
public class HeapSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] array) {
        System.out.println("Heap Sort");
        for(int i = array.length-1; i >= 1; i--){
            adjustMaxHeap(array, i);
        }
        return array;
    }

    private void adjustMaxHeap(int[] arr, int length){
        for(int i = (length+1)/2-1; i >= 0; i--){
            if(arr[i] < arr[i*2+1]){
                swap(arr, i, i*2+1);
            }
            if(i*2+2 <= length && arr[i] < arr[i*2+2]){
                swap(arr, i, i*2+2);
            }
        }
        swap(arr, 0, length);
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
