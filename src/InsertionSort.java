/**
 * 插入排序
 * 扫描无序区元素，按序插入到有序区
 * @author Connor
 * @create 2021-06-18-19:39
 */
public class InsertionSort implements SortAlgorithm{

    @Override
    public int[] sort(int[] array) {
        System.out.println("Insertion Sort");
        int n = array.length;
        for(int i = 1; i < n; i++){
            int index = i - 1;
            int current = array[i];
            while(index >= 0 && array[index] > current){
                array[index+1] = array[index];
                index--;
            }
            array[index+1] = current;
        }
        return array;
    }
}
