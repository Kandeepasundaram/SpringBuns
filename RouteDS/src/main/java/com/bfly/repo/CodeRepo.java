/**
 * 
 */
package com.bfly.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfly.domain.Code;

/**
 * @author ksg
 *
 */
public interface CodeRepo extends JpaRepository<Code, Long> {

}
