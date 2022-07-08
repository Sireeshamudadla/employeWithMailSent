package com.org.tcs.service;

import com.org.tcs.model.EmailDetails;
import com.org.tcs.model.Employe;
import com.org.tcs.repository.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService{

    @Autowired
    EmployeRepo employeRepo;

    @Autowired private JavaMailSender javaMailSender;

   /* @Value("${spring.mail.username}") private String sender;*/

    @Override
    public void createEmploye(Employe employe) {

        employeRepo.save(employe);
    }

    @Override
    public List<Employe> getAllEmploye() {
        List<Employe> sha=  employeRepo.findAll();
        return sha;
    }

    @Override
    public Optional<Employe> getById(Integer employeId) {
        Optional<Employe> emp=   employeRepo.findById(employeId);
        return emp;
    }

    @Override
    public Employe getByName(String name) {
        Employe empp=  employeRepo.getByName(name);
        return empp;
    }

    @Override
    public void updateEmploye(Employe employe) {
        employeRepo.save(employe);

    }

    @Override
    public String deleteById(Integer employeId) {
        employeRepo.deleteById(employeId);
        return "success";
    }

    @Override
    public String updateNameBasedOnId(Integer employeId, String name) {
       Optional<Employe> eee= employeRepo.findById(employeId);
        Employe ss=  eee.get();
        ss.setName(name);
        employeRepo.save(ss);
        return "success";
    }


    @Override
    public String sendMail(EmailDetails details) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        // Setting up necessary details
        mailMessage.setFrom("yogi");
        mailMessage.setTo(details.getRecipient());
        mailMessage.setText(details.getMsgBody());
        mailMessage.setSubject(details.getSubject());

        javaMailSender.send(mailMessage);
        return "succesfully send mail";
    }


}
