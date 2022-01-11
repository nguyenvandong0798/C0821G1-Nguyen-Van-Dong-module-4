package com.codegym.casestudy.model.employee;

import javax.persistence.*;

@Entity(name = "nhan_vien")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private Integer id;
    @Column(name = "ho_va_ten")
    private String name;
    @Column(name = "ngay_sinh")
    private String birthDay;
    @Column(name = "co_cmnd")
    private String idCard;
    @Column(name = "luong")
    private String salary;
    @Column(name = "so_dien_thoai")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "dia_chi")
    private String address;

    @ManyToOne
    @JoinColumn(name = "ma_vi_tri")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "ma_trinh_do")
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "ma_bo_phan")
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String name, String birthDay, String idCard, String salary, String phone,
                    String email, String address, Position position, Skill skill, Department department) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.skill = skill;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
