/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.cavin.crud.service;

import com.cavin.crud.bean.Employee;
import com.cavin.crud.bean.EmployeeExample;
import com.cavin.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    // 查询所有员工
    public List<Employee> getAllEmployees(){
        return employeeMapper.selectByExampleWithDept(null);
    }

    // 增加员工
    public int addEmployee(Employee employee){
        int addNum = employeeMapper.insertSelective(employee);
        return addNum;
    }

    // 删除单一员工
    public int deleteEmployee(Integer empId) {
        int delNum = employeeMapper.deleteByPrimaryKey(empId);
        return delNum;
    }

    // 删除批量员工
    public int deleteEmployees(List<Integer> ids) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpIdIn(ids);
        int delNum = employeeMapper.deleteByExample(example);
        return delNum;
    }

    // 修改员工
    public int updateEmployee(Employee employee) {
        int changeNum = employeeMapper.updateByPrimaryKeySelective(employee);
        return changeNum;
    }

    // 检查用户名是否重复
    public boolean checkUserName(String empName) {

        // 创建查询条件
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);

        // 执行查询
        long count = employeeMapper.countByExample(example);

        return count == 0;
    }

}
