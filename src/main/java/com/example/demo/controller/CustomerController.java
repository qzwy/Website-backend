package com.example.demo.controller;

import com.example.demo.service.CustomerService;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Qzwy
 */

@RestController
@Controller
public class CustomerController {
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/greeting")
  public CustomerService greeting(@RequestParam(value="name", defaultValue="World") String name) {
    return new CustomerService(counter.incrementAndGet(),
        String.format(template, name));
  }
}
