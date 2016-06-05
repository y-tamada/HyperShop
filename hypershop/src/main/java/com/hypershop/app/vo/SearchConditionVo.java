package com.hypershop.app.vo;

public class SearchConditionVo {

	/** キーワード */
	private String keyword;
	/** ジャンルID */
	private String genreId;
	/** ジャンル名 */
	private String genreName;
	/** 親ジャンル名 */
	private String parentsGenreName;
	/** アイテムコード */
	private String itemCode;
	/** shopCode */
	private String shopCode;
	/** 現在ページ */
	private Integer page;

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

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getParentsGenreName() {
		return parentsGenreName;
	}

	public void setParentsGenreName(String parentsGenreName) {
		this.parentsGenreName = parentsGenreName;
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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	
	
}
