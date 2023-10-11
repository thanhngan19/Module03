package controller;

import model.Employee;
import service.EmployeeService;
import service.IEmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "furama", value = "/furama")
public class EmployeeController extends HttpServlet {
    IEmployeeService service= new EmployeeService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showFormEmployee":
                findAllEmployee(req,resp);
                break;
            case"showFormCreate":
                showFormCreate(req,resp);
                break;
            case"showFormEdit":
                showFormEdit(req,resp);
                break;
            case"showFormDelete":
                formDelete(req,resp);
                break;
            case"showFormEdited":
                formEdit(req,resp);
                break;
            case "showFormSearch":
                showFormSearch(req,resp);
                break;

            default:
                findAll(req,resp);
                break;

        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case"createEmployee":
                insertEmployee(req,resp);
                break;
            case"deleteEmployee":
                deleteEmployee(req,resp);
                break;
            case"update":
                updateEmployee(req,resp);
                break;
            case"search":
                searchByName(req,resp);
                break;



            default:
                findAll(req, resp);
                break;

        }
    }
    public void findAll(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void findAllEmployee(HttpServletRequest req, HttpServletResponse resp){
        ArrayList<Employee> em=service.findAll();
        req.setAttribute("employees",em);
        try {
            req.getRequestDispatcher("/employee_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertEmployee(HttpServletRequest req, HttpServletResponse resp){
       String name = req.getParameter("nameEmployee");
       String date = req.getParameter("date");
       String cmnd= req.getParameter("CMND");
       double slary = Double.parseDouble(req.getParameter("salary"));
       String sdt = req.getParameter("SDT");
       String email = req.getParameter("email");
       String address= req.getParameter("address");
       String vi_tri = req.getParameter("vi_tri");
       String trinh_do= req.getParameter("trinh_do");
       String bo_phan = req.getParameter("bo_phan");
        Employee employee = new Employee(name,date,cmnd,sdt,email,address,slary,vi_tri,trinh_do,bo_phan);
        service.addNewEmployee(employee);
        try {
            resp.sendRedirect("/furama?action=showFormEmployee&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void showFormCreate(HttpServletRequest req, HttpServletResponse resp){
        try {
            ArrayList<String> trinhDo= service.setrinhDo();
            ArrayList<String> viTri =service.seViTri();
            ArrayList<String> boPhan= service.seBoPhan();
            req.setAttribute("viTri",viTri);
            req.setAttribute("boPhan",boPhan);
            req.setAttribute("trinhDo",trinhDo);
            req.getRequestDispatcher("/emloyee_add.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showFormEdit(HttpServletRequest req, HttpServletResponse resp){
        ArrayList<String> trinhDo= service.setrinhDo();
        ArrayList<String> viTri =service.seViTri();
        ArrayList<String> boPhan= service.seBoPhan();
        req.setAttribute("viTri",viTri);
        req.setAttribute("boPhan",boPhan);
        req.setAttribute("trinhDo",trinhDo);
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = service.findById(id);
        req.setAttribute("employee",employee);
        try {
            req.getRequestDispatcher("/employee_edit.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateEmployee(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("nameEmployee");
        String date = req.getParameter("date");
        String cmnd= req.getParameter("CMND");
        double slary = Double.parseDouble(req.getParameter("salary"));
        String sdt = req.getParameter("SDT");
        String email = req.getParameter("email");
        String address= req.getParameter("address");
        String vi_tri = req.getParameter("vi_tri");
        String trinh_do= req.getParameter("trinh_do");
        String bo_phan = req.getParameter("bo_phan");
        int ma_nhan_vien= Integer.parseInt(req.getParameter("maNhanVien"));
        Employee employee = new Employee(ma_nhan_vien,name,date,cmnd,sdt,email,address,slary,vi_tri,trinh_do,bo_phan);
        service.edit(employee);
        try {
            resp.sendRedirect("/furama?action=showFormEmployee&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void edit(HttpServletRequest req, HttpServletResponse resp){

    }
    public void formDelete(HttpServletRequest req, HttpServletResponse resp){
        ArrayList<Employee> em=service.findAll();
        req.setAttribute("employees",em);
        try {
            req.getRequestDispatcher("/employee_delete.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void formEdit(HttpServletRequest req, HttpServletResponse resp){
        ArrayList<Employee> em=service.findAll();
        req.setAttribute("employees",em);
        try {
            req.getRequestDispatcher("/form_edit_employee.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteEmployee(id);
        try {
            resp.sendRedirect("/furama?action=showFormEmployee&number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void showFormSearch(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.getRequestDispatcher("/employee_find.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void searchByName(HttpServletRequest req, HttpServletResponse resp){
        String url = req.getParameter("searchByName");
        ArrayList<Employee> employee=service.searchByName(url);
        req.setAttribute("employees",employee);
        try {
            req.getRequestDispatcher("employee_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
