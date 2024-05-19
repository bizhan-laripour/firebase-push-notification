package org.example.controller;

import org.example.entity.Crud;
import org.example.service.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class CrudController {

    private final CrudService crudService;

    public CrudController(CrudService crudService) {
        this.crudService = crudService;
    }


    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody Crud crud) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(crudService.save(crud));
    }

    @GetMapping("get")
    public ResponseEntity<?> get(@RequestParam String documentId) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(crudService.get(documentId));
    }


    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody Crud crud) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(crudService.update(crud));
    }


    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestParam String documentId) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(crudService.delete(documentId));
    }


}
