package model;

import java.util.List;

/**
 *
 * @author igor
 */
public interface ObligationDAO<T> {
    public boolean insert(T obj);
    public boolean update(T obj);
    public boolean remove(Object key);
    public T readById(Object key);
    public List<T> readAll();
    public List<T> search(String filter, String regExp);
}
