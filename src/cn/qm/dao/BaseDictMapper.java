package cn.qm.dao;

import java.util.List;

import cn.qm.pojo.BaseDict;

public interface BaseDictMapper {
	
	List<BaseDict> getBaseDictsByCode(String code);

}
