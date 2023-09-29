package com.example.ss10_ex2_calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double operand1 = Double.parseDouble(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        double operand2 = Double.parseDouble(request.getParameter("operand2"));
        double result = 0.0;
        try {
            result = calculate(operand1, operator, operand2);
        } catch (Exception e) {
            request.setAttribute("Error", e.getMessage());
        }
        request.setAttribute("operand1", operand1);
        request.setAttribute("operator", operator);
        request.setAttribute("operand2", operand2);
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
    public static double calculate(double operand1, String operator, double operand2) throws Exception {
        double result = 0.0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    throw new Exception("Cannot devide by 0");
                }
                result = operand1 / operand2;
                break;
        }
        return result;
    }
}
