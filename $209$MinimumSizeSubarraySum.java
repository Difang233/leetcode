
public class $209$MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
        nums = new int[]{1, 4, 4};
        System.out.println(minSubArrayLen(4, nums));
        nums = new int[]{1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(11, nums));
    }

    /**
     * 使用类似滑动窗口的解法：
     * 1.每当窗口内的和大于等于target时，窗口尾部往前移动一位（相当于窗口缩小），同时更新最小长度
     * 2.每当窗口内的和小于target时，窗口头部向前移动一位
     * 3.重复执行上述步骤，直到窗口头部大于数组长度为止
     * 时间复杂度：O(n) 最坏情况下每个元素操作两次，一次进入窗口，一次退出窗口
     * 空间复杂度：O(1) 开辟常量个新的空间
     * @param target 目标数
     * @param nums 数组
     * @return 最小子数组长度，如果不存在则为0
     */
    static int minSubArrayLen(int target, int[] nums){
        int i = 0, j = 0, n = nums.length, result = 0, minLen = (int) Math.pow(10, 9) + 1; //Math.pow(10, 9) + 1是数组的最大长度+1
        //j是窗口头部的索引
        for (; j < n; j++){
            result += nums[j];
            while (result >= target){ //当窗口内的和大于等于target时，窗口尾部向前滑动，直到和小于target为止
                result -= nums[i];
                minLen = Math.min(minLen, j - i +1);
                i++;
            }
        }
        return minLen > Math.pow(10, 9) ? 0 : minLen;
    }
}