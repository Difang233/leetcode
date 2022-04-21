import java.util.Arrays;
import java.util.HashSet;

public class $0349$Intersection {

    /**
     * 1.将第一个数组的元素都加入一个hashset中
     * 2.遍历第二个数组，判断元素是否在hashset中，如果存在，说明是交集部分，加入另一个hashset(因为每个重复部分只需要返回一个即可)
     * 3.遍历第二步产生的hashset，转换为数组并返回
     * @param nums1
     * @param nums2
     * @return
     */
    static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (integers.contains(nums1[i])){
                continue;
            }
            integers.add(nums1[i]);
        }

        HashSet<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (integers.contains(nums2[i]) && !resultSet.contains(nums2[i])){
                resultSet.add(nums2[i]);
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer integer : resultSet) {
            result[index++] = integer;
        }
        return result;
    }
}
