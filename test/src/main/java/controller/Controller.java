package controller;

import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "product", value = "/product")

public class Controller extends HttpServlet {
    IProductService service = new ProductService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showFormEdit":
                showFormEdit2(req, resp);
                break;
            case "showFormCreate":
                showFormCreate(req, resp);
                break;
            case"showDetail":
                showFormDetail(req,resp);
                break;
            default:
                findAll(req, resp);
        }
        }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                update(req, resp);
                break;
            case "create":
                Create(req, resp);
                break;
            case"search":
                search(req, resp);
                break;
            case"delete":
                delete(req,resp);
                break;
            default:
                findAll(req, resp);
        }
    }
    private void findAll(HttpServletRequest req, HttpServletResponse resp) {
        ArrayList<Product> findAll = service.findAll();
        req.setAttribute("findAll", findAll);
        try {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product seHouse = service.selectByID(id);
        ArrayList<String> ret = service.seCategory();
        req.setAttribute("seHouse", seHouse);
        req.setAttribute("ret", ret);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/edit.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showFormEdit2(HttpServletRequest req, HttpServletResponse resp) {
        ArrayList<Product> findAll = service.findAll();

        int id = Integer.parseInt(req.getParameter("id"));
        Product seHouse = service.selectByID(id);
        ArrayList<String> ret = service.seCategory();
        req.setAttribute("seHouse", seHouse);
        req.setAttribute("ret", ret);
        req.setAttribute("findAll", findAll);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/edit_inside.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) {
        int id= Integer.parseInt(req.getParameter("id"));
        String name_pro = req.getParameter("name_pro");
        Float price = Float.valueOf(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color= req.getParameter("color");
        String category= req.getParameter("category");
        Product newHouse = new Product (id,name_pro, price, quantity, color,category);
        Map<String, String> map = service.update(newHouse,category);
        if (map.isEmpty()) {
            try {
                resp.sendRedirect("/product?number=1");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            Set<String> set = map.keySet();
            for (String key : set) {
                System.out.println(key + " " + map.get(key));
                req.setAttribute("name_p", map.get(key));
            }
            System.out.println(map.get(name_pro));
            req.setAttribute("price", price);
            req.setAttribute("color", color);
            req.setAttribute("category",category);
            req.setAttribute("quantity",quantity);
            req.setAttribute("map", map);
            try {
                req.getRequestDispatcher("/edit.jsp").forward(req, resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/create.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void Create(HttpServletRequest req, HttpServletResponse resp) {
        String name_pro = req.getParameter("name_pro");
        float price= Float.parseFloat(req.getParameter("price"));
        int quantity= Integer.parseInt(req.getParameter("quantity"));
       String color= req.getParameter("color");
       String category= req.getParameter("category");
        Product crHouse = new Product (name_pro, price, quantity, color,category);
        Map<String, String> map = service.save(crHouse,category);
        if (map.isEmpty()) {
            try {
                resp.sendRedirect("/product?number=1");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            Set<String> set = map.keySet();
            for (String key : set) {
                System.out.println(key + " " + map.get(key));
                req.setAttribute("name_p", map.get(key));
            }
            System.out.println(map.get(name_pro));
            req.setAttribute("price", price);
            req.setAttribute("color", color);
            req.setAttribute("category",category);
            req.setAttribute("quantity",quantity);
            req.setAttribute("map", map);
            try {
                req.getRequestDispatcher("/create.jsp").forward(req, resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void search(HttpServletRequest req, HttpServletResponse resp){
        String url = req.getParameter("searchByName");
        ArrayList<Product> searchByName=service.search(url);
        req.setAttribute("searchByName",searchByName);
        try {
            req.getRequestDispatcher("/search.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp){
        int id= Integer.parseInt(req.getParameter("id"));
        service.delete(id);
        try {
            resp.sendRedirect("/product?number=1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showFormDetail(HttpServletRequest req, HttpServletResponse resp){
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = service.selectByID(id);
        req.setAttribute("pro", product);
        try {
            req.getRequestDispatcher("/detail.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


