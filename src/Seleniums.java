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
 * File			: Seleniums.java
 * Notes		:
 * History		: [NO][Programmer][Description]
 *				: [20240116100957][pluto@himedia.co.kr][CREATE: Initial Release]
 */

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @version 1.0.0
 * @author pluto@himedia.co.kr
 * 
 * @since 2024-01-16
 * <p>DESCRIPTION:</p>
 * <p>IMPORTANT:</p>
 */
public class Seleniums {
	
	public static void main(String[] args) {
		
		// 파이어폭스 설정
		System.setProperty("webdriver.gecko.driver", "D:\\Business\\Eclipse\\kr.co.himedia.sn.ecommerce5th.localhost\\geckodriver.exe");
		
		try {
			// 파이어폭스 실행 및 최대화
			WebDriver webDriver = (WebDriver) new FirefoxDriver();
			webDriver.manage().window().maximize();
			
			// 로그인 페이지
			webDriver.get("http://192.168.0.41:8081/seller/login/loginForm.web");
			
			WebElement webElement = webDriver.findElement(By.id("id"));
			webElement.clear();
			webElement.sendKeys("venus");
			Thread.sleep(5000);
			
			webElement = webDriver.findElement(By.id("passwd"));
			webElement.clear();
			webElement.sendKeys("12345678");			
			Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor)webDriver;
			js.executeScript("checkLogin();");
			Thread.sleep(3000);
			// webElement.submit();
			
			// 확인 버튼
			Alert alert = webDriver.switchTo().alert();
			alert.accept();
			Thread.sleep(3000);
			
			// 판매
			webDriver.get("http://192.168.0.41:8081/seller/sale/list.web");
			List<WebElement> list = webDriver.findElements(By.cssSelector("#frmMain > section > article > table > tbody > tr:nth-child(1) > td:nth-child(2) > a"));
			
			System.out.println("size=" + list.size());
			for (int loop = 0; loop < list.size(); loop++ ) {
				System.out.println(list.get(loop).getAttribute("href"));
			}
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
