package cn.com.taiji.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.StringUtils;

import cn.com.taiji.domain.Customer;
import cn.com.taiji.domain.CustomerRepository;



@Service
public class CustomerService {
	
	@Inject
//	@Autowired
	CustomerRepository customerRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Customer> findall() {
		return customerRepository.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void saveCustomer(Customer customer) {
		this.customerRepository.saveAndFlush(customer);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Customer> findAllCustomers() {
		List<Customer> customers = this.customerRepository.findAllCustomers();

		System.out.println(customers.size() + "--------");
		return customers;
	}

	public Customer findCustomerById(int id) {

		Customer customer = this.customerRepository.findOne(id);
		return customer;
	}

	/*@Transactional(propagation = Propagation.SUPPORTS)
	public Map getPage(final Map searchParameters) {
		Map map = new HashMap();
		int page = 0;
		int pageSize = 10;
		Page<Customer> pageList;
		if (searchParameters != null && searchParameters.size() > 0 && searchParameters.get("page") != null) {
			page = Integer.parseInt(searchParameters.get("page").toString()) - 1;
		}
		if (searchParameters != null && searchParameters.size() > 0 && searchParameters.get("pageSize") != null) {
			pageSize = Integer.parseInt(searchParameters.get("pageSize").toString());
		}
		if (pageSize < 1)
			pageSize = 1;
		if (pageSize > 100)
			pageSize = 100;
		List<Map> orderMaps = (List<Map>) searchParameters.get("sort");
		List<Order> orders = new ArrayList<Order>();
		if (orderMaps != null) {
			for (Map m : orderMaps) {
				if (m.get("field") == null)
					continue;
				String field = m.get("field").toString();
				if (!StringUtils.isNullOrEmpty(field)) {
					String dir = m.get("dir").toString();
					if ("DESC".equalsIgnoreCase(dir)) {
						orders.add(new Order(Direction.DESC, field));
					} else {
						orders.add(new Order(Direction.ASC, field));
					}
				}
			}
		}
		PageRequest pageable;
		if (orders.size() > 0) {
			pageable = new PageRequest(page, pageSize, new Sort(orders));
		} else {
			Sort sort = new Sort(Direction.ASC, "customerid");
			pageable = new PageRequest(page, pageSize, sort);
		}
		Map filter = (Map) searchParameters.get("filter");
		if (filter != null) {
			final List<Map> filters = (List<Map>) filter.get("filters");
			Specification<Customer> spec = new Specification<Customer>() {
				@Override
				public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> pl = new ArrayList<Predicate>();
					for (Map f : filters) {
						String field = f.get("field").toString().trim();
						String value = f.get("value").toString().trim();
						if (value != null && value.length() > 0) {
							if ("customerName".equalsIgnoreCase(field)) {
								pl.add(cb.like(root.<String>get(field), value + "%"));
							} else if ("".equalsIgnoreCase(field)) {
								pl.add(cb.like(root.<String>get(field), value + "%"));
							} 
						}

					}
					// 查询出未删除的
					pl.add(cb.equal(root.<Integer>get("age"), 1));
					return cb.and(pl.toArray(new Predicate[0]));
				}
			};
			pageList = CustomerRepository.findAll(spec, pageable);

		} else {
			Specification<Customer> spec = new Specification<Customer>() {
				public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					// 查询出未删除的
					list.add(cb.equal(root.<Integer>get("age"), 1));
					return cb.and(list.toArray(new Predicate[0]));
				}
			};
			pageList = CustomerRepository.findAll(spec, pageable);

		}
		map.put("total", pageList.getTotalElements());
		List<Customer> list = pageList.getContent();
		 
		map.put("customers", list);
		return map;
	}*/

	/*
	 * @Transactional(propagation = Propagation.REQUIRED) public void
	 * deleteCustomerByID(String[] CustomerIDs) { if (CustomerIDs != null &&
	 * CustomerIDs.length > 0) { for (String id : CustomerIDs) { if (id != null &&
	 * !"".equals(id)) { Customer customer = this.customerRepository.findOne(id); if
	 * (customer != null && customer.getChildren() != null &&
	 * customer.getChildren().size() > 0) { throw new
	 * BusinessException("该条记录下面含有子元素集合，不能删除！"); } // 标记为已删除-0,未删除-1
	 * this.customerRepository.updateFlag(id); } }
	 * 
	 * } }
	 */

}
