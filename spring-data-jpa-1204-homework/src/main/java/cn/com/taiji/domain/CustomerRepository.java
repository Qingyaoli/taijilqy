package cn.com.taiji.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface CustomerRepository extends JpaRepository<Customer, Integer> ,JpaSpecificationExecutor<Customer> {

    /*@Override
    <S extends Customer> Iterable<S> save(Iterable<S> iterable);*/
    Customer findByName(String name);
    
    /**
	 * 查询所有
	 * @return
	 */
	@Query("select c from Customer c")
	List<Customer> findAllCustomers();
	
	@Query("select c from Customer c where c.id=:id")
	Customer findById(@Param("id") Integer id);	
	
	/**
	 * 标记为删除 age = 0
	 * @param id
	 */
	@Modifying
	@Query("update Customer c set c.age=0 where c.id=:id")
	void updateFlag(@Param("id") String id);

}
