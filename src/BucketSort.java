import java.util.*;

/**
 * 桶排序
 * 将数据分别存在多个桶中，每个桶进行插入排序
 * @author Connor
 * @create 2021-06-18-23:24
 */
public class BucketSort implements SortAlgorithm{
    @Override
    public int[] sort(int[] array) {
        System.out.println("Bucket Sort");
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            max = Math.max(array[i], max);
            min = Math.min(array[i], min);
        }
        int bucketSize = 5; // 可以通过参数设置
        List<List<Integer>> bucket = new ArrayList<>();
        for(int i = 0; i < bucketSize; i++){
            bucket.add(new LinkedList<>());
        }
        int index = 0;
        int gap = (int) Math.ceil((max - min) / (bucketSize-1));
        for(int i = 0; i < array.length; i++){
            index =(array[i] - min) / gap;
            bucket.get(index).add(array[i]);
        }
        index = 0;
        for(int i = 0; i < bucketSize; i++){
            if(bucket.get(i).size() > 1){
                Collections.sort(bucket.get(i)); // 可以手写其他排序，这里省略 直接调库
            }
            for (Integer integer : bucket.get(i)) {
                array[index++] = integer;
            }
        }
        return array;
    }
}
