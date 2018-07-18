package com.wemakeprice.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wemakeprice.test.service.SortService;

/**
 * 정렬을 진행할 컨트롤러
 * 
 * @author Jung Chul
 *
 */
@RestController
public class SortCtrl {
	
	@Autowired
	SortService sortServiceImpl;

	/**
	 * 정렬 요청 컨트롤러
	 * 
	 * @param str
	 * @return
	 */
	@RequestMapping(value="/sort",  method = RequestMethod.POST)
	public ResponseEntity<?> sort(String str) {
		return ResponseEntity.ok(sortServiceImpl.sort(str));
	}
}
