package com.bayraksamet.controller.impl;

import com.bayraksamet.controller.RestEmployeeController;
import com.bayraksamet.dto.DtoEmployee;
import com.bayraksamet.model.RootEntity;
import com.bayraksamet.service.IEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeControllerImpl extends RestBaseController implements RestEmployeeController {

    private final IEmployeeService employeeService;

    public RestEmployeeControllerImpl(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    @GetMapping("/list/{id}")
    public RootEntity<DtoEmployee> getEmployeeById(@PathVariable Long id) {
        return ok(employeeService.getEmployeeById((Long) id));
    }
}