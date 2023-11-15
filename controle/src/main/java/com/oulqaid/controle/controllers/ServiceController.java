package com.oulqaid.controle.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oulqaid.controle.entities.Servicee;
import com.oulqaid.controle.service.ServiceService;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
    @Autowired
    private ServiceService ServiceService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Servicee ServiceDetails) {
        Servicee service = ServiceService.create(ServiceDetails);
        if (service == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Servicee service = ServiceService.findById(id);
        if (service == null) {
            return new ResponseEntity<>("Service not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = ServiceService.delete(service);
            if (deleted) {
                return new ResponseEntity<>("Service deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Service could not be deleted", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Servicee Service) {
        if (ServiceService.findById(id) == null) {
            return new ResponseEntity<>("Service not found", HttpStatus.NOT_FOUND);
        } else {
            Service.setId(id);
            return new ResponseEntity<>(ServiceService.update(Service), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Servicee>> findAll() {
        return new ResponseEntity<>(ServiceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Servicee service = ServiceService.findById(id);
        if (service == null) {
            return new ResponseEntity<>("Service not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(service, HttpStatus.OK);
        }
    }
}
