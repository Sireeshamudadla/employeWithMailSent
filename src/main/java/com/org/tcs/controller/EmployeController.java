package com.org.tcs.controller;


import com.org.tcs.model.EmailDetails;
import com.org.tcs.model.Employe;
import com.org.tcs.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeController {

   @Autowired
    EmployeService employeService;



    @PostMapping("/create")
    public void createEmploye(@RequestBody Employe employe){
        employeService.createEmploye(employe);
    }

    @GetMapping("/getAll")
  public List<Employe> getAllEmploye(){
        List<Employe> sha=    employeService.getAllEmploye();
        return sha;
    }
    @GetMapping("/getById/{employeId}")
    public Optional<Employe> getById(@PathVariable Integer employeId){
        Optional<Employe> emp= employeService.getById(employeId);
        return emp;

    }
    @GetMapping("/getByName/{name}")
    public Employe getByName(@PathVariable String name){
        Employe empp = employeService.getByName(name);
        return empp;
    }

    @PutMapping("/update")
    public void updateEmploye(@RequestBody Employe employe){
        employeService.updateEmploye(employe);
    }

    @DeleteMapping("/deleteById/{employeId}")
    public String deleteById(@PathVariable Integer employeId){
        employeService.deleteById(employeId);
        return "success";
    }

    @PatchMapping("/updateNameBasedOnId/{employeId}/{name}")
    public String updateNameBasedOnId(@PathVariable Integer employeId, @PathVariable String name){
       String ss= employeService.updateNameBasedOnId(employeId,name);
        return ss;
    }
    //mail sending method


    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details)
    {
        String status = employeService.sendMail(details);

        return status;
    }
}



