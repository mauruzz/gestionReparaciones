package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.Client;

import java.util.List;

public interface GenericService<T, ID> {

    List<T> findAll();
    T findById(ID id);
    T save(T entity);
    void delete(ID id);

}
