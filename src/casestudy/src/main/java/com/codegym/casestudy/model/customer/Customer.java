package com.codegym.casestudy.model.customer;

import com.codegym.casestudy.common.email.EmailConstraint;
import com.codegym.casestudy.common.idcard.IdCardConstraint;
import com.codegym.casestudy.common.phone.PhoneConstraint;
import com.codegym.casestudy.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "khach_hang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_khach_hang")
    private Integer id;

    @Column(name = "ho_ten")
    @NotBlank(message = "name is not empty")
    @Size(min = 5, max = 45, message = "length of name is 5-45")
    private String name;

    @Column(name = "ngay_sinh")
    @NotBlank(message = "name is not empty")
    private String birthday;

    @Column(name = "gioi_tinh")
    @NotNull(message = "gender is not null")
    private Integer gender;

    @Column(name = "so_cmnd")
    @IdCardConstraint
    private String idCard;

    @Column(name = "so_dien_thoai")
    @PhoneConstraint
    private String phone;

    @Column(name = "email")
    @EmailConstraint
    private String email;

    @Column(name = "dia_chi")
    @NotBlank(message = "dia chi is not empty")
    private String address;

    @ManyToOne
    @JoinColumn(name = "ma_loai_khach")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public Customer(Integer id, String name, String birthday, Integer gender, String idCard, String phone,
                    String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Customer() {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
