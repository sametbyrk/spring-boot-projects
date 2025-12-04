package com.bayraksamet.service;

import com.bayraksamet.dto.DtoEmployee;


public interface IEmployeeService {
    DtoEmployee getEmployeeById(Long id);
}
