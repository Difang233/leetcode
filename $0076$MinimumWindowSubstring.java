import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class $0076$MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    /**
     * 滑动窗口法：
     * 1.遍历字符串t，确定有多少个字母，每个字母的个数，将结果存储在map中，同时维护一个set，记录出现过的字母
     * 2.字符串s上窗口的右指针向前移动，对于不需要的字母直接跳过，需要的字母将出现次数记录在一个新的map中
     * 3.如果该字母在新的map中出现的次数超过了原来的map，说明在s上已经找到了足够多的该字母，可以将它从set中移除
     * 4.重复上述步骤，直到set为空，此时窗口满足题目的要求，记录下窗口的长度和左右两个指针的位置
     * 5.移动窗口的左指针，如果左指针所指的字母在原始map中出现，就在新map中将对应字母的值减一
     * 6.重复上面一个步骤，直到新map中的值小于原始map中的值，说明某个字母的出现次数不满足要求，需要将该字母放回set中
     * 时间复杂度：O(m+n)，m和n分别为s和t的长度
     * @param s
     * @param t
     * @return
     */
    static String minWindow(String s, String t){
        HashMap<Character, Integer> originMap = new HashMap<>(); //原始的map
        HashMap<Character, Integer> newMap = new HashMap<>(); //新map
        HashSet<Character> charSet = new HashSet<>(); //set用来存放不满足要求的字母
        char[] tChars = t.toCharArray();
        Integer count;
        //遍历字符串t，将每个字母的出现次数记录在原始map中，有哪些字母记录在set中
        for (int i = 0; i < tChars.length; i++) {
            count = originMap.get(tChars[i]);
            if (count == null){
                originMap.put(tChars[i], 1);
                charSet.add(tChars[i]);
            }else {
                originMap.put(tChars[i], count + 1);
            }
        }
        int i = 0, j = 0, minLength = (int) Math.pow(10, 5) + 1, startIndex = -1, endIndex = -1;

        char[] sChars = s.toCharArray();
        //遍历字符串s，j是窗口的右指针
        for (; j < sChars.length; j++){
            //如果是原始map中不包含的字母，直接跳过
            if (!originMap.containsKey(sChars[j])){
                continue;
            }
            //将出现的字母和次数放入新map中
            count = newMap.get(sChars[j]);
            count = count == null ? 1 : count + 1;
            newMap.put(sChars[j], count);
            //如果新map中的值大于等于了原始map中对应字母的值，说明该字母已经找到足够多次，可以从set中去掉
            if (count >= originMap.get(sChars[j])){
                charSet.remove(sChars[j]);
            }
            //当set为空时，说明窗口满足题目要求，此时可以尝试缩小窗口
            while (charSet.size() == 0){
                //判断窗口长度是否为最小，如果是还需要记录下此时左右指针的位置，供后续截取字符串使用
                if (minLength > j - i + 1){
                    minLength = j - i + 1;
                    startIndex = i;
                    endIndex = j;
                }
                //如果左指针所指字母在需要的字母中，需要将新map中对应值减一，因为该字母将被移出窗口
                if (originMap.containsKey(sChars[i])){
                    count = newMap.get(sChars[i]);
                    newMap.put(sChars[i], --count);
                    //如果新map中的值小于原始map的值，说明窗口中该字母已经没有足够的值，此时需要将该字母放回set中
                    if (count < originMap.get(sChars[i])){
                        charSet.add(sChars[i]);
                    }
                }
                //左指针向前移动
                i++;
            }
        }
        //如果startIndex没有更新过，说明没有找到，此时返回空字符串
        if (startIndex == -1){
            return "";
        }
        //根据记录的左右指针位置截取字符串并返回
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.substring(startIndex, endIndex + 1);
    }
}
