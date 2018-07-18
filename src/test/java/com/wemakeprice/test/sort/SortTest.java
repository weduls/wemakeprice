package com.wemakeprice.test.sort;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import com.wemakeprice.test.dto.NoEnglishAndNumberException;
import com.wemakeprice.test.service.SortService;
import com.wemakeprice.test.serviceImpl.SortServiceImpl;

import static org.junit.Assert.assertThat;

public class SortTest {
	
	private SortService sortServiceImpl;
	
	@Before
	public void setup() throws Exception {
		sortServiceImpl = new SortServiceImpl();
	}
	
	/**
	 * 영어 숫자가 아닌경우 테스트
	 */
	@Test
	public void givenNonEngNum_thenThrowNoEngNumEx() {
		assertNoEngNumEx("a0b a12");
		assertNoEngNumEx("a0ba-12 ");
		assertNoEngNumEx("aㅇㄹ0ba12");
	}
	
	/**
	 * 입력값이 null인경우 테스트
	 */
	@Test
	public void givenIllegalArgu_thenThrowIllegalArgEx() {
		assertIllegalArgEx("");
		assertIllegalArgEx(null);
	}
	
	/**
	 * 유효한 값일때 정렬 성공여부 확인
	 */
	@Test
	public void whenValidParameter_thenSuccessSortStr() {
		assertThat(sortServiceImpl.sort("ad1124"), is("a1d124"));
		assertThat(sortServiceImpl.sort("111"), is("111"));
		assertThat(sortServiceImpl.sort("dbza"), is("abdz"));
		assertThat(sortServiceImpl.sort("vzdq"), is("dqvz"));
	}
	
	/**
	 * 유효한 값일때 정렬 실패여부 확인
	 */
	@Test
	public void whenValidParameter_thenFailSortStr() {
		assertThat(sortServiceImpl.sort("afcd11"), not("afcd11"));
		assertThat(sortServiceImpl.sort("afcd11"), not("fasd"));
		assertThat(sortServiceImpl.sort("afcd11"), not("dcfa11"));
		assertThat(sortServiceImpl.sort("afcd11"), not("fwdzf"));
		assertThat(sortServiceImpl.sort("dkljl"), not("fwdzf"));
	}
	
	private void assertIllegalArgEx(String str) {
		assertExceptionThrown(str, IllegalArgumentException.class);
	}
	
	private void assertNoEngNumEx(String str) {
        assertExceptionThrown(str, NoEnglishAndNumberException.class);
    }
	
	private void assertExceptionThrown(String str, Class<? extends RuntimeException> exception) {
		Exception thrownEx = null;
		try {
			sortServiceImpl.sort(str);
		} catch (Exception e) {
			thrownEx = e;
		}
		assertThat(thrownEx, instanceOf(exception));
	}

}
