package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public EmployeeController() {
        super();
    }

    /**
     * Respond to HTTP GET Method
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * Respond to HTTP POST Method
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        EmployeeRepository employeeRepo = new EmployeeDAO();
//        EmployeeService employeeService = new EmployeeService(employeeRepo);
//        List<Employee> employees = employeeService.findAllEmployees();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>List of all employees</h2>");

//        for (Employee employee : employees) {
//            out.println("<p>" + employee + "</p>");
//        }
    }
}
