package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    User findByUserName(String userName);
    
    User findByUserNameOrEmail(String username, String email);

    // 分页查询
//	List<User> findByUserName(String string, Pageable pageable);
//	List<User> findALL(Pageable pageable);

	// 限制查询
//	User findFirstByOrderByLastnameAsc();
//	User findTopByOrderByAgeDesc();
//	Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
//	List<User> findFirst10ByLastname(String lastname, Sort sort);
//	List<User> findTop10ByLastname(String lastname, Pageable pageable);
	
	// 自定义SQL查询
//	@Modifying
//	@Query("update User u set u.userName = ?1 where c.id = ?2")
//	int modifyByUserId(String userName, Long id);
	     
//	@Transactional
//	@Modifying
//	@Query("delete from User where id = ?1")
//	void deleteByUserId(Long id);
	   
//	@Transactional(timeout = 10)
//	@Query("select u from User u where u.emailAddress = ?1")
//    User findByEmailAddress(String emailAddress);
	
	// 多表查询。两种实现方式，第一种是利用hibernate的级联查询来实现，第二种是创建一个结果集的接口来接收连表查询后的结果
//	public interface HotelSummary {
//	    City getCity();
//	    String getName();
//	    Double getAverageRating();
//	    default Integer getAverageRatingRounded() {
//	        return getAverageRating() == null ? null : (int) Math.round(getAverageRating());
//	    }
//	}
	
//	@Query("select h.city as city, h.name as name, avg(r.rating) as averageRating "
//	        - "from Hotel h left outer join h.reviews r where h.city = ?1 group by h")
//	Page<HotelSummary> findByCity(City city, Pageable pageable);
//	 
//	@Query("select h.name as name, avg(r.rating) as averageRating "
//	        - "from Hotel h left outer join h.reviews r  group by h")
//	Page<HotelSummary> findByCity(Pageable pageable);
	
//	Page<HotelSummary> hotels = this.hotelRepository.findByCity(new PageRequest(0, 10, Direction.ASC, "name"));
//	for(HotelSummary summay:hotels){
//        System.out.println("Name" +summay.getName());
//    }
	
	
	
}
