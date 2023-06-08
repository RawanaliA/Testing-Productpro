package com.example.userorderproductproject;

import com.example.userorderproductproject.Model.MyOrder;
import com.example.userorderproductproject.Model.MyUser;
import com.example.userorderproductproject.Model.Product;
import com.example.userorderproductproject.Repsitory.MyUserRepository;
import com.example.userorderproductproject.Repsitory.OrderRepository;
import com.example.userorderproductproject.Service.MyUserService;
import com.example.userorderproductproject.Service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyOrderServiceTest {
    @InjectMocks
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;
    @Mock
    MyUserRepository myUserRepository ;

    MyUser myUser;

    MyOrder order1,order2;
    List<MyOrder> myOrders;
    @BeforeEach
    void setUp(){
        myUser=new MyUser(null,"rawan","123","admin",null);
        order1=new MyOrder(null,10,0,"1-2","new",null,null);
        order2=new MyOrder(null,10,0,"1-2","new",null,null);

        myOrders=new ArrayList<>();
        myOrders.add(order1);
        myOrders.add(order2);
    }
    @Test
    public void getAllOrders(){
        when(orderRepository.findAll()).thenReturn(myOrders);
        List<MyOrder> orderList=orderService.getAllOrders();
        Assertions.assertEquals(orderList,myOrders);
        Assertions.assertEquals(3,orderList.size());
        verify(orderRepository,times(1)).findAll();

    }
    @Test
    public void addOrderTest(){

        when(myUserRepository.findMyUserByid(myUser.getId())).thenReturn(myUser);
        orderService.addOrder(myUser.getId(),order2);
        verify(myUserRepository,times(1)).findMyUserByid(myUser.getId());
        verify(orderRepository,times(1)).save(order2);
    }

    @Test
    public void updateOrder(){

        when(orderRepository.findMyOrderById(order1.getId())).thenReturn(order1);
        when(myUserRepository.findMyUserByid(myUser.getId())).thenReturn(myUser);
        orderService.updateOrder(order1,order1.getId(),myUser.getId());
        verify(orderRepository,times(1)).findMyOrderById(order1.getId());
        verify(myUserRepository,times(1)).findMyUserByid(myUser.getId());
        verify(orderRepository,times(1)).save(order1);

    }

    @Test
    public void deleteOrder(){
        when(orderRepository.findMyOrderById(order2.getId())).thenReturn(order2);

        orderService.deleteOrder(order2.getId(),myUser.getId());

        verify(orderRepository,times(1)).findMyOrderById(order2.getId());
        verify(orderRepository,times(1)).delete(order2);

    }




}
