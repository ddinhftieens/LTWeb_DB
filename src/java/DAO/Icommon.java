/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author NguyenDinhTien
 */
interface Icommon <T> {
    public void add(T t);
    public void edit(T t);
    public void delete(String IDcode);
    public T getByID(String IDcode);
    public List<T> getByAll();
}
