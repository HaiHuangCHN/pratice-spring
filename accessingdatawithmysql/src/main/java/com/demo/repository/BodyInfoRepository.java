package com.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.BodyInfo;

@Repository
public interface BodyInfoRepository extends CrudRepository<BodyInfo, Integer> {

//	List<BodyInfo> findByBodyId(int bodyId);

}
