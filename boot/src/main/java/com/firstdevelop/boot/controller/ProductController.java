package com.firstdevelop.boot.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstdevelop.boot.entity.Product;
import com.firstdevelop.boot.form.ProductForm;
import com.firstdevelop.boot.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/searchAll")
	public String searchAll(Model model) {

		List<Product> productList = productService.searchAll();
		// リストの第1個製品の情報を表示	
		System.out.println("show first student");	
		System.out.println(productList.get(0).getAddress());	
		System.out.println(productList.get(0).getClassProductId());	
		System.out.println(productList.get(0).getCreateUser());	
		System.out.println(productList.get(0).getProductId());	
		System.out.println(productList.get(0).getProductName());	
		System.out.println(productList.get(0).getClass());	
		System.out.println(productList.get(0).getProductAccount());	
		System.out.println(productList.get(0).getProductDate());	
		System.out.println(productList.get(0).getProductPrice());	
		// リストの第2個製品の情報を表示	
		System.out.println("show first student");	
		System.out.println(productList.get(1).getAddress());	
		System.out.println(productList.get(1).getClassProductId());	
		System.out.println(productList.get(1).getCreateUser());	
		System.out.println(productList.get(1).getProductId());	
		System.out.println(productList.get(1).getProductName());	
		System.out.println(productList.get(1).getClass());	
		System.out.println(productList.get(1).getProductAccount());	
		System.out.println(productList.get(1).getProductDate());	
		System.out.println(productList.get(1).getProductPrice());	
		// リストの第3個製品の情報を表示	
		System.out.println("show first student");	
		System.out.println(productList.get(3).getAddress());	
		System.out.println(productList.get(3).getClassProductId());	
		System.out.println(productList.get(3).getCreateUser());	
		System.out.println(productList.get(3).getProductId());	
		System.out.println(productList.get(3).getProductName());	
		System.out.println(productList.get(3).getClass());	
		System.out.println(productList.get(3).getProductAccount());	
		System.out.println(productList.get(3).getProductDate());	
		System.out.println(productList.get(3).getProductPrice());	
		// 単価合計変数初期化	
		BigDecimal  sumPrice = new BigDecimal(0.0);	
		// 4回for ループする	
		for (int i = 0; i < 4; i++) {	
			// リスト内各productの情報を表示
			System.out.println(productList.get(i).getAddress());
			System.out.println(productList.get(i).getClassProductId());
			System.out.println(productList.get(i).getCreateUser());
			System.out.println(productList.get(i).getProductId());
			System.out.println(productList.get(i).getProductName());
			System.out.println(productList.get(i).getClass());
			System.out.println(productList.get(i).getProductAccount());
			System.out.println(productList.get(i).getProductDate());
			System.out.println(productList.get(i).getProductPrice());
			sumPrice=sumPrice.add((productList.get(i).getProductPrice()));
		}	
		System.out.println("Sum of product score： " + sumPrice);	

		
		model.addAttribute("productList", productList);
		model.addAttribute("title", "ユーザー一覧");
		
		return "/product/productDetail";
	}
	
	@RequestMapping("/registInit")
	public String registInit() {
		
		return "/product/regist";
	}
	
	@RequestMapping("/regist")
	public String regist(ProductForm form) {
		
		productService.regist(form);
		return "redirect:searchAll";
	}
	@RequestMapping("/delete/{productId}")
	public String delete(@PathVariable("productId") Integer productId ,Model model) {
		
		productService.delete(productId);
		
		List<Product> productList = productService.searchAll();
		model.addAttribute("productList", productList);
		model.addAttribute("title", "ユーザー一覧");
		return "/product/productDetail";
		//return "redirect:searchAll";
	}
	
}
