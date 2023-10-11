package controller;

import model.Customer;
import service.CustomerService;
import service.ICustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "furama", value = "/furama")
public class CustomerController extends HttpServlet {
    private ICustomerService service= new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch(action){
            case"show":
                finaAll(req,resp);
                break;
            case "showEdit":
                showEdit(req,resp);
                break;
            case"showCreate":
                showCreate(req,resp);
                break;
            default:
                find(req,resp);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch(action){
            case"update":
                update(req,resp);
                break;
            case"create":
                create(req,resp);
                break;
            case"delete":
                delete(req,resp);
                break;
            case"search":
            search(req,resp);
        }
    }
    public void find(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void finaAll(HttpServletRequest req, HttpServletResponse resp){
        ArrayList<Customer> customer= service.findAll();
        req.setAttribute("customer", customer);
        try {
            req.getRequestDispatcher("/customer_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showEdit(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer=service.findById(id);
        ArrayList<String> tenLkh= service.seTenLoaiKhach();
        req.setAttribute("tenLkh",tenLkh);
        req.setAttribute("customer",customer);
        try {
            req.getRequestDispatcher("/customer_edit.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void update(HttpServletRequest req, HttpServletResponse resp){
       int maKh= Integer.parseInt(req.getParameter("maKh"));
       String loaiKh= req.getParameter("tenLkh");
       String date = req.getParameter("date");
       String name= req.getParameter("name");
       int gender= Integer.parseInt(req.getParameter("gender"));
       String cmnd = req.getParameter("cmnd");
       String sdt = req.getParameter("sdt");
       String address= req.getParameter("address");
       String email= req.getParameter("email");
       Customer customer= new Customer(maKh,loaiKh,name,date,gender,cmnd,sdt,address,email);
       service.edit(customer);
        try {
            resp.sendRedirect("/furama?action=show&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showCreate(HttpServletRequest req, HttpServletResponse resp){
        try {
            ArrayList<String> list = service.seTenLoaiKhach();
            req.setAttribute("tenLkh",list);
            req.getRequestDispatcher("/customer_add.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void create(HttpServletRequest req, HttpServletResponse resp){
        int maKh= Integer.parseInt(req.getParameter("maKh"));
        String loaiKh= req.getParameter("tenLkh");
        String date = req.getParameter("date");
        String name= req.getParameter("name");
        int gender= Integer.parseInt(req.getParameter("gender"));
        String cmnd = req.getParameter("cmnd");
        String sdt = req.getParameter("sdt");
        String address= req.getParameter("address");
        String email= req.getParameter("email");
        Customer customer= new Customer(maKh,loaiKh,date,name,gender,cmnd,sdt,address,email);
        service.addCustomer(customer);
        try {
            resp.sendRedirect("/furama?action=show&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteCustomer(id);
        try {
            resp.sendRedirect("/furama?action=show&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void search(HttpServletRequest req, HttpServletResponse resp){
        String search= req.getParameter("searchByName");
        ArrayList<Customer> customer= service.searchByName(search);
        req.setAttribute("customer",customer);
        try {
            req.getRequestDispatcher("/customer_search.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
