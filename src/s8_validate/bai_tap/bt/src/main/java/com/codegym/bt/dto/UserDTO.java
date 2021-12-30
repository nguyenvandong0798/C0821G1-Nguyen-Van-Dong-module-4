package com.codegym.bt.dto;

import com.codegym.bt.until.PhoneConstraint;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class UserDTO implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "name is not empty")
    @Size(min = 5, max = 45, message = "length of name is 5-45")
    private String firstName;
    @NotBlank(message = "name is not empty")
    @Size(min = 5, max = 45, message = "length of name is 5-45")
    private String lastName;
    @PhoneConstraint(message = "phone is wrong format")
    private String phone;
    @NotNull
    @Min(18) @Max(100)
    private int age;
    private String email;

    public UserDTO(int id, String firstName, String lastName,
                String phone, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public UserDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return com.codegym.bt.model.User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        com.codegym.bt.model.User user = (com.codegym.bt.model.User) target;
        if (!user.getEmail().matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$")) {
            errors.rejectValue("email", "email.invalidFormat");
        }
    }
}
