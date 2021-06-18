/**
 * 冒泡排序
 * 相邻的两位比较并交换，每次将最大的元素交换到最后
 * @author Connor
 * @create 2021-06-18-19:21
 */
public class BubbleSort implements SortAlgorithm{

    @Override
    public int[] sort(int[] array) {
        System.out.println("Bubble Sort");
        int n = array.length;
        for(int i = 0; i < n; i++) {
            for (int j = 1; j < n-i; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

}
