/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cavin.crud.controller;

import com.cavin.crud.bean.Department;
import com.cavin.crud.bean.Employee;
import com.cavin.crud.bean.Msg;
import com.cavin.crud.service.DepartmentService;
import com.cavin.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // 查询所有员工信息
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmployees( @RequestParam(value = "pageNum", defaultValue = "1")Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Employee> employees = employeeService.getAllEmployees();
        PageInfo pageInfo = new PageInfo(employees, 5);
        return Msg.success().add("pageInfo", pageInfo);
    }

    // 新增员工
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    @ResponseBody
    public Msg addEmployee(@RequestBody Employee employee){
        int addNum = employeeService.addEmployee(employee);
        return Msg.success().add("addNum", addNum);
    }

    // 删除员工（批量，单一多处理）
    @RequestMapping(value = "/employee/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmployee(@PathVariable("ids") String ids){
        if(ids.contains("-")) {
            List<Integer> idList = new ArrayList<>();
            String[] del_ids = ids.split("-");
            for ( String del_id : del_ids ){
                idList.add( Integer.parseInt(del_id) );
            }
            int delNum = employeeService.deleteEmployees(idList);
            return Msg.success().add("delNum", delNum);
        }else {
            Integer id = Integer.parseInt(ids);
            int delNum = employeeService.deleteEmployee(id);
            return Msg.success().add("delNum", delNum);
        }
    }

    // 修改员工
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg changeEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        int changeNum = employeeService.updateEmployee(employee);
        return Msg.success().add("changeNum", changeNum);
    }

    // 检查用户名是否重复
    @RequestMapping("/checkUserName")
    @ResponseBody
    public Msg checkUserName(String empName) {
        boolean doUse = employeeService.checkUserName(empName);
        return Msg.success().add("doUse", doUse);
    }

}
