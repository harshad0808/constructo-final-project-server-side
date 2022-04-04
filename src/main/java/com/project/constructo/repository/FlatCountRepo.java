package com.project.constructo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.constructo.model.FlatCount;

public interface FlatCountRepo extends JpaRepository<FlatCount, Long> {

}
