import java.util.Arrays;

/**
 * @author Connor
 * @create 2021-06-18-23:45
 */
public class RadixSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] array) {
        System.out.println("Radix Sort");
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[0]);
        }

        int[] count = new int[array.length];
        int[] bucket = new int[array.length];

        //k表示第几位，1代表个位，2代表十位，3代表百位
        for(int k = 1; k <= max; k++) {
            Arrays.fill(count, 0);

            //分别统计第k位是0,1,2,3,4,5,6,7,8,9的数量
            for(int i = 0; i < array.length; i++) {
                count[getFigure(array[i],k)]++;
            }

            //利用count[i]来确定放置数据的位置
            for(int i = 1; i < array.length; i++) {
                count[i] = count[i] + count[i-1];
            }
            //执行完此循环之后的count[i]就是第i个桶右边界的位置

            //利用循环把数据装入各个桶中，注意是从后往前装
            //这里是重点，一定要仔细理解
            for(int i = array.length - 1; i >= 0; i--) {
                int j = getFigure(array[i],k);
                bucket[count[j]-1] = array[i];
                count[j]--;
            }

            //将桶中的数据取出来，赋值给arr
            for(int i = 0, j = 0; i < array.length; i++, j++) {
                array[i] = bucket[j];
            }
        }
        return array;
    }

    // 计算数 i 的第 k 位
    private int getFigure(int i,int k) {
        int[] a = {1,10,100};
        return (i / a[k-1]) % 10;
    }
}
