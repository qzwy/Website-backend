package com.example.demo.service;

/**
 * @author Qzwy
 *
 */
public class CustomerService {
  private final long id;
  private final String content;

  public CustomerService(long id, String content) {
    this.id = id;
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }
}
