/**
 * 希尔排序
 * 缩小增量排序
 * 每个增量将数组分组，每组进行插入排序
 * @author Connor
 * @create 2021-06-18-20:05
 */
public class ShellSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] array) {
        System.out.println("Shell Sort");
        int n = array.length;
        for(int gap = n/2; gap > 0; gap /= 2){
            for(int i = gap; i < n; i++){
                int j = i;
                int currrnt = array[i];
                while(j - gap >= 0 && array[j - gap] > currrnt) {
                    array[j] = array[j - gap];
                    j = j - gap;
                }
                array[j] = currrnt;
            }
        }
        return array;
    }
}
