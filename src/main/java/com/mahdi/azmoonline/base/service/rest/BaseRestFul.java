package com.mahdi.azmoonline.base.service.rest;

import com.mahdi.azmoonline.base.BaseDTO;
import com.mahdi.azmoonline.base.BaseEntity;
import com.mahdi.azmoonline.base.BaseMapper;
import com.mahdi.azmoonline.base.manager.BaseManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseRestFul<E extends BaseEntity<PK>, D extends BaseDTO<PK>, PK extends Serializable,
        S extends BaseManager<E, PK>, M extends BaseMapper<E, D, PK>> {

    private final S service;

    private final M mapper;

    public BaseRestFul(S service, M mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<D>> getAll() {
        return ResponseEntity.ok(
                mapper.convertListEntityToDTO(
                        service.findAll()
                )
        );
    }

    @GetMapping("/pageable")  /*  /user/pageable?size=5&page=1&sort=id,desc&sort=age,desc    */
    public ResponseEntity<Page<D>> getAll(Pageable pageable) {

        Page<E> page = service.findAll(pageable);

        return ResponseEntity.ok(
                page.map(
                        mapper::convertEntityToDTO
                )
        );

    }


    @GetMapping("/{id}") /* /user/5 */
    public ResponseEntity<D> findById(@PathVariable("id") PK id) {
        Optional<E> optionalE = service.findById(id);

        return optionalE.map(e -> ResponseEntity.ok(
                mapper.convertEntityToDTO(
                        e
                )
        )).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}") /* /user/5 */
    public ResponseEntity<Void> delete(@PathVariable("id") PK id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<D> save(@RequestBody D d) {

        if (d.getId() != null) {
            return ResponseEntity.badRequest().build();
        }

        E entity = service.save(
                mapper.convertDTOToEntity(d)
        );

        return ResponseEntity.ok(
                mapper.convertEntityToDTO(entity)
        );

    }

    @PutMapping
    public ResponseEntity<D> update(@RequestBody D d) {

        if (d.getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        E entity = service.save(
                mapper.convertDTOToEntity(d)
        );

        return ResponseEntity.ok(
                mapper.convertEntityToDTO(entity)
        );

    }


}
