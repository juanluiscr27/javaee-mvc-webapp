package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

/**
 * Servlet implementation class
 */
@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
    @Serial
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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>List of all employees</h2>");

    }
}
