package cn.qm.controller;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.qm.pojo.BaseDict;
import cn.qm.pojo.Customer;
import cn.qm.pojo.QueryVo;
import cn.qm.service.BaseDictService;
import cn.qm.service.CustomerService;
import cn.qm.util.Page;

@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService dictService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("list")
	public String list(Model model,QueryVo queryVo){
		
		try {
	        // 解决get请求乱码问题
	        if (StringUtils.isNotBlank(queryVo.getCustName())) {
	            queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		//查詢顯示條件
		List<BaseDict> fromType = dictService.getBaseDictsByCode("002");
		List<BaseDict> industryType = dictService.getBaseDictsByCode("001");
		List<BaseDict> levelType = dictService.getBaseDictsByCode("006");
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		Page<Customer> page = customerService.getCustomerByQueryVo(queryVo);
		model.addAttribute("page", page);
		model.addAttribute("vo", queryVo);
		System.out.println(queryVo.getCustName());
		System.out.println(queryVo.getCustSource());
		/*// 数据回显
	    model.addAttribute("custName", queryVo.getCustName());
	    model.addAttribute("custSource", queryVo.getCustSource());
	    model.addAttribute("custIndustry", queryVo.getCustIndustry());
	    model.addAttribute("custLevel", queryVo.getCustLevel());*/
		return "customer";
	}

	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Integer id){
		Customer customer = customerService.selectById(id);
		return customer;
	}
	/**
	 * 根据id查询用户,返回更新后客户的json格式数据
	 * 
	 * @param customer
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public String updateCustomerById(Customer customer) {
	  customerService.updateCustomerById(customer);
	    return "OK";
	}
	@RequestMapping("delete")
	@ResponseBody
	public String deleteCustomerById(Long id) {
	    this.customerService.deleteCustomerById(id);
	    return "ok";
}
}