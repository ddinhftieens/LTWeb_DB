/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author NguyenDinhTien
 */
public class ProductDAO extends getConnection implements Icommon<Product>{

    @Override
    public void add(Product t) {
        Connection connec = getConn();
        String sql = "insert into project_3(IDcode,name,author,date,numberPage,price)values(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, t.getIDcode());
            pre.setString(2, t.getName());
            pre.setString(3, t.getAuthor());
            pre.setString(4, t.getDate());
            pre.setInt(5, t.getNumberPage());
            pre.setFloat(6, t.getPrice());
            pre.execute();
            pre.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void edit(Product t) {
        Connection connec = getConn();
        String sql = "update project_3 set name=?, author=?,date=?,numberPage=?,price=? where IDcode = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, t.getName());
            pre.setString(2, t.getAuthor());
            pre.setString(3, t.getDate());
            pre.setInt(4, t.getNumberPage());
            pre.setFloat(5, t.getPrice());
            pre.setString(6, t.getIDcode());
            pre.execute();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(String IDcode) {
        Connection connec = getConn();
        String sql = "delete project_3 where IDcode = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, IDcode);
            pre.execute();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Product getByID(String IDcode) {
        Product pro = new Product();
        Connection connec = getConn();
        String sql = "select * from project_3 where IDcode = '" + IDcode +"'" ;
        try {
            Statement sta = connec.createStatement();
            ResultSet res = sta.executeQuery(sql);
            while(res.next()){
                pro.setIDcode(res.getString(1));
                pro.setName(res.getString(2));
                pro.setAuthor(res.getString(3));
                pro.setDate(res.getString(4));
                pro.setNumberPage(res.getInt(5));
                pro.setPrice(res.getFloat(6));
            }
            sta.close();
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pro;
    }

    @Override
    public List<Product> getByAll() {
        List<Product> list = new ArrayList<>();
        Connection connec = getConn();
        String sql = "select * from project_3";
        try {
            Statement sta = connec.createStatement();
            ResultSet res = sta.executeQuery(sql);
            while(res.next()){
                Product pro = new Product();
                pro.setIDcode(res.getString(1));
                pro.setName(res.getString(2));
                pro.setAuthor(res.getString(3));
                pro.setDate(res.getString(4));
                pro.setNumberPage(res.getInt(5));
                pro.setPrice(res.getFloat(6));
                list.add(pro);
            }
            sta.close();
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    public boolean checkIDcode(String IDcode){
        boolean status = true;
        Connection connec = getConn();
        String sql = "select * from project_3 where IDcode = '" + IDcode +"'" ;
        try {
            Statement sta = connec.createStatement();
            ResultSet res = sta.executeQuery(sql);
            status = res.next();
            sta.close();
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }
}
