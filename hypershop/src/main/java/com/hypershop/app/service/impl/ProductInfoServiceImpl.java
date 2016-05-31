package com.hypershop.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hypershop.app.service.ProductInfoService;
import com.hypershop.app.vo.ProductInfoListVo;
import com.hypershop.app.vo.SearchConditionVo;

@Service
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProductInfoServiceImpl implements ProductInfoService{
	
	private static final String DEVELOPER_ID = "1048080648711546146";
	private static final String AFFILIATE_ID = "14f3b44a.135864d6.14f3b44b.88c14e37";

	@Override
	public ProductInfoListVo getProductInfo(Locale locale, SearchConditionVo searchConditionVo) {

		StringBuilder out = new StringBuilder();
		BufferedReader reader = null;
		ProductInfoListVo productInfoVo = null;

		try{
			// URL作成
			StringBuilder requestPath = new StringBuilder("https://app.rakuten.co.jp/services/api/IchibaItem/Search/20140222?format=json");
			// キーワード
			if(StringUtils.isNotBlank(searchConditionVo.getKeyword())){
				requestPath.append("&keyword=" + URLEncoder.encode(searchConditionVo.getKeyword(), "UTF-8"));
			}
			// ジャンルID
			if(StringUtils.isNotBlank(searchConditionVo.getGenreId())){
				requestPath.append("&genreId=" + URLEncoder.encode(searchConditionVo.getGenreId(), "UTF-8"));
			}
			// アプリID
			requestPath.append("&applicationId=" + DEVELOPER_ID);
			// アフィリエイトID
			requestPath.append("&affiliateId=" + AFFILIATE_ID);

			// リクエスト送信
			URL requestUrl = new URL(requestPath.toString());
			HttpURLConnection connection = (HttpURLConnection)requestUrl.openConnection();
			InputStream input = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));

			// 結果の書き出し
			String line;
			while ((line = reader.readLine()) != null) {
				out.append(line);
			}
			
			String json = out.toString()
					.replaceAll("Item", "item")
					.replaceAll("GenreInformation", "genreInformation")
					.replaceAll("TagInformation", "tagInformation");
			
			ObjectMapper mapper = new ObjectMapper();
			productInfoVo = mapper.readValue(json, ProductInfoListVo.class);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// reader
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return productInfoVo;
	}

}
