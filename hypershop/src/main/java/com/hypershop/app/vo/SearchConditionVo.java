package com.hypershop.app.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class SearchConditionVo {

	/** キーワード */
	@Max(100)
	@Min(1)
	private String keyword;
	/** ジャンルID */
	private String genreId;
	/** アイテムコード */
	private String itemCode;
	/** shopCode */
	private String shopCode;
	/** 現在ページ */
	private Integer currentPage;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getGenreId() {
		return genreId;
	}

	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
