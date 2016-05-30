package com.hypershop.app.vo;

import java.math.BigDecimal;
import java.util.List;

public class ItemVo {

	private String itemName;
	
	private String catchcopy;
	
	private String itemCode;
	
	private BigDecimal itemPrice;
	
	private String itemCaption;
	
	private String itemUrl;
	
	private String affiliateUrl;
	
	private Character imageFlag;
	
	private List<imageUrlVo> smallImageUrls;
	
	private List<imageUrlVo> mediumImageUrls;
	
	private Character availability;
	
    private Character taxFlag;
    
    private Character postageFlag;
    
    private Character creditCardFlag;
    
    private Character shopOfTheYearFlag;
    
    private Character shipOverseasFlag;
    
    private String shipOverseasArea;
    
    private Character asurakuFlag;
    
    private String asurakuClosingTime;
    
    private String asurakuArea;
    
    private Integer affiliateRate;
    
    private String shopAffiliateUrl;
    
    private String startTime;
    
    private String endTime;
    
    private Integer reviewCount;
    
    private Double reviewAverage;
    
    private Integer pointRate;
    
    private String pointRateStartTime;
    
    private String pointRateEndTime;
    
    private Character giftFlag;
    
    private String shopName;

    private String shopCode;

    private String shopUrl;

    private String genreId;

    private String[] tagIds;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCatchcopy() {
		return catchcopy;
	}

	public void setCatchcopy(String catchcopy) {
		this.catchcopy = catchcopy;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCaption() {
		return itemCaption;
	}

	public void setItemCaption(String itemCaption) {
		this.itemCaption = itemCaption;
	}

	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	public String getAffiliateUrl() {
		return affiliateUrl;
	}

	public void setAffiliateUrl(String affiliateUrl) {
		this.affiliateUrl = affiliateUrl;
	}

	public Character getImageFlag() {
		return imageFlag;
	}

	public void setImageFlag(Character imageFlag) {
		this.imageFlag = imageFlag;
	}

	public List<imageUrlVo> getSmallImageUrls() {
		return smallImageUrls;
	}

	public void setSmallImageUrls(List<imageUrlVo> smallImageUrls) {
		this.smallImageUrls = smallImageUrls;
	}

	public List<imageUrlVo> getMediumImageUrls() {
		return mediumImageUrls;
	}

	public void setMediumImageUrls(List<imageUrlVo> mediumImageUrls) {
		this.mediumImageUrls = mediumImageUrls;
	}

	public Character getAvailability() {
		return availability;
	}

	public void setAvailability(Character availability) {
		this.availability = availability;
	}

	public Character getTaxFlag() {
		return taxFlag;
	}

	public void setTaxFlag(Character taxFlag) {
		this.taxFlag = taxFlag;
	}

	public Character getPostageFlag() {
		return postageFlag;
	}

	public void setPostageFlag(Character postageFlag) {
		this.postageFlag = postageFlag;
	}

	public Character getCreditCardFlag() {
		return creditCardFlag;
	}

	public void setCreditCardFlag(Character creditCardFlag) {
		this.creditCardFlag = creditCardFlag;
	}

	public Character getShopOfTheYearFlag() {
		return shopOfTheYearFlag;
	}

	public void setShopOfTheYearFlag(Character shopOfTheYearFlag) {
		this.shopOfTheYearFlag = shopOfTheYearFlag;
	}

	public Character getShipOverseasFlag() {
		return shipOverseasFlag;
	}

	public void setShipOverseasFlag(Character shipOverseasFlag) {
		this.shipOverseasFlag = shipOverseasFlag;
	}

	public String getShipOverseasArea() {
		return shipOverseasArea;
	}

	public void setShipOverseasArea(String shipOverseasArea) {
		this.shipOverseasArea = shipOverseasArea;
	}

	public Character getAsurakuFlag() {
		return asurakuFlag;
	}

	public void setAsurakuFlag(Character asurakuFlag) {
		this.asurakuFlag = asurakuFlag;
	}

	public String getAsurakuClosingTime() {
		return asurakuClosingTime;
	}

	public void setAsurakuClosingTime(String asurakuClosingTime) {
		this.asurakuClosingTime = asurakuClosingTime;
	}

	public String getAsurakuArea() {
		return asurakuArea;
	}

	public void setAsurakuArea(String asurakuArea) {
		this.asurakuArea = asurakuArea;
	}

	public Integer getAffiliateRate() {
		return affiliateRate;
	}

	public void setAffiliateRate(Integer affiliateRate) {
		this.affiliateRate = affiliateRate;
	}

	public String getShopAffiliateUrl() {
		return shopAffiliateUrl;
	}

	public void setShopAffiliateUrl(String shopAffiliateUrl) {
		this.shopAffiliateUrl = shopAffiliateUrl;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public Double getReviewAverage() {
		return reviewAverage;
	}

	public void setReviewAverage(Double reviewAverage) {
		this.reviewAverage = reviewAverage;
	}

	public Integer getPointRate() {
		return pointRate;
	}

	public void setPointRate(Integer pointRate) {
		this.pointRate = pointRate;
	}

	public String getPointRateStartTime() {
		return pointRateStartTime;
	}

	public void setPointRateStartTime(String pointRateStartTime) {
		this.pointRateStartTime = pointRateStartTime;
	}

	public String getPointRateEndTime() {
		return pointRateEndTime;
	}

	public void setPointRateEndTime(String pointRateEndTime) {
		this.pointRateEndTime = pointRateEndTime;
	}

	public Character getGiftFlag() {
		return giftFlag;
	}

	public void setGiftFlag(Character giftFlag) {
		this.giftFlag = giftFlag;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getShopUrl() {
		return shopUrl;
	}

	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}

	public String getGenreId() {
		return genreId;
	}

	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}

	public String[] getTagIds() {
		return tagIds;
	}

	public void setTagIds(String[] tagIds) {
		this.tagIds = tagIds;
	}
}
