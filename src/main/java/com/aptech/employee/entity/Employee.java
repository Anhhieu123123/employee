package com.aptech.employee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ten la bat buoc")
    @Size(min = 2, max = 100, message = "Ten phai tu 2 den 100 ky tu")
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull(message = "Tuoi la bat buoc")
    @Min(value = 2, message = "Tuoi phai lon hon hoac bang 2")
    @Max(value = 150, message = "Tuoi khong duoc vuot qua 150")
    @Column(nullable = false)
    private Integer age;

    @NotNull(message = "Luong la bat buoc")
    @Min(value = 0, message = "Luong phai la so duong")
    @Column(nullable = false)
    private Double salary;
    
    public Employee() {
    }
    
    public Employee(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Double getSalary() {
        return salary;
    }
    
    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
