package com.example.userorderproductproject;

import com.example.userorderproductproject.Model.MyOrder;
import com.example.userorderproductproject.Model.MyUser;
import com.example.userorderproductproject.Model.Product;
import com.example.userorderproductproject.Repsitory.MyUserRepository;
import com.example.userorderproductproject.Repsitory.OrderRepository;
import com.example.userorderproductproject.Repsitory.ProductRepository;
import com.example.userorderproductproject.Service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    ProductService productService;
   @InjectMocks
    ProductRepository productRepository;
//   @InjectMocks
//    MyUserRepository myUserRepository;
    @InjectMocks
    OrderRepository orderRepository;

    Product product1,product2;
    List<Product> products;
    MyOrder order;



    @BeforeEach
    void setUp(){
        order=new MyOrder(null,10,20,"6-7","new",null,null);
        product1=new Product(null,"pro1",100,null);
        product2=new Product(null,"pro2",200,null);

        products=new ArrayList<>();
        products.add(product1);
        products.add(product2);
    }


    @Test
    public void getAllProduct(){
        when(productRepository.findAll()).thenReturn(products);
        List<Product> productList=productService.getAllProduct();
        Assertions.assertEquals(productList,products);
        Assertions.assertEquals(3,productList.size());
        verify(orderRepository,times(1)).findAll();
    }




}
