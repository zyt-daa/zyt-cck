package cn.qm.service;

import cn.qm.pojo.Customer;
import cn.qm.pojo.QueryVo;
import cn.qm.util.Page;

public interface CustomerService {

	@SuppressWarnings("rawtypes")
	 Page getCustomerByQueryVo(QueryVo queryVo);

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
