package cn.qm.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qm.dao.CustomerMapper;
import cn.qm.pojo.Customer;
import cn.qm.pojo.QueryVo;
import cn.qm.service.CustomerService;
import cn.qm.util.Page;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	public CustomerMapper customerMapper;
	@SuppressWarnings("rawtypes")
	@Override
	public Page getCustomerByQueryVo(QueryVo vo) {
		
		vo.setStart((vo.getPage()-1)*vo.getRows());
		/*System.out.println(vo.getStart());
		System.out.println(vo.getPage()+"***"+vo.getRows());*/
		List<Customer> list = customerMapper.getCustomerByQueryVo(vo);
		System.out.println(list.size()+"////////");
		Integer total = customerMapper.getCountByVo(vo);
		/*System.out.println("*****"+total);*/
		System.out.println(total);
		Page<Customer> page = new Page<Customer>(total, vo.getPage(), vo.getRows(),list);
		return page;
	}
	@Override
	public Customer selectById(Integer id) {
		
		return customerMapper.selectById(id);
	}
	@Override
	public void updateCustomerById(Customer customer) {
		this.customerMapper.updateCustomerById(customer);
	}
	/**
	 * 根据ID删除客户
	 */
	@Override
	public void deleteCustomerById(Long id) {
		customerMapper.deleteCustomerById(id);
		
	}

}
