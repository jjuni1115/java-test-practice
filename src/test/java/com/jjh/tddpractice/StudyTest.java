package com.jjh.tddpractice;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("신규 Study 생성")
    void create_new_test(){
        Study study = new Study();
        assertNotNull(study);

    }

    @Test
    //테스트 비활성화
    @Disabled
    void create1(){
        System.out.println("create");
    }


    //전체 테스트 시작 전
    @BeforeAll
    static void beforeAll(){

        System.out.println("before");

    }

    //전체 테스트 종료 후
    @AfterAll
    static void afterAll(){
        System.out.println("after");
    }


    //각 테스트 시작 전
    @BeforeEach
    void beforeEach(){
        System.out.println("before Each");
    }

    //각 테스트 종료 후
    @AfterEach
    void afterEach(){
        System.out.println("after Each");
    }


}