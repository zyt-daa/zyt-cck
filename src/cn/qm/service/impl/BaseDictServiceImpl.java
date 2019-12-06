package cn.qm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qm.dao.BaseDictMapper;
import cn.qm.pojo.BaseDict;
import cn.qm.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	
	@Autowired
	private BaseDictMapper baseDictMapper;
	@Override
	public List<BaseDict> getBaseDictsByCode(String code) {
		
		return baseDictMapper.getBaseDictsByCode(code);
	}

}
