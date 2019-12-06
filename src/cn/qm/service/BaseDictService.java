package cn.qm.service;

import java.util.List;

import cn.qm.pojo.BaseDict;

public interface BaseDictService {
	
	 List<BaseDict> getBaseDictsByCode(String code);
}
