package com.wemakeprice.test.dto;

/**
 * 숫자와 영어가 아닐때 발생하는 Unchecked Exception
 * 
 * @author Jung Chul
 *
 */
public class NoEnglishAndNumberException extends RuntimeException {
	
	private static final long serialVersionUID = -6192226734561025047L;

	public NoEnglishAndNumberException() {
		super("NoEnglishAndNumberException");
	}
}
