package com.hieu.zk_example.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


import com.hieu.zk_example.entity.Product;
import com.hieu.zk_example.services.ProductService;

@Service("ProductService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao dao;

	
	public List<Product> getList() {
		return dao.queryAll();
	}

	

}
