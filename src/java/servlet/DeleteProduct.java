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
@WebServlet(urlPatterns = {"/deleteProduct"})
public class DeleteProduct extends HttpServlet{

    private ProductDAO productImpl = new ProductDAO();
    private String IDcode = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IDcode = req.getParameter("IDcode");
        Product product = productImpl.getByID(IDcode);
        req.setAttribute("product", product);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/deleteProduct.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productImpl.delete(IDcode);
        resp.sendRedirect("/product");
    }
    
}
