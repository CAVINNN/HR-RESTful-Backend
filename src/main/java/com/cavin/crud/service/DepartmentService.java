package com.cavin.crud.service;

import com.cavin.crud.bean.Department;
import com.cavin.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getAllDepartments() { return departmentMapper.selectByExample(null); }

}
