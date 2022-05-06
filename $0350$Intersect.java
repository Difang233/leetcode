import java.util.Arrays;
import java.util.HashMap;

public class $0350$Intersect {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        intersect2(nums1, nums2);
    }

    /**
     * 因为要记录相同部分出现的次数，所以可以使用一个hashmap存储nums1中每个数组及对应的次数，然后遍历nums2，如果能在hashmap中找到，就将map中的记录减一，同时加入输出的数组中
     * 时间复杂度：O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])){
                if (map.get(nums2[i]) > 1){
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }else {
                    map.remove(nums2[i]);
                }
                result[index++] = nums2[i];
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    /**
     * 针对进阶问题中排序数组：
     * 对于已经排序的数组，可以使用两个指针分别指向两个数组的开头，然后比较它们的大小，如果一样则加入最后返回的数组中，并把两个指针向前移动一步，如果不同则移动小的一方，直到有一个指针越界为止
     * 时间复杂度：如果直接传入排序完的数组，时间复杂度是O(m+n)，否则还要加上排序的时间
     * @param nums1
     * @param nums2
     * @return
     */
    static int[] intersect2(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, r = 0;
        int[] result = new int[nums1.length > nums2.length ? nums2.length : nums1.length];
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] > nums2[j]){
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else {
                result[r++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(result, 0, r);
    }
}
