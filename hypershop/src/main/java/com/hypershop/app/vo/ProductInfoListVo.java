package com.hypershop.app.vo;

import java.util.List;

public class ProductInfoListVo {

	private Integer count;
	
	private Integer page;
	
	private Integer first;
	
	private Integer last;
	
	private Integer hits;
	
	private Integer carrier;
	
	private Integer pageCount;
	
	private List<ProductInfoVo> Items;
	
	private String[] genreInformation;
	
	private String[] tagInformation;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public Integer getLast() {
		return last;
	}

	public void setLast(Integer last) {
		this.last = last;
	}

	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}

	public Integer getCarrier() {
		return carrier;
	}

	public void setCarrier(Integer carrier) {
		this.carrier = carrier;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<ProductInfoVo> getItems() {
		return Items;
	}

	public void setItems(List<ProductInfoVo> items) {
		Items = items;
	}

	public String[] getGenreInformation() {
		return genreInformation;
	}

	public void setGenreInformation(String[] genreInformation) {
		this.genreInformation = genreInformation;
	}

	public String[] getTagInformation() {
		return tagInformation;
	}

	public void setTagInformation(String[] tagInformation) {
		this.tagInformation = tagInformation;
	}
	
	
	
}
