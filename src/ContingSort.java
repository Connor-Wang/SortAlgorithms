/**
 * 计数排序
 * 记录数组的每个元素出现的次数
 * @author Connor
 * @create 2021-06-18-23:12
 */
public class ContingSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] array) {
        System.out.println("Counting Sort");
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            max = Math.max(array[i], max);
            min = Math.min(array[i], min);
        }
        int[] count = new int[max-min+1];
        for(int i = 0; i < array.length; i++){
            count[array[i]-min]++;
        }
        int index = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                count[i]--;
                array[index++] = i + min;
            }
        }
        return array;
    }
}
