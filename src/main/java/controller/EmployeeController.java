package controller;

import model.Employee;
import repository.EmployeeDAO;
import repository.EmployeeRepository;
import service.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;

/**
 * Servlet implementation class
 */
@WebServlet("/employees")
public class EmployeeController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    public EmployeeController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employees.html");
        requestDispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Employee employeeRequest = new Employee(
                100,
                LocalDate.parse(request.getParameter("date-of-birth")),
                request.getParameter("first-name"),
                request.getParameter("last-name"),
                request.getParameter("gender").charAt(0),
                LocalDate.now(),
                request.getParameter("department")
        );

        EmployeeRepository employeeRepo = new EmployeeDAO();
        EmployeeService employeeService = new EmployeeService(employeeRepo);
        Employee employees = employeeService.addEmployee(employeeRequest);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employees.html");
        requestDispatcher.forward(request, response);
    }
}
