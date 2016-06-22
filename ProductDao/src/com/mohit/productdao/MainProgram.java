/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.productdao;

import com.mohit.productdao.dao.ProductDao;
import com.mohit.productdao.entity.Product;
import com.mohit.productdao.impl.ProductDaoImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mohit
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            try {
            ProductDao productDao = new ProductDaoImpl();
            BufferedReader reader = new BufferedReader(new FileReader("d:/product.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] splitter = line.split(",");
                Product product = new Product();
                product.setProduct_id(Integer.parseInt(splitter[0]));
                product.setProduct_name(splitter[1]);
                product.setPrice(Integer.parseInt(splitter[2]));
                product.setQuantity(Integer.parseInt(splitter[3]));

                productDao.insert(product);
                
                
                Scanner sc = new Scanner(System.in);
                while(true){
                System.out.println("Enter the id to check");
                    for(Product p:productDao.display())
                    {
                       if(sc.nextInt()==product.getProduct_id())
                        {
                            System.out.println("The id of the product is:"+p.getProduct_id());
                            System.out.println("The name of the product is:" +p.getProduct_name());
                            System.out.println("The price of the product is:"+p.getPrice());
                            System.out.println("The quantity of the product is:"+p.getQuantity());
                            System.out.println("What is the quantity of the product you want to buy?");
                          
                            int q=sc.nextInt();
                            if(q <=p.getQuantity()){
                               int totalPrice=q*p.getPrice();
                               System.out.println("The total price of the product is:"+totalPrice);
                                System.out.println("Do you want to buy the product?[Y/N]");
                                if(sc.next().equalsIgnoreCase("y"))
                                {
                                    System.out.println("How much money you want to give??");
                                    int tp=sc.nextInt();
                                        if(totalPrice<=tp){
                                        int cashReturn=Math.abs(totalPrice-tp);
                                        System.out.println("The cash that you get back is:" +cashReturn);
                                        int qR=p.getQuantity()-q;
                                            System.out.println("The quantity of product remaining is: "+qR);
                                            if(qR==0)
                                            {
                                                System.out.println("Sorry you cannot buy any more product");
                                               
                                            }
                                       }
                                        else
                                        {
                                            System.out.println("Please make the full payment");
                                        }
                                }
                                else
                                {
                                    break;
                                }
                                
                            }
                        
                            else
                            {
                                System.out.println("Sorry the quantity of product is not available");
                            }
                        }
                       }
                        System.out.println("Do you want to buy again?[y/n]");
                            if(sc.next().equalsIgnoreCase("n"))
                            {
                                System.exit(0);
                            }
                    }
                
        }
        } catch (IOException io) {
            System.out.println(io.getLocalizedMessage());
        }

    }

    }
    
