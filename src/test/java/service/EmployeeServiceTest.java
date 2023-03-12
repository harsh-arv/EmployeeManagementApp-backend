package service;

import com.project.employeemanagement.model.EmployeeModel;
import com.project.employeemanagement.repository.EmployeeRepository;
import com.project.employeemanagement.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class EmployeeServiceTest {
    @InjectMocks
    EmployeeService employeeService;
    @Mock
    EmployeeRepository employeeRepository;

    @Test
    public void saveEmployeeTest(){
        EmployeeModel model=new EmployeeModel();
        Mockito.when(employeeRepository.save(model)).thenReturn(model);
        employeeService.saveEmployee(model);
    }

    @Test
    public void getEmployeeByIdTest(){
        Optional<EmployeeModel> model= Optional.of(new EmployeeModel());
        Mockito.when(employeeRepository.findById(0)).thenReturn(model);
        employeeService.getEmployeeById(0);
    }

    @Test
    public void getAllEmployee(){
        List<EmployeeModel> list=new ArrayList<>();
        Mockito.when(employeeRepository.findAll()).thenReturn(list);
        employeeService.getAllEmployee();

    }
    @Test
    public void updateEmployee(){
        EmployeeModel model=new EmployeeModel();
        Mockito.when(employeeRepository.findById(0)).thenReturn(Optional.of(model));
        Mockito.when(employeeRepository.save(model)).thenReturn(model);
        employeeService.updateEmployee(0,model);
    }


}
