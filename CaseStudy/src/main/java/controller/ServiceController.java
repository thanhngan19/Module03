package controller;

import service.IService;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "furama", value = "/furama")
public class ServiceController extends HttpServlet {
    private IService service= new Service();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
//        switch(action){
//            case"show":
//                finaAll(req,resp);
//                break;
//            case "showEdit":
//                showEdit(req,resp);
//                break;
//            case"showCreate":
//                showCreate(req,resp);
//                break;
//            default:
//                find(req,resp);
//                break;
//
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
//        switch(action){
//            case"update":
//                update(req,resp);
//                break;
//            case"create":
//                create(req,resp);
//                break;
//            case"delete":
//                delete(req,resp);
//                break;
//            case"search":
//                search(req,resp);
//        }
    }
    public void findAll(HttpServletRequest req, HttpServletResponse resp){
         List<model.Service> services = service.findAll();
         req.setAttribute("service",services);
        try {
            req.getRequestDispatcher("/service_list.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showCreate(HttpServletRequest req, HttpServletResponse resp){
        List<String> ldv= service.ldv();
        List<String> tkt= service.tkt();
        req.setAttribute("ldv", ldv);
        req.setAttribute("tkt", tkt);
        try {
            req.getRequestDispatcher("/service_add.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
