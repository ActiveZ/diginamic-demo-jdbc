package org.diginamic.fr.dao;

import java.util.List;

/**
 * Idao est une interface générique pour toutes les futures classes de type Idao
 * @param <T>
 */
public interface Idao<T> {
    List<T> getAll();
    void insert(T data);
    int update(T ancienData , T nouveauData);
    boolean delete(T data);
}
