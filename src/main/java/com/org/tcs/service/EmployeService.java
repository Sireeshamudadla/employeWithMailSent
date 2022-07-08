package com.org.tcs.service;

import com.org.tcs.model.EmailDetails;
import com.org.tcs.model.Employe;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface EmployeService {
    public void createEmploye(Employe employe);

    public List<Employe> getAllEmploye();
    public Optional<Employe> getById(Integer employeId);
    public Employe getByName( String name);
    public void updateEmploye( Employe employe);

    public String deleteById( Integer employeId);
    public String updateNameBasedOnId( Integer employeId,  String name);

    //mail method
    public String sendMail( EmailDetails details);
}