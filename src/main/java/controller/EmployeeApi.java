package controller;

import model.Employee;
import util.Json;
import repository.EmployeeDAO;
import repository.EmployeeRepository;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.List;

@WebServlet("/api/v1/employees")
public class EmployeeApi extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeRepository employeeRepo = new EmployeeDAO();
        EmployeeService employeeService = new EmployeeService(employeeRepo);
        List<Employee> employees = employeeService.findAllEmployees();

        String employeesJSON = Json.parseJson(employees);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        // Add content to the response body
        out.print(employeesJSON);
        out.flush();

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}
