package com.wemakeprice.common.util;

/**
 * 유틸 클래스
 * 
 * @author Jung Chul
 *
 */
public final class CommonUtil {
	
	private CommonUtil() {}
	
	/**
	 * 영어와 숫자 체크
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean checkEnglishAndNumber(String str) {
		for (char ch : str.toCharArray()) {
			if ( !isCheckNum(ch) && !isCheckAlpha(ch) ) {
				return false;
			}
		}
	
		return true;
	}
	
	/**
	 * 숫자 체크
	 * 
	 * @param ch
	 * @return boolean
	 */
	public static boolean isCheckNum(char ch) {
		return '0' <= ch && ch <= '9';
	}
	
	/**
	 * 알파벳인지 확인 (대소문자포함)
	 * 
	 * @param ch
	 * @return boolean
	 */
	public static boolean isCheckAlpha(char ch) {
		return ('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z');
	}
	
	/**
	 * 매개변수로 주어진 값을 이용하여 퀵소트 정렬을 한다.
	 * 
	 * @param arr char[] 문자를 담고 있는 배열
	 * @param low int 인덱스 최소값
	 * @param high int 인덱스 최대값
	 */
	public static void recursiveQuickSort(char arr[], int low, int high) {
		if (low < high) {
			// 퀵 소트는 반씩 나누어서 정렬하기 때문에 나눌 부분 인덱스 값을 가져온다.
			int pi = partition(arr, low, high);

			// 재귀적으로 배열의 요소를 정렬한다.
			recursiveQuickSort(arr, low, pi - 1);
			recursiveQuickSort(arr, pi + 1, high);
		}
	}

	/**
	 * 배열에서 파티션(부분)으로 나눈 것을 매개변수로 받아서 각 위치마다 요소 값을 비교해가면서 변경(swap)한다.
	 * 
	 * @param arr char[]
	 * @param low int
	 * @param high int
	 * @return int
	 */
	private static int partition(char arr[], int low, int high) {
		char pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;

				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		char temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}
}
