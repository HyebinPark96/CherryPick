package com.pj.cherrypick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.mapper.TempCherryMapper;

@Service
public class TempCherryService {
	

	@Autowired
	private TempCherryMapper cherryMapper;
	
	//CherriesSevice로 옮길 것.
		@Transactional
		public int addCherry(ListVO list) {
			try {
				cherryMapper.addCherry(list);
				return 1;
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			return -1;
		}
}
