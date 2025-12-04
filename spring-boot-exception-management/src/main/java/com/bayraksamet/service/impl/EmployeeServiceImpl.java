package com.bayraksamet.service.impl;

import com.bayraksamet.dto.DtoDepartment;
import com.bayraksamet.dto.DtoEmployee;
import com.bayraksamet.exception.BaseException;
import com.bayraksamet.exception.ErrorMessage;
import com.bayraksamet.exception.MessageType;
import com.bayraksamet.model.Department;
import com.bayraksamet.model.Employee;
import com.bayraksamet.repository.EmployeeRepository;
import com.bayraksamet.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DtoEmployee getEmployeeById(Long id) {

        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXISTS, id.toString()));
        }

        Employee employee = optional.get();
        Department department = employee.getDepartment();

        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();

        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department, dtoDepartment);

        dtoEmployee.setDepartment(dtoDepartment);
        return dtoEmployee;
    }

}
