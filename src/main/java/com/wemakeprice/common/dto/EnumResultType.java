package com.wemakeprice.common.dto;

/**
 * 결과 타입을 나타내는  Enum 클래스
 * 
 * @author Jung Chul
 * @Date 2018. 07. 18
 */
public enum EnumResultType {
	SUCCESS(0), FAIL(1);

	private final int flag;

	private EnumResultType(int flag) {
		this.flag = flag;
	}

	public int getFalg() {
		return this.flag;
	}

}
