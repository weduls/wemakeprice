package com.wemakeprice.test.serviceImpl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.wemakeprice.common.util.CommonUtil;
import com.wemakeprice.test.dto.NoEnglishAndNumberException;
import com.wemakeprice.test.service.SortService;

/**
 * 정렬을 진행하는 서비스 구현체
 * 
 * @author Jung Chul
 *
 */
@Service("SortService")
public class SortServiceImpl implements SortService {

	@Override
	public String sort(String str) {
		// validate 확인
		validate(str);
		
		StringBuilder characterStringBuilder = new StringBuilder();
		StringBuilder numberStringBuilder = new StringBuilder();

		for (char ch : str.toCharArray()) {
			if (CommonUtil.isCheckAlpha(ch)) {
				characterStringBuilder.append(ch);
			} else {
				numberStringBuilder.append(ch);
			}
		}
		
		char[] charArray = characterStringBuilder.toString().toCharArray();
		char[] numArray = numberStringBuilder.toString().toCharArray();
		
		// 문자 배열이 있는 경우에만 정렬을 수행
		if(characterStringBuilder.length() > 0) {
			CommonUtil.recursiveQuickSort(charArray, 0, charArray.length - 1);
		}
		
		// 숫자 배열이 있는 경우에만 정렬을 수행
		if(numberStringBuilder.length() > 0) {
			CommonUtil.recursiveQuickSort(numArray, 0, numArray.length - 1);
		}
		
		return printResult(charArray, numArray);
	}
	
	/**
	 * 정렬된 두 개의 항목을 합쳐서 출력 
	 * 
	 * @param charArray
	 * @param numArray
	 * @return
	 */
	private String printResult(char[] charArray, char[] numArray) {
		StringBuilder result = new StringBuilder();
		
		int charArraySize = charArray.length;
		int numArraySize = numArray.length;
		
		for (int i = 0; i < (charArraySize > numArraySize ? charArraySize : numArraySize); i++) {
			// 문자열 인덱스가 있는 경우에만 문자열 더하기
			if (charArraySize - 1 >= i) {
				result.append(charArray[i]);
			}
			
			// 숫자 인덱스가 있는경우에 숫자 인덱스 더하기
			if (numArraySize - 1 >= i) {
				result.append(numArray[i]);
			}
		}
		
		return result.toString();
	}
	
	/**
	 * validate
	 * 
	 * @param str
	 */
	private void validate(String str) {
        if (StringUtils.isBlank(str)) {
            throw new IllegalArgumentException();
        } else if (!CommonUtil.checkEnglishAndNumber(str)) {
        	throw new NoEnglishAndNumberException();
        }
    }

}
