/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.coffee.Backend.DAO;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface DAOInterface<T> {
    public int Create(T t);
    public int Update(T t);
    public int Delete(T t);
    
    public ArrayList<T> selectAll();
    
    public T selectById(T t);
    
    public ArrayList<T> selectByCondition(String condition);
    
    public boolean deleteAccount(int userId);
    public boolean restoreAccount(int userId);
    public boolean restoreAccountByEmail(String email);
}
