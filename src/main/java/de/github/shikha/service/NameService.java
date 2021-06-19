package de.github.shikha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.github.shikha.model.NameEntity;
import de.github.shikha.repository.NameRepository;
 
@Service
public class NameService {
     
    @Autowired
    NameRepository repository;
     
    public List<NameEntity> getNames(){
        List<NameEntity> nameList = repository.findAll();
        return nameList;
    }
     
    public NameEntity getNameById(Long id){
        Optional<NameEntity> name = repository.findById(id);
        return name.get();
    }
     
    public NameEntity createOrUpdateEmployee(NameEntity entity){
    	return repository.save(entity);

    }
     
    public void deleteEmployeeById(Long id){
        repository.deleteById(id);
    }
}