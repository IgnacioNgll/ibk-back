package com.formacionbdi.springboot.app.item.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.models.Item;
import com.formacionbdi.springboot.app.item.models.service.ItemService;

@RestController
public class ItemController {
	
	private ItemService itemService;

	
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	
	@GetMapping("/kpideclientes")
	public List<Item> listar(){
		return itemService.findAll();
	}

}
