package de.github.shikha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.github.shikha.model.NameEntity;
import de.github.shikha.service.NameService;

@RestController
@RequestMapping("/api/v1/names")
public class NameController {
	@Autowired
	NameService service;

	@GetMapping
	public ResponseEntity<List<NameEntity>> getNames() {
		List<NameEntity> list = service.getNames();
		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<NameEntity> getEmployeeById(@PathVariable("id") Long id) {
		NameEntity entity = service.getNameById(id);
		return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping
    public ResponseEntity<NameEntity> updateEmployee(@RequestBody NameEntity name)
    
	{   System.out.print(name.toString());
		NameEntity updatedEntity = service.createOrUpdateEmployee(name);
        return new ResponseEntity<>(updatedEntity, new HttpHeaders(), HttpStatus.OK);
    }

	@PostMapping
    public ResponseEntity<NameEntity> createEmployee( @RequestBody NameEntity name) {      
        NameEntity createdEntity = service.createOrUpdateEmployee(name);
        return new ResponseEntity<>(createdEntity, new HttpHeaders(), HttpStatus.OK);
    }

	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable("id") Long id) {
		service.deleteEmployeeById(id);
	}

}