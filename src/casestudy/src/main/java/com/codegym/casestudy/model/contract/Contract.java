package com.codegym.casestudy.model.contract;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.service.Service;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "hop_dong")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong", unique = true)
    private Integer id;
    @Column(name = "ngay_lam_hop_dong", unique = true)
    private String dateIn;
    @Column(name = "ngay_ket_thuc", unique = true)
    private String dateOut;
    @Column(name = "tien_dat_coc", unique = true)
    private Double deposit;
    @Column(name = "tong_tien", unique = true)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu")
    private Service service;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetails;

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Contract() {
    }

    public Contract(Integer id, String dateIn, String dateOut, Double deposit, Double total, Employee employee,
                    Service service, Customer customer) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.deposit = deposit;
        this.total = total;
        this.employee = employee;
        this.service = service;
        this.customer = customer;
    }

    public Contract(Integer id, String dateIn, String dateOut, Double deposit, Double total, Employee employee,
                    Customer customer, Service service, Set<ContractDetail> contractDetails) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.deposit = deposit;
        this.total = total;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.contractDetails = contractDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
