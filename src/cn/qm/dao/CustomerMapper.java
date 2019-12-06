package cn.qm.dao;

import java.util.List;

import com.alibaba.druid.support.logging.Log;

import cn.qm.pojo.Customer;
import cn.qm.pojo.QueryVo;

public interface CustomerMapper {
	
	 Integer getCountByVo(QueryVo vo);

	 List<Customer> getCustomerByQueryVo(QueryVo vo);

	 Customer selectById(Integer id);
	/**
	 * 根据id编辑客户
	 * 
	 * @param customer
	 */
	void updateCustomerById(Customer customer);
	/**
	 * 根据ID删除客户
	 */
	void deleteCustomerById(Long id);
}
