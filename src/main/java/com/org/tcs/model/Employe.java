package com.org.tcs.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data

public class Employe {
    @Id
    @Column(name = "id")
    private int employeId;
    private String name;
    private String address;
    private double salary;



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeId() {
        return employeId;
    }

    public void setEmployeId(int employeId) {
        this.employeId = employeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
