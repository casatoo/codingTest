package com.KMS.java.codingTest.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultData<DT> {

	private int total_item_count;
	private Object list;
	
	public ResultData(int total_item_count, Object list, Object... args) {
		this.total_item_count = total_item_count;
		this.list = list;
	}
	
	
	public static <DT> ResultData<DT> from(int total_item_count, Object list) {
		ResultData<DT> rd = new ResultData<DT>();
		rd.total_item_count = total_item_count;
		rd.list = list;

		return rd;
	}
	
}

