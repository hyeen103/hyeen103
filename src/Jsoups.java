/**
 * YOU ARE STRICTLY PROHIBITED TO COPY, DISCLOSE, DISTRIBUTE, MODIFY OR USE THIS PROGRAM
 * IN PART OR AS A WHOLE WITHOUT THE PRIOR WRITTEN CONSENT OF HIMEDIA.CO.KR.
 * HIMEDIA.CO.KR OWNS THE INTELLECTUAL PROPERTY RIGHTS IN AND TO THIS PROGRAM.
 * COPYRIGHT (C) 2024 HIMEDIA.CO.KR ALL RIGHTS RESERVED.
 *
 * 하기 프로그램에 대한 저작권을 포함한 지적재산권은 himedia.co.kr에 있으며,
 * himedia.co.kr이 명시적으로 허용하지 않는 사용, 복사, 변경 및 제 3자에 의한 공개, 배포는 엄격히 금지되며
 * himedia.co.kr의 지적재산권 침해에 해당된다.
 * Copyright (C) 2024 himedia.co.kr All Rights Reserved.
 *
 *
 * Program		: kr.co.himedia.sn.ecommerce5th.moon
 * Description	:
 * Environment	: JRE 1.7 or more
 * File			: Jsoups.java
 * Notes		:
 * History		: [NO][Programmer][Description]
 *				: [20240112115138][pluto@himedia.co.kr][CREATE: Initial Release]
 */

/**
 * @version 1.0.0
 * @author pluto@himedia.co.kr
 * 
 * @since 2024-01-12
 * <p>DESCRIPTION:</p>
 * <p>IMPORTANT:</p>
 */

import java.io.IOException;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@SuppressWarnings("unused")
public class Jsoups {

	public static void main(String[] args) {
		
		System.out.println("============================================================");
		
		try {
			String url	= "https://www.hamsoop.com/goods/goods_list.php?cateCd=012001";
			// String url	= "http://www.animalls.co.kr/shop/shopbrand.html?type=X&xcode=002";
			// String url	= "https://www.dogpang.com/product/N000011698";
			// String url	= "https://www.oliveyoung.co.kr/store/goods/getGoodsDetail.do?goodsNo=A000000178142&t_page=%ED%86%B5%ED%95%A9%EA%B2%80%EC%83%89%EA%B2%B0%EA%B3%BC%ED%8E%98%EC%9D%B4%EC%A7%80&t_click=%EA%B2%80%EC%83%89%EC%83%81%ED%92%88%EC%83%81%EC%84%B8&t_search_name=%EC%B9%9C%ED%99%98%EA%B2%BD&t_number=2&dispCatNo=1000001000400080001&trackingCd=Result_2";
			// String url		= "https://zoonimal.co.kr/product/list.html?cate_no=338";
			
			Document doc	= null;
			
			doc = Jsoup.connect(url).get();
			/*
			CGV
			
			Elements element = doc.select("div .sect-movie-chart");
			Iterator<Element> ie1 = element.select("strong .rank").iterator();
			Iterator<Element> ie2 = element.select("strong .title").iterator();
			while (ie1.hasNext()) {
				System.out.println(ie1.next().text() + "\t" + ie2.next().text());
			}
			*/
			
			// Animal
			/*
			Elements element = doc.select("li .item_list");
			Iterator<Element> ie1 = element.select("p .prdname").iterator();
			Iterator<Element> ie2 = element.select("span .price").iterator();
			while (ie1.hasNext()) {
				System.out.println(ie1.next().text() + "\t" + ie2.next().text());
			}
			*/
			
			// Dogpang
			/*
			Elements element = doc.select("div #location");
			System.out.println(element.get(0).text());
			
			element = doc.select("h2 #viewName");
			System.out.println(element.get(0).text());
					
			element = doc.select("#contents > div.photo-sell-wrap > div.sell-wrap > div.price-info.view_price_first > dl:nth-child(2) > dd > strong");
			System.out.println(element.get(0).text());
			*/
			
			// Oliveyoung
			// System.out.println(doc.html());
			// System.out.println(doc.text());
			/*
			Elements element = doc.select("#prd_thumb_list");
			Iterator<Element> ie1 = element.select("li").iterator();
			Iterator<Element> ie2 = element.select("li").iterator();
			
			while (ie1.hasNext()) {
				// System.out.println(ie1.next());
				System.out.println("[원본]" + ie1.next().select("a").attr("data-img") + "\t\t[썸네일]" + ie2.next().select("img").attr("src"));
			}
			*/
			
			// Zoonimal
			// System.out.println(doc.html());
			// System.out.println(doc.text());
			
			Elements element = doc.select("ul.prdList");
			// System.out.println(element.html());
			Iterator<Element> ieCount	= element.select("div.description > ul").iterator();
			
			Iterator<Element> ie1	= element.select("p.name > a").iterator();
			Iterator<Element> ie2	= element.select("div.description").iterator();
			
			
			while (ie1.hasNext()) {
				
				Elements countLi	= ieCount.next().select("li");
				Elements listLi		= ie2.next().select("ul");
				
				System.out.println(countLi.size());
				// 상품명 + 판매가
				if (countLi.size() == 3) {
					System.out.println("[상품]"		+ ie1.next().select("span:nth-child(2)").text());
					System.out.println("[판매가]"	+ listLi.select("li:nth-child(1)").text());
					
				}
				// 1. 상품명 2. 설명 or 소비자가 3. 판매가
				else if (countLi.size() == 4) {
					System.out.println("[상품]"				+ ie1.next().select("span:nth-child(2)").text());
					System.out.println("[설명 or 소비자가]"	+ listLi.select("li:nth-child(1)").text());
					System.out.println("[판매가]"			+ listLi.select("li:nth-child(2)").text());
				}
				// 1. 상품명 2. 설명 3. 소비자가 4. 할인가
				else if (countLi.size() == 5) {
					System.out.println("[상품]"				+ ie1.next().select("span:nth-child(2)").text());
					System.out.println("[설명]"				+ listLi.select("li:nth-child(1)").text());
					System.out.println("[소비자가]"			+ listLi.select("li:nth-child(2)").text());
					System.out.println("[판매가]"			+ listLi.select("li:nth-child(3)").text());
				}
				else {
					System.out.println("[상품]"				+ ie1.next().select("span:nth-child(2)").text());
					System.out.println("XXX");
				}
				System.out.println();
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("============================================================");
		
	}
}
