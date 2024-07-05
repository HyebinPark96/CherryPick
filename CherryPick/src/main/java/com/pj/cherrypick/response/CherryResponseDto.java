package com.pj.cherrypick.response;

import java.util.List;

import com.pj.cherrypick.domain.CafeVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CherryResponseDto<T> {
		int status;
		T data; 
}
