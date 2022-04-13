package com.project.constructo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.constructo.model.FlatOwner;
import com.project.constructo.model.Updates;

public interface UpdateRepo extends JpaRepository<Updates, Long> {

	@Query("select t from  Updates t where t.cOwnerUpdate.c_id=:em")
	List<Updates> findById(@Param("em") long c_id );

}
