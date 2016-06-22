/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.productdao.impl;

import com.mohit.productdao.dao.ProductDao;
import com.mohit.productdao.entity.Product;
import java.util.ArrayList;

/**
 *
 * @author Mohit
 */
public class ProductDaoImpl implements ProductDao{
    ArrayList<Product> productList=new ArrayList<>();
    
    @Override
    public boolean insert(Product product) {
        return productList.add(product);
    }

    @Override
    public ArrayList<Product> display() {
        return productList;
    }
    
}
