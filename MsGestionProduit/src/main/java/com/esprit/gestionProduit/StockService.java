package com.esprit.gestionProduit;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	@Autowired
	public StockRepository stockRepository;
	
	public Stock addStock(Stock stock) {
		return stockRepository.save(stock);
	}
	
	public List<Stock> getAllStock(){
		return stockRepository.findAll();
	}
	
	public Stock getStockById(int id) {
		return stockRepository.findById(id).get();
	}
	
	
}
