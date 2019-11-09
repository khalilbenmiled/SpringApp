package com.esprit.gestionProduit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/stock")
public class GestionStockAPI {

	@Autowired
	public StockService stockService;
	
	@GetMapping
	public List<Stock> getAllStock() {
		return stockService.getAllStock();
	}
	
	@PostMapping
	public Stock addStock(@RequestBody Stock stock) {
		return stockService.addStock(stock);
	}
	
	@GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Stock getStockById(@PathVariable(value="id") int id) {
		return stockService.getStockById(id);
	}
	
	
	
	
	
}
