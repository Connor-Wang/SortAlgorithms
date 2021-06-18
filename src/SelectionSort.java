/**
 * 选择排序
 * 每次从无序区选择一个最小的元素进入有序区
 * @author Connor
 * @create 2021-06-18-19:31
 */
public class SelectionSort implements SortAlgorithm{

    @Override
    public int[] sort(int[] array) {
        System.out.println("Selection Sort");
        int n = array.length;
        int minIndex = 0;
        for(int i = 0; i < n; i++) { // 0-i 是有序区
            minIndex = i;
            for (int j = i+1; j < n; j++) { // 找到无序区中最小的数
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

}
