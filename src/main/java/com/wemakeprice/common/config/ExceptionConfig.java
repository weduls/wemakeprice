package com.wemakeprice.common.config;

import java.util.HashMap;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wemakeprice.common.dto.EnumResultType;
import com.wemakeprice.test.dto.NoEnglishAndNumberException;


/**
 * 에러 유형을 나타내는 Config
 * 
 * @author Jung Chul
 * @Date 2018. 07. 18
 */
@ControllerAdvice
public class ExceptionConfig {

	@ExceptionHandler({Exception.class})
	@ResponseBody
	public HashMap<String, Object> errorHandler(Exception ex) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", EnumResultType.FAIL);
		map.put("errMsg", makeErrorCode(ex));

		return map;
	}

	/**
	 * Error code 만들기
	 *
	 * @date 2018. 7. 18.
	 * @author Jung Chul
	 * @return String
	 */
	private String makeErrorCode(Exception ex) {
		if (ex instanceof NoEnglishAndNumberException) {
			return "NoEnglishAndNumberException";
		} else if (ex instanceof IllegalArgumentException) {
			return "IllegalArgumentException";
		} else {
			return "ElseException";
		}
	}
}
