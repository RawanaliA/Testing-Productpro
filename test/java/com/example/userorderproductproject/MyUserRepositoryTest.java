package com.example.userorderproductproject;

import com.example.userorderproductproject.Model.MyUser;
import com.example.userorderproductproject.Repsitory.MyUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MyUserRepositoryTest {

    @Autowired
    MyUserRepository myUserRepository;

    MyUser myUser;


    @BeforeEach
    void setUp(){
        myUser=new MyUser(null,"rawan","123","custmer",null);
    }

    @Test
    public void findUserById(){
        myUserRepository.save(myUser);
        MyUser user=myUserRepository.findMyUserByid(myUser.getId());
        org.assertj.core.api.Assertions.assertThat(user).isEqualTo(myUser);
    }

///
    @Test
    public void findUserByUsername(){
        myUserRepository.save(myUser);
        MyUser myUser1=myUserRepository.findMyUserByUsername(myUser.getUsername());
        Assertions.assertThat(myUser1).isEqualTo(myUser);
    }

}
