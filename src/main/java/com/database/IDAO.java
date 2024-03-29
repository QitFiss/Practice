package com.database;
import java.util.List;
import java.util.Optional;
public interface IDAO<T> {

        Optional<T> get(int id);
        List<Optional<T>> getAll();
        boolean insert(T t);
        boolean update(T t);
        boolean delete(T t);
        boolean clearData();
    }

