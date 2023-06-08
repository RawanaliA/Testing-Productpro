package com.example.userorderproductproject;

import com.example.userorderproductproject.Model.MyOrder;
import com.example.userorderproductproject.Model.MyUser;
import com.example.userorderproductproject.Repsitory.MyUserRepository;
import com.example.userorderproductproject.Repsitory.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MyUserRepository myUserRepository;

    MyOrder order1,order2;
    MyUser  myUser;
    List<MyOrder>myOrderList;
    @BeforeEach
    void setUp(){
        myUser=new MyUser(null,"roro","123","ADMIN",null);
        order1=new MyOrder(null,10,20,"12","new",myUser,null);
        order2=new MyOrder(null,10,20,"12","new",myUser,null);
    }
    public void findmyOrderByUser(){
        orderRepository.save(order1);
        orderRepository.save(order2);
       myOrderList=orderRepository.findMyOrderByMyUserId(myUser.getId());
        Assertions.assertThat(myOrderList.get(0).getMyUser().getId()).isEqualTo(myUser.getId());

    }
    @Test
    public void findMyOrderById(){
        orderRepository.save(order1);
        MyOrder myorder=orderRepository.findMyOrderById(order1.getId());
        Assertions.assertThat(myorder).isEqualTo(order1);
    }


}
