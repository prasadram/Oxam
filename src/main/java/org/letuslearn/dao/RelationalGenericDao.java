// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.dao;
/**
 *
 * @author aksharaaaa RelationalGenericDao
 * @param <T> This is the type parameter
 */
public interface RelationalGenericDao<T> extends GenericDao<T> {
    T get(T type);
}
