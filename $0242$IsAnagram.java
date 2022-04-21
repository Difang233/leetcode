import java.util.HashMap;

public class $0242$IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }

    /**
     * 1.用一个hashmap记录第一个字符串中每个字母出现的次数
     * 2.遍历第二个字符串，如果有不在hashmap中的记录，说明有不属于第一个字符串的字母，直接返回false，否则将对应字母的记录减一
     * 3.最后，如果map为空，返回true
     * @param s
     * @param t
     * @return
     */
    static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int sLen = s.length(), tLen = t.length();
        for (int i = 0; i < sLen; i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) == null ? 1 : map.get(s.charAt(i)) + 1);
        }
        for (int i = 0; i < tLen; i++) {
            if (!map.containsKey(t.charAt(i))){
                return false;
            }
            if (map.get(t.charAt(i)) == 1){
                map.remove(t.charAt(i));
            }else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        if (map.keySet().size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
