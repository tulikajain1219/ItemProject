package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.Item;

@Repository
public interface ItemDAO extends JpaRepository<Item,Integer>{

//	public long countByItem();
	public List<Item> findByItemId(int itemId);
	public String deleteByItemId(int itemId);
	
}
