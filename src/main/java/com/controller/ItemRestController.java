package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ItemDAO;
import com.model.Item;

@RestController
public class ItemRestController {
	@Autowired
	ItemDAO dao;
	
	@GetMapping("/homeinfo")
	public String getHomeInfor() {
		return "Home for Itemrestcontroller!!";
	}
	@PostMapping("/additem")
	public ResponseEntity addItem(@RequestBody Item item) {
		dao.save(item);
		return new ResponseEntity("Item added", HttpStatus.OK);
	}
	
	@GetMapping("getallitems")
	public List<Item> getAllItem(){
		return dao.findAll();
	}
	
	@PatchMapping("/updateitem")
	public ResponseEntity updateItem(@RequestBody Item item) {
		dao.save(item);
		return new ResponseEntity("item updated",HttpStatus.OK);
	}
	@DeleteMapping("/deleteitem")
	public ResponseEntity deleteItem(@RequestBody Item item) {
		dao.delete(item);
		return new ResponseEntity("item deleted",HttpStatus.OK);
	}
//	@GetMapping("/findbyid/{id}")
//	public Item getitem(@PathVariable int id) {
//		Item item=dao.getById(id).get();
//		return item;
//	}
	@GetMapping("/findbyid/{id}")
	public Optional<Item> getitem(@PathVariable int id) {
		Optional<Item> item=dao.findById(id);
		return item;
	}
	
	//###########Test cases###########
//	@PostMapping("/itemdelete/{id}")
//	public String deleteByItemId(@PathVariable int itemId) {
//		dao.deleteByItemId(itemId);
//		return "deleted";
//	}
//###########################
}
