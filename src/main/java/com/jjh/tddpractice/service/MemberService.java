package com.jjh.tddpractice.service;

import com.jjh.tddpractice.domain.Member;
import com.jjh.tddpractice.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void notify(Study studyEntity);

    void verify();
}
