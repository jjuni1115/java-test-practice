package com.jjh.tddpractice.service;

import com.jjh.tddpractice.domain.Member;
import com.jjh.tddpractice.domain.Study;
import com.jjh.tddpractice.repository.StudyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.BDDMockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    StudyRepository studyRepository;

    @Mock
    MemberService memberService;

    StudyService studyService;



    @Test
    @DisplayName("Study Service 생성")
    void createStudyService(){


        //given
        Member member = new Member();
        member.setId(1L);
        member.setEmail("test@naver.com");
        member.setName("testNAme");

        Study study = new Study();


        //메소드 mocking
        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);





        //when
        studyService.createStudy(1L,study);


        //then
        assertNotNull(study.getMember());
        assertEquals(member,study.getMember());

        //호출된 횟수 체크
        verify(memberService, times(1)).notify(study);

        then(memberService).should(times(1)).notify(study);

        verify(memberService,never()).verify();



    }

    @Test
    @DisplayName("스터디 오픈 테스트")
    void openStudyTest(){

        //given
        Study study = new Study();
        study.setOpenYn(false);

        given(studyRepository.save(study)).willReturn(study);


        //when
        studyService.openStudy(study);



        //then

        assertEquals(true,study.getOpenYn());

        then(memberService).should().notify(study);





    }

    @BeforeEach
    void studySetting(){


        studyService = new StudyService(memberService,studyRepository);

    }


}