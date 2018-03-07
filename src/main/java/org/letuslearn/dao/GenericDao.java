// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.dao;

import java.util.List;
/**
 *
 * @author aksharaaaa GenericDao
 * @param <T> This is the type parameter
 */
public interface GenericDao<T> {
    List<T> getAll();
    //public boolean get(T type);
    boolean insert(T type);
    boolean update(T type);
    int delete(T type);

}
