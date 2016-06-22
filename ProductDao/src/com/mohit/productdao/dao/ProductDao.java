/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.productdao.dao;

import com.mohit.productdao.entity.Product;
import java.util.ArrayList;

/**
 *
 * @author Mohit
 */
public interface ProductDao  {
     boolean insert(Product product);

    ArrayList<Product> display();
}
