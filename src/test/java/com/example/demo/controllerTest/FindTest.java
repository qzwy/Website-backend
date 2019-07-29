package com.example.demo.controllerTest;

import com.example.demo.controller.SmsController;
import com.example.demo.domain.Blog;
import com.example.demo.repository.BlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FindTest {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private SmsController smsController;

    @Test
    public void allBlog(){
        List<Blog> all = blogRepository.findAll();
        System.out.println(all);

    }

    @Test
    public void randomNum(){
        System.out.println("______________random" + smsController.productRandomNumber(6));
    }
}
