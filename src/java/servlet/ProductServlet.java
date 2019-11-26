/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.ProductDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet{

    private ProductDAO productImpl = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = productImpl.getByAll();
        req.setAttribute("listProduct", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/viewProduct.jsp");
        requestDispatcher.forward(req, resp);
    }
    
}
