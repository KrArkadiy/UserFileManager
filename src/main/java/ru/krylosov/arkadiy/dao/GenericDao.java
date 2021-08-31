package ru.krylosov.arkadiy.dao;

import java.util.List;

public interface GenericDao<T,ID> {

    T getById(ID id);

    List<T> getAll();

    T update(T t);

    T save(T t);

    void deleteById(ID id);
}
