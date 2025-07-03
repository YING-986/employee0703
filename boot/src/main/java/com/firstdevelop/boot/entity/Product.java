package com.firstdevelop.boot.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Product {

	/**
	 * キー
	 */
	private int productId;
	
	/**
	 * 商品名
	 */
	private String productName;
	
	/**
	 * 販売値段
	 */
	private BigDecimal productPrice;
	
	/**
	 * 値段
	 */
	private BigDecimal productAccount;
	
	/**
	 * 生産日時
	 */
	private LocalDateTime productDate;
	
	/**
	 * 産地
	 */
	private String address;
	
	/**
	 * 商品クラスID
	 */
	private int classProductId;
	
	/**
	 * 作成日時
	 */
	private LocalDateTime createTime;
	
	/**
	 * 更新日時
	 */
	private LocalDateTime updateTime;
	
	/**
	 * 作成者
	 */
	private String createUser;
	
	/**
	 * 更新者
	 */
	private String updateUser;
	
	/**
	 * 更新者削除フラグ
	 */
	private String deleteFlag;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public BigDecimal getProductAccount() {
		return productAccount;
	}

	public void setProductAccount(BigDecimal productAccount) {
		this.productAccount = productAccount;
	}

	public LocalDateTime getProductDate() {
		return productDate;
	}

	public void setProductDate(LocalDateTime productDate) {
		this.productDate = productDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getClassProductId() {
		return classProductId;
	}

	public void setClassProductId(int classProductId) {
		this.classProductId = classProductId;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// 新規productOneを生成する（空の製品）
		Product productOne = new Product();
		productOne.setProductId(1);
		productOne.setProductName("iphone1");
		productOne.setAddress("Tokyo");
		productOne.setProductPrice(new BigDecimal("1999.999"));
		productOne.setProductDate(LocalDateTime.now());

		// 新規productTwoを生成する（製品のすべてFiledで生成する）
		Product productTwo = new Product();
		productTwo.setProductId(2);
		productTwo.setProductName("iphone2");
		productTwo.setAddress("Tokyo");
		productTwo.setProductPrice(new BigDecimal("2999.999"));
		productTwo.setProductDate(LocalDateTime.now());
		// 新規productThreeを生成する（製品のすべてFiledで生成する）
		Product productThree = new Product();
		productThree.setProductId(3);
		productThree.setProductName("iphone3");
		productThree.setAddress("Tokyo");
		productThree.setProductPrice(new BigDecimal("3999.999"));
		productThree.setProductDate(LocalDateTime.now());
		// 新規productFourを生成する（製品のすべてFiledで生成する）
		Product productFour = new Product();
		productFour.setProductId(4);
		productFour.setProductName("iphone4");
		productFour.setAddress("Tokyo");
		productFour.setProductPrice(new BigDecimal("4999.999"));
		productFour.setProductDate(LocalDateTime.now());
		// 新規productFourを生成する（製品のすべてFiledで生成する）
		Product productFive = new Product();
		productFive.setProductId(4);
		productFive.setProductName("iphone5");
		productFive.setAddress("Tokyo");
		productFive.setProductPrice(new BigDecimal("5999.999"));
		productFive.setProductDate(LocalDateTime.now());
		
		// 3) 製品リスト作成
		// 新規list productlist
		// List<クラスの名前>productList=new ArrayList<クラスの名前>()
		List<Product> productList = new ArrayList<Product>();
		productList.add(productOne);
		productList.add(productTwo);
		productList.add(productThree);
		productList.add(productFour);
		productList.add(productFive);
		// リストの第一個製品の情報を表示
		System.out.println("show first product");
		System.out.println(productList.get(0).getProductId());
		System.out.println(productList.get(0).getProductName());
		System.out.println(productList.get(0).getAddress());
		System.out.println(productList.get(0).getProductPrice());
		System.out.println(productList.get(0).getProductDate());
		// リストの第二個製品の情報を表示
		System.out.println("show second product");
		System.out.println(productList.get(1).getProductId());
		System.out.println(productList.get(1).getProductName());
		System.out.println(productList.get(1).getAddress());
		System.out.println(productList.get(1).getProductPrice());
		System.out.println(productList.get(1).getProductDate());
		// リストの第三個製品の情報を表示
		System.out.println("show third product");
		System.out.println(productList.get(2).getProductId());
		System.out.println(productList.get(2).getProductName());
		System.out.println(productList.get(2).getAddress());
		System.out.println(productList.get(2).getProductPrice());
		System.out.println(productList.get(2).getProductDate());
		// リストの第四個製品の情報を表示
		System.out.println("show forth product");
		System.out.println(productList.get(3).getProductId());
		System.out.println(productList.get(3).getProductName());
		System.out.println(productList.get(3).getAddress());
		System.out.println(productList.get(3).getProductPrice());
		System.out.println(productList.get(3).getProductDate());
		// リストの第五個製品の情報を表示
		System.out.println("show forth product");
		System.out.println(productList.get(4).getProductId());
		System.out.println(productList.get(4).getProductName());
		System.out.println(productList.get(4).getAddress());
		System.out.println(productList.get(4).getProductPrice());
		System.out.println(productList.get(4).getProductDate());
		
		// ５回ループ内処理を回す	
		// 単価合計変数を初期化	
		BigDecimal sumPrice = new BigDecimal("0.00");	
		for (int i = 0; i < 5; i++) {	
			// リスト内各製品の情報を表示	
			System.out.println(productList.get(i).getProductId());	
			System.out.println(productList.get(i).getProductName());	
			System.out.println(productList.get(i).getAddress());	
			System.out.println(productList.get(i).getProductPrice());	
			// リスト内各製品の単価の合計	
			sumPrice = sumPrice.add(productList.get(i).getProductPrice());	
			System.out.println(productList.get(i).getProductDate());	
				
			// Ctrlを押しながら、「Product」クリックして クラスの定義に入ります。	
			// 製品リストに製品１を追加	
			productList.add(productOne);	
			// 製品リストに製品２を追加	
			productList.add(productTwo);	
			// 製品リストに製品３を追加	
			productList.add(productThree);	
			// 製品リストに製品４を追加	
			productList.add(productThree);	
			// 製品リストに製品5を追加	
			productList.add(productFive);	
			// リストの第一個製品の情報を表示	
			System.out.println("show first product from list");	
			// リストの第一個製品の情報を表示	
			System.out.println(productList.get(0).getProductId());	
		}

	}
}
