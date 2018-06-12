package com.hieu.zk_example;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import com.hieu.zk_example.entity.Category;
import com.hieu.zk_example.entity.Product;
import com.hieu.zk_example.services.MyService;
import com.hieu.zk_example.services.ProductService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MyViewModel {

	@WireVariable
	private MyService myService;
	@WireVariable
	private ProductService productService;
	
	private List<Product> listProduct;
	private List<Category> logListModel;
	private Category select;
	private Product selected;
	private String keyword;

	@Init
	public void init() {
		logListModel = myService.getList();
		listProduct = productService.getList();

	}

	public List<Category> getLogListModel() {
		return logListModel;
	}

	public Category getSelect() {
		return select;
	}

	public void setSelect(Category select) {
		this.select = select;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
	
	public Product getSelected() {
		return selected;
	}

	public void setSelected(Product selected) {
		this.selected = selected;
	}


	@Command
	public void add() {
		if (Strings.isBlank(keyword)) {
			return;
		}

		Category log = new Category(null, keyword);
		log = myService.add(log);
		logListModel.add(log);
	}

	// @Command
	// @NotifyChange("logListModel")
	// public void searchAll() {
	// logListModel = myService.getList();
	// }

	@Command
	public void delete(@BindingParam("cat") Category cat) {
		myService.delete(cat);
		logListModel.remove(cat);
		BindUtils.postNotifyChange(null, null, this, "logListModel");
	}
		
	// @Command
	// public void showEdit111(@BindingParam("cat") Category cat) {
	// Execution e = e.getAttribute(current);
	// Executions.sendRedirect("edit.zul");
	// }

	// @Command
	// @NotifyChange("logListModel")
	// public void search(){
	// logListModel = myService.search(keyword);
	// }

}
