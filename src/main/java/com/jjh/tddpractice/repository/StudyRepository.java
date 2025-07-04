package com.jjh.tddpractice.repository;

import com.jjh.tddpractice.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long> {
}
