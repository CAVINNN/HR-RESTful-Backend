package com.cavin.crud.controller;

import com.cavin.crud.bean.Department;
import com.cavin.crud.bean.Msg;
import com.cavin.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // 返回所有部门信息
    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    @ResponseBody
    public Msg getDepartments(){
        List<Department> departments = departmentService.getAllDepartments();
        return Msg.success().add("departments", departments);
    }

}
