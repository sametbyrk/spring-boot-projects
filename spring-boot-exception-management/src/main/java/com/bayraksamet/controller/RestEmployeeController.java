package com.bayraksamet.controller;


import com.bayraksamet.dto.DtoEmployee;
import com.bayraksamet.model.RootEntity;
import org.springframework.stereotype.Controller;

@Controller
public interface RestEmployeeController {
    public RootEntity<DtoEmployee> getEmployeeById(Long id);
}