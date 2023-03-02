package lab01.tdd.utils;

import java.util.List;

public class CollectionsUtils {
    public static List<Integer> reverse(List<Integer> list) {
        for(int i = 0, j = list.size() - 1; i < j; i++) {
            list.add(i, list.remove(j));
        }
        return list;
    }
}
