/**
 * YOU ARE STRICTLY PROHIBITED TO COPY, DISCLOSE, DISTRIBUTE, MODIFY OR USE THIS PROGRAM
 * IN PART OR AS A WHOLE WITHOUT THE PRIOR WRITTEN CONSENT OF HIMEDIA.CO.KR.
 * HIMEDIA.CO.KR OWNS THE INTELLECTUAL PROPERTY RIGHTS IN AND TO THIS PROGRAM.
 * COPYRIGHT (C) 2023 HIMEDIA.CO.KR ALL RIGHTS RESERVED.
 *
 * 하기 프로그램에 대한 저작권을 포함한 지적재산권은 himedia.co.kr에 있으며,
 * himedia.co.kr이 명시적으로 허용하지 않는 사용, 복사, 변경 및 제 3자에 의한 공개, 배포는 엄격히 금지되며
 * himedia.co.kr의 지적재산권 침해에 해당된다.
 * Copyright (C) 2023 himedia.co.kr All Rights Reserved.
 *
 *
 * Program		: kr.co.himedia.ecommerce
 * Description	:
 * Environment	: JRE 1.7 or more
 * File			: Xml.java
 * Notes		:
 * History		: [NO][Programmer][Description]
 *				: [20231201125054][pluto@himedia.co.kr][CREATE: Initial Release]
 */
package project.hyeen103.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * @version 1.0.0
 * @author pluto@himedia.co.kr
 * 
 * @since 2023-12-01
 * <p>DESCRIPTION:</p>
 * <p>IMPORTANT:</p>
 */
public class Xml {
	
	/**
	 * @param node [노드명]
	 * @return String
	 * @throws Exception [예외]
	 * 
	 * @since 2015-08-20
	 * <p>DESCRIPTION: 노드 값 얻기</p>
	 * <p>IMPORTANT: 파라미터는 데이터 타입과 형식을 만족하여야 한다.</p>
	 * <p>EXAMPLE:</p>
	 */
	public static String getNodeValue(Node node) throws Exception {

		if (node != null) {
			Node nodeCdata = node.getNextSibling();
			if ((nodeCdata != null) && (nodeCdata.getNodeType() == Node.CDATA_SECTION_NODE)) {
				return nodeCdata.getNodeValue();
			}
			else {
				// node.getTextContent().trim();
				return node.getNodeValue();
			}
		}
		return "";
	}
	
	/**
	 * @param filePath [경로 및 파일명]
	 * @return Document
	 * @throws Exception [예외]
	 * 
	 * @since 2015-08-20
	 * <p>DESCRIPTION: XML 파일 얻기</p>
	 * <p>IMPORTANT: 파라미터는 데이터 타입과 형식을 만족하여야 한다.</p>
	 * <p>EXAMPLE:</p>
	 */
	public static Document getXmlFromFile(String filePath) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		filePath = Strings.replace(filePath, "\\", "/");

		int isWindows = filePath.indexOf(":");

		if (isWindows != -1) {
			filePath = "/" + filePath;
		}

		Document document = builder.parse(filePath);

		return document;
	}
}
