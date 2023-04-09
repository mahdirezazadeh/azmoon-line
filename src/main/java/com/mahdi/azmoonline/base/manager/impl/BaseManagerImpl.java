package com.mahdi.azmoonline.base.manager.impl;


import com.mahdi.azmoonline.base.BaseEntity;
import com.mahdi.azmoonline.base.manager.BaseManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BaseManagerImpl<E extends BaseEntity<ID>, ID extends Serializable, R extends JpaRepository<E, ID>>
        implements BaseManager<E, ID> {

    protected final R repository;

    public BaseManagerImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public List<E> saveAll(Collection<E> collection) {
        return repository.saveAll(collection);
    }

    @Override
    public Optional<E> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
