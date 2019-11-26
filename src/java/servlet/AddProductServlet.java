/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.ProductDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author NguyenDinhTien
 */
@WebServlet(urlPatterns = {"/addProduct"})
public class AddProductServlet extends HttpServlet {

    private ProductDAO productImpl = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addProduct.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        product.setIDcode(req.getParameter("IDcode"));
        product.setName(req.getParameter("name"));
        product.setAuthor(req.getParameter("author"));
        product.setDate(req.getParameter("date"));
        product.setNumberPage(Integer.parseInt(req.getParameter("numberpage")));
        product.setPrice(Float.parseFloat(req.getParameter("price")));
        if (!productImpl.checkIDcode(req.getParameter("IDcode"))) {
            productImpl.add(product);
            resp.sendRedirect("/product");
        } else {
            req.setAttribute("message", "error");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/addProduct.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

}
