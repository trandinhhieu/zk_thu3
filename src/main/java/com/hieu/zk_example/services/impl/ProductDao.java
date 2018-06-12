package com.hieu.zk_example.services.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.hieu.zk_example.entity.Product;

@Repository
public class ProductDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public List<Product> queryAll() {
		return em.createQuery("select p from Product p",Product.class).getResultList();
	}

}
