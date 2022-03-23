import java.util.HashMap;

public class $904$FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1,2,1};
        System.out.println(totalFruit(fruits));
        fruits = new int[]{0,1,2,2};
        System.out.println(totalFruit(fruits));
        fruits = new int[]{1,2,3,2,2};
        System.out.println(totalFruit(fruits));
        fruits = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));
    }

    /**
     * 滑动窗口的解法：
     * 1.使用一个map集合，key是水果的种类，value是该种类出现的次数
     * 2.右指针向前移动，并根据指向的水果类型更新map
     * 3.当map中的key大于2时，说明窗口内有超过两种水果，此时左指针向前移动，直到map中的key等于2为止
     * 4.重复2、3步，直到右指针到达数组末尾
     * 时间复杂度：O(n)
     * @param fruits
     * @return
     */
    static int totalFruit(int[] fruits){
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 1, j = 0, maxLength = 1;
        map.put(fruits[0], 1);
        for (; i < fruits.length; i++){
            Integer count = map.get(fruits[i]);
            map.put(fruits[i], count == null ? 1 : count + 1);
            while (map.size() > 2){
                count = map.get(fruits[j]);
                if (count == 1){
                    map.remove(fruits[j]);
                }else {
                    map.put(fruits[j], count - 1);
                }
                j++;
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}
