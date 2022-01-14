package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.service.employee.IDepartmentService;
import com.codegym.casestudy.service.employee.IEmployeeService;
import com.codegym.casestudy.service.employee.IPositionService;
import com.codegym.casestudy.service.employee.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    @Qualifier("employeeService")
    private IEmployeeService iEmployeeService;
    @Autowired
    @Qualifier("positionService")
    private IPositionService iPositionService;
    @Autowired
    @Qualifier("SkillService")
    private ISkillService iSkillService;
    @Autowired
    @Qualifier("departmentService")
    private IDepartmentService iDepartmentService;

    @GetMapping("list-page")
    public String listPage( Model model, @RequestParam(value = "page",defaultValue = "0") Integer page){
        Sort sort = Sort.by("name").descending();
        Page<Employee> employeePage = iEmployeeService.finAll(PageRequest.of(page, 3,sort));
        model.addAttribute("employeePage", employeePage);
        return "employee/list-page";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id, Model model){
        iEmployeeService.remove(id);
        model.addAttribute("employee", iEmployeeService.getAll());
        return "employee/list-page";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        iEmployeeService.remove(id);
        return "redirect:/employee/list-page";
    }

    @GetMapping("detail")
    public String detail(@RequestParam(name = "id") Integer id, Model model){
        Employee employee = iEmployeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id , Model model){
        Employee employee =iEmployeeService.findById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("position", iPositionService.getAll());
        model.addAttribute("skill", iSkillService.getAll());
        model.addAttribute("department", iDepartmentService.getAll());
        return "employee/edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute(value = "employee") Employee employee){
        iEmployeeService.save(employee);
        return "employee/list-page";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("position", iPositionService.getAll());
        model.addAttribute("skill", iSkillService.getAll());
        model.addAttribute("department", iDepartmentService.getAll());
        return "employee/create";
    }

    @PostMapping("create")
    public String create(@ModelAttribute(value = "employee") Employee employee){
        iEmployeeService.save(employee);
        return "employee/list-page";
    }

    @GetMapping(value = "/search")
    public String search (@RequestParam("name") String name, Model model){
        List<Employee> employees= iEmployeeService.searchByName(name);
        model.addAttribute("employee", employees);
        return "employee/view";
    }

}
