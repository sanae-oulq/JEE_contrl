package com.oulqaid.controle.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oulqaid.controle.entities.Employe;
import com.oulqaid.controle.service.EmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
    @Autowired
    private EmployeService EmployeService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Employe EmployeDetails) {
        Employe employe = EmployeService.create(EmployeDetails);
        if (employe == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(employe, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Employe employe = EmployeService.findById(id);
        if (employe == null) {
            return new ResponseEntity<>("Employe not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = EmployeService.delete(employe);
            if (deleted) {
                return new ResponseEntity<>("Employe deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Employe associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Employe employe) {
        if (EmployeService.findById(id) == null) {
            return new ResponseEntity<>("Employe not found", HttpStatus.NOT_FOUND);
        } else {
            employe.setId(id);
            return new ResponseEntity<>(EmployeService.update(employe), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Employe>> findAll() {
        return new ResponseEntity<>(EmployeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Employe employe = EmployeService.findById(id);
        if (employe == null) {
            return new ResponseEntity<>("Employe not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employe, HttpStatus.OK);
        }
    }
}
