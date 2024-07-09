package com.pj.cherrypick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.mapper.CherriesMapper;

@Service
public class CherriesService {

	@Autowired
	private CherriesMapper cherriesMapper;

	public List<ListVO> getNewCherries() {
		return cherriesMapper.getNewCherries();
	}
}
