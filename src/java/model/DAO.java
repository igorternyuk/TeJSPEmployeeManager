package model;

import java.util.List;

/**
 *
 * @author igor
 */
public interface DAO {
    public boolean insert(Object obj);
    public boolean update(Object obj);
    public boolean remove(int id);
    public List<?> readAll();
    public List<?> search(String regExp, String filter);
}
