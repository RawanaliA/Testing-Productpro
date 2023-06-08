package com.example.userorderproductproject;

import com.example.userorderproductproject.Model.MyOrder;
import com.example.userorderproductproject.Model.Product;
import com.example.userorderproductproject.Repsitory.MyUserRepository;
import com.example.userorderproductproject.Repsitory.OrderRepository;
import com.example.userorderproductproject.Repsitory.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.security.access.method.P;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
 Product product1,product2;
 MyOrder myOrder;
//
@BeforeEach
public void setUp(){
  myOrder=new MyOrder(null,10,0,"10-2-12","new",null,null);
    product1=new Product(null,"rawan",200,null);
    product2=new Product(null,"bayan",200,null);
}
    @Test
    public void findTodoById() {
        productRepository.save(product1);
        Product product= productRepository.findProductById(product1.getId());
        Assertions.assertThat(product).isEqualTo(product1);
    }
}
