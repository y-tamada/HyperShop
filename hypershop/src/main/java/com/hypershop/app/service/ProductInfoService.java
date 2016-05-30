package com.hypershop.app.service;

import java.util.Locale;

import org.springframework.stereotype.Service;

import com.hypershop.app.vo.ProductInfoListVo;
import com.hypershop.app.vo.SearchConditionVo;

@Service
public interface ProductInfoService {

	public ProductInfoListVo getProductInfo(Locale locale, SearchConditionVo searchConditionVo);
}
