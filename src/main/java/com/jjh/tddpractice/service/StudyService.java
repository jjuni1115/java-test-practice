package com.jjh.tddpractice.service;

import com.jjh.tddpractice.domain.Member;
import com.jjh.tddpractice.domain.Study;
import com.jjh.tddpractice.repository.StudyRepository;

public class StudyService {

    private final StudyRepository studyRepository;
    private final MemberService memberService;


    public StudyService(MemberService memberService, StudyRepository studyRepository){
        this.memberService=memberService;
        this.studyRepository=studyRepository;
    }


    public Study createStudy(Long memberId,Study study){


        Member member = memberService.findById(memberId).orElseThrow(() -> new IllegalArgumentException());

        study.setMember(member);




        Study studyEntity = studyRepository.save(study);

        memberService.notify(studyEntity);

        return study;


    }

    public Study openStudy(Study study){

        study.open();
        Study openStudy = studyRepository.save(study);
        memberService.notify(study);
        return openStudy;


    }


}
