package com.hypershop.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hypershop.app.service.ProductInfoService;
import com.hypershop.app.vo.GenreWrapperVo;
import com.hypershop.app.vo.ProductInfoListVo;
import com.hypershop.app.vo.SearchConditionVo;

@Service
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProductInfoServiceImpl implements ProductInfoService{
	
	//ログ
	private static final Logger logger = LoggerFactory.getLogger(ProductInfoServiceImpl.class);
	
	private static final String DEVELOPER_ID = "1048080648711546146";
	private static final String AFFILIATE_ID = "14f3b44a.135864d6.14f3b44b.88c14e37";
	private static final int PAGE_NUM = 12;

	@Override
	public ProductInfoListVo getProductInfo(Locale locale, SearchConditionVo searchConditionVo) {

		ProductInfoListVo productInfoVo = null;
		
		try{
			// 楽天商品検索
			productInfoVo = this.getRakutenProductInfo(searchConditionVo);
			
//			for(ItemVo target : productInfoVo.getItems()){
//				target.setGenreName(this.getRakutenGenreName(target.getGenreId()));
//			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return productInfoVo;
	}

	
	/**
	 * 
	 * @param searchConditionVo
	 * @return
	 * @throws Exception
	 */
	public ProductInfoListVo getRakutenProductInfo(SearchConditionVo searchConditionVo) throws Exception{

		ProductInfoListVo productInfoVo = null;
		// 取得したい項目のカンマ区切り文字列
		String elements = "affiliateUrl,mediumImageUrls,smallImageUrls,itemName,shopName,itemPrice,taxFlag,genreId,reviewAverage,pageCount,count";
		
		try{
			// URL作成
			StringBuilder requestPath = new StringBuilder("https://app.rakuten.co.jp/services/api/IchibaItem/Search/20140222?format=json");
			// キーワード
			if(StringUtils.isNotBlank(searchConditionVo.getKeyword())){
				requestPath.append("&keyword=" + searchConditionVo.getKeyword());
			}
			// ジャンルID
			if(StringUtils.isNotBlank(searchConditionVo.getGenreId())){
				requestPath.append("&genreId=" + searchConditionVo.getGenreId());
			}
			// 検索件数
			requestPath.append("&hits=" + Integer.toString(PAGE_NUM))
			// 取得するページページ
			.append("&page=" + searchConditionVo.getPage())
			// 取得項目
			.append("&elements=" + elements)
			// フォーマットバージョン
			.append("&formatVersion=2")
			// イメージフラグ イメージが存在するもののみ検索
			.append("&imageFlag=1")
			// 販売可能商品のみ
			.append("&availability=1")
			// アプリID
			.append("&applicationId=" + DEVELOPER_ID)
			// アフィリエイトID
			.append("&affiliateId=" + AFFILIATE_ID);

			// リクエスト送信
			AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
			ListenableFuture<ResponseEntity<String>> future = asyncRestTemplate.getForEntity(requestPath.toString(), String.class);

			String json = future.get().getBody()
					.replaceAll("Item", "item")
					.replaceAll("GenreInformation", "genreInformation")
					.replaceAll("TagInformation", "tagInformation");

			ObjectMapper mapper = new ObjectMapper();
			productInfoVo = mapper.readValue(json, ProductInfoListVo.class);

		} catch (Exception e) {
			logger.error("can't get rakuten product !!!");
			throw e;
		}
		
		return productInfoVo;
	}				
	
	
	/**
	 *  楽天商品に紐づくジャンル名を取得する
	 *  @param genreId
	 *  @return genreName
	 */
	public String getRakutenGenreName(String genreId) throws Exception{
		// ジャンルIDが空の場合はから文字を返す
		if(StringUtils.isBlank(genreId)) return "";
		
		StringBuilder out = new StringBuilder();
		BufferedReader reader = null;
		String genreName = genreId;
		
		// 取得したい項目のカンマ区切り文字列
		String elements = "current";
		
		try {
			// URL作成
			StringBuilder requestPath = new StringBuilder("https://app.rakuten.co.jp/services/api/IchibaGenre/Search/20140222?format=json")
					// ジャンルID
					.append("&genreId=" + genreId)
					//
					.append("&genrePath=0")
					//
					.append("&formatVersion=2")
					// 取得項目
					.append("&elements=" + elements)
					// アプリID
					.append("&applicationId=" + DEVELOPER_ID);

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

			String json = out.toString();
			
			ObjectMapper mapper = new ObjectMapper();
			GenreWrapperVo genreWrapperVo = mapper.readValue(json, GenreWrapperVo.class);
			
			genreName = genreWrapperVo.getCurrent().getGenreName();
			
		} catch (Exception e) {
			logger.error("can't get rakuten genre !!!");
			throw e;
		}finally {
			// reader close
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return genreName;
		
	}

}
