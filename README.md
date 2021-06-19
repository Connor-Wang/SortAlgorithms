# SortAlgorithms 排序算法
- 排序算法
    - 冒泡排序
        - 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
        - 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
        - 针对所有的元素重复以上的步骤，除了最后一个；
        - 重复步骤1~3，直到排序完成。

        ```java
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
        ```

    - 选择排序
        - 初始状态：无序区为R[1..n]，有序区为空；
        - 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
        - n-1趟结束，数组有序化了。

        ```java
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
        ```

    - 插入排序
        - 从第一个元素开始，该元素可以认为已经被排序；
        - 取出下一个元素，在已经排序的元素序列中从后向前扫描；
        - 如果该元素（已排序）大于新元素，将该元素移到下一位置；
        - 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
        - 将新元素插入到该位置后；
        - 重复步骤2~5。

        ```java
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
        ```

    - 希尔排序
        - 缩小增量排序
        - 增量从一半数组长度 n/2 一直减半直到 1
        - 根据增量将数组分组，每组进行插入排序

        ```java
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
        ```

    - 归并排序
        - 把长度为n的输入序列分成两个长度为n/2的子序列；
        - 对这两个子序列分别采用归并排序；
        - 将两个排序好的子序列合并成一个最终的排序序列。

        ```java
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
        ```

    - 快速排序
        - 从数列中挑出一个元素，称为 “基准”（pivot）；
        - 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
        - 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

        ```java
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
        ```

    - 堆排序
        - 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
        - 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
        - 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。

        ```java
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
        ```

    - 计数排序
        - 找出待排序的数组中最大和最小的元素；
        - 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
        - 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
        - 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。

        ```java
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
        ```

    - 桶排序
        - 设置一个定量的数组当作空桶；
        - 遍历输入数据，并且把数据一个一个放到对应的桶里去；
        - 对每个不是空的桶进行排序；
        - 从不是空的桶里把排好序的数据拼接起来。

        ```java
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
        ```

    - 基数排序
        - 取得数组中的最大数，并取得位数；
        - arr为原始数组，从最低位开始取每个位组成radix数组；
        - 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
    - 复杂度比较
    - ![image](https://github.com/Connor-Wang/SortAlgorithms/blob/master/Complex.png)
