package com.pj.cherrypick.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TempResponseDto<T> {
		int status;
		T data;
		int id; 
		//auto-increment key까지 받아오기 위해 만든 속성.
}
