/**
 * 
 */
package com.project.constructo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.constructo.model.FlatOwner;
import com.project.constructo.model.VisitBook;

/**
 * @author Harshad
 *
 */
public interface VisitBookRepo extends JpaRepository<VisitBook, Long> {

}
