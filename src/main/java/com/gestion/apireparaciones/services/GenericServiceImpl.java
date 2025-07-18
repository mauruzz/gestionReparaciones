package com.gestion.apireparaciones.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    protected JpaRepository<T, ID> repository;

    public GenericServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
