package tasks;

import java.util.Collection;
import java.util.HashSet;

public class Task01 {

    /**
     * Реализуйте метод, который возвращает новую коллекцию,
     * но уже без дубликатов.
     * Дубликаты, если equals true.
     */
    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
    	HashSet<T> mSet = new HashSet<T>();
    	mSet.addAll(collection);
        return mSet;
    }

}
