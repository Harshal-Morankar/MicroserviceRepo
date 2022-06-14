package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import com.csi.vo.Department;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmployeeDaoImpl {
    @Autowired
    EmployeeRepo employeeRepoImpl;
    @Autowired
    RestTemplate restTemplate;

    public Employee saveData(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public RestTemplateVO getDataById(int employeeId) {

        RestTemplateVO restTemplateVO = new RestTemplateVO();

        Employee employee = employeeRepoImpl.findByEmployeeId(employeeId);

        Department department = restTemplate.getForObject("http://DepartmentService/departments/" + employee.getDepartmentId(), Department.class);

        restTemplateVO.setEmployee(employee);
        restTemplateVO.setDepartment(department);

        return restTemplateVO;


    }
}