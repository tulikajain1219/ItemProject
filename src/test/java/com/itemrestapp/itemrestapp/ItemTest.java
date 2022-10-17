package com.itemrestapp.itemrestapp;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.dao.ItemDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Item;

@SpringBootTest
class ItemTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	
	@Autowired
	ItemDAO dao;
	
	@BeforeEach
	void setUp() throws Exception{
	}

	@AfterEach
	void teranDown() throws Exception{
	}
	
	@Test
	void testFind() {
		Item i=new Item(1,"Coffee",20f,3);
		dao.save(i);
//		Item i2=new Item(2,"Coffee",30f,30);
//		dao.save(i2);
//		int item=dao.countByItemName("Coffee");
		Item item=dao.findByItemId(i.getItemId()).get(0);
		Assertions.assertEquals(i.getItemName(), item.getItemName());
	}
//	
//	@Test
//	void testDelete() {
//		Item i=new Item(1,"Coffee",20f,3);
//		dao.save(i);
//		String del=dao.deleteByItemId(i.getItemId());
//		Assertions.assertAll(del);
//		
//	}
	
	@Test
    void test1() throws URISyntaxException, JsonProcessingException {
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/findbyid/1";
      URI uri=new URI(url);
      ResponseEntity<String> res=template.getForEntity(uri,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
      
  }
	
	@Test
    void test2() throws URISyntaxException, JsonProcessingException {
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/getallitems";
      URI uri=new URI(url);
      ResponseEntity<String> res=template.getForEntity(uri,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
	}
	
	@Test
    void testAddRest() throws URISyntaxException, JsonProcessingException {
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/additem";
      Item i=new Item(2,"Banana",678,4);
      URI uri=new URI(url);
      HttpHeaders headers = new HttpHeaders();      
      HttpEntity<Item> request = new HttpEntity<>(i, headers);
      ResponseEntity<String> res=template.postForEntity(uri,request,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
      
  }
	

}
