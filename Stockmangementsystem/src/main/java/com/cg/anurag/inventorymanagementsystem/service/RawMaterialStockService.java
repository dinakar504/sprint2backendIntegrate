package com.cg.anurag.inventorymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.anurag.inventorymanagementsystem.dao.RawMaterialStockDAO;
import com.cg.anurag.inventorymanagementsystem.dto.RawMAterialOrderEntity;
import com.cg.anurag.inventorymanagementsystem.dto.RawMaterialStock;
@Service
public class RawMaterialStockService {
	@Autowired
	RawMaterialStockDAO rmsdao;
	
	RawMaterialStock rms=new RawMaterialStock();
	
	public void setpsdao(RawMaterialStockDAO psdao) { this.rmsdao=rmsdao;}
	@Transactional(readOnly=true)
	public RawMaterialStock getOrder(int orderId) {
		
			return rmsdao.findById(orderId).get();
				
			}
	@Transactional
	public RawMaterialStock createOrder(RawMAterialOrderEntity product)
	{
		
		
		    rms.setName(product.getName());
	        rms.setPrice(10);
			rms.setQuantityValue(product.getQuanvalue());
		    rms.setPrice(product.getTotalprice());
		    rms.setPricePerUnit(product.getTotalprice()/product.getQuanvalue());
		    rms.setQualityCheck("best");
				
		return	rmsdao.save(rms);
			
		
		
		
		
		
		
	}
	@Transactional(readOnly=true)
	public List<RawMaterialStock> getallOrder() {
		
			return rmsdao.findAll();
				
			}
	 @Transactional
	    public String updateProcessDate(RawMaterialStock rawMaterialStock)
	    {
		 RawMaterialStock rawMaterialStock1;
		 try
		 {
	    	 rawMaterialStock1 = rmsdao.findById(rawMaterialStock.getOrderId()).get();
		 }
		 catch(Exception ex)
		 {
			 return null; 
		 }
		
	    	  rawMaterialStock1.setProcessDate(rawMaterialStock.getProcessDate());
	    	  return "Process Date Modified";
	    	
	    	
	    }
	 @Transactional
	public String updateStock(RawMaterialStock rawMaterialStock) {
		
		 RawMaterialStock rawMaterialStock1;
		try
		{
		 rawMaterialStock1 = rmsdao.findById(rawMaterialStock.getOrderId()).get();
		}catch(Exception ex)
		
		{
			return null;
		}
		
	    	  rawMaterialStock1.setManufacturingDate(rawMaterialStock.getManufacturingDate());
	    	  rawMaterialStock1.setExpiryDate(rawMaterialStock.getExpiryDate());
	    	  rawMaterialStock1.setQualityCheck(rawMaterialStock.getQualityCheck());
	    	  return "Updated Stock Sucessfully";
	    	
	    	
	}

}
