package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByUserId(int userId);

	@Query(value = "select * from user_20181126 where last_name = ?1 and first_name = ?2", nativeQuery = true)
	List<User> findByLastNameAndFirstName1(String lastName, String firstName);

	@Query(value = "select user_id, last_name from user_20181126 where last_name = ?1 and first_name = ?2", nativeQuery = true)
	List[] findByLastNameAndFirstName2(String lastName, String firstName);

	/**
	 * getByLastName1
	 * 
	 * @param lastname
	 * @return
	 */
	Iterable<User> findByLastname(String lastname);

	/*
	 * FYI:
	 * 
	 * @Query(value =
	 * "select * from user where last_name like %?1% order by first_name desc",
	 * nativeQuery = true)
	 */

	/**
	 * getByLastName2, JPQL
	 * 
	 * @param lastname
	 * @return
	 */
	@Query(value = "select a from User a where a.lastname = ?1 order by a.createdDate desc")
	public List<User> findByLastname2(String lastname);

	/**
	 * getByLastName3, SQL. We should add "nativeQuery = true"
	 * 
	 * @param lastname
	 * @return
	 */
	@Query(value = "select * from user_20181126 where lastname=:lastname", nativeQuery = true)
	public List<User> findByLastname3(@Param("lastname") String lastname);

	/**
	 * getByLastName4, SQL. like expression
	 * 
	 * @param lastname
	 * @return
	 */
	@Query(value = "select * from user_20181126 where lastname like CONCAT('%',:lastname,'%')", nativeQuery = true)
	public List<User> findByLastname4(@Param("lastname") String lastname);

	@Query(value = "select * from user_20181126 where username=:username and password=:password", nativeQuery = true)
	public List<User> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}