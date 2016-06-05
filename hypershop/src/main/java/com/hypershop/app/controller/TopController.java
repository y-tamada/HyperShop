package com.hypershop.app.controller;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hypershop.app.service.ProductInfoService;
import com.hypershop.app.vo.ProductInfoListVo;
import com.hypershop.app.vo.SearchConditionVo;


@Controller
@ComponentScan("com.hypershop.app.service")
public class TopController {
	//ログ
	private static final Logger logger = LoggerFactory.getLogger(TopController.class);
	// メッセージリソース
	@Autowired
	MessageSource messageSource;
	
	// サービス
	@Autowired
	ProductInfoService service;
	
	
	@RequestMapping("/")
	public String init(Model model){
		
		logger.info("-----------------  APP START !!! ---------------------");
		
		return "index";
	}
	
	@RequestMapping("/productSearch")
	public String productSearch(Locale locale, SearchConditionVo searchConditionVo, Model model){
		
		// キーワードとジャンルIDがなければ検索しない 
		if(StringUtils.isBlank(searchConditionVo.getKeyword()) && StringUtils.isBlank(searchConditionVo.getGenreId())){
			logger.info("search condition is blank !!");
			return "product_list"; 
		}
		
		ProductInfoListVo productInfoListVo = null;
		
		productInfoListVo = service.getProductInfo(locale, searchConditionVo);
		
		if(StringUtils.isBlank(searchConditionVo.getGenreId())){
			searchConditionVo.setParentsGenreName("ALL");
		}
		
		model.addAttribute("itemList", productInfoListVo.getItems());
		model.addAttribute("genreName", searchConditionVo.getGenreName());
		model.addAttribute("parentsGenreName", searchConditionVo.getParentsGenreName());
		model.addAttribute("currentPage", searchConditionVo.getPage());
		model.addAttribute("count", productInfoListVo.getCount());
		model.addAttribute("pageCount", productInfoListVo.getPageCount());

		return "product_list";
	}
}
