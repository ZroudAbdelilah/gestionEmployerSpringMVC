package com.exemple.gestion_employer1.services;

import java.util.List;

public interface ServiceInt <T> {
    T add(T object);
    T find(long id);
    List<T> getAll();
    T update(T object);
    boolean delete(long id);
}
