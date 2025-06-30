package com.jjh.tddpractice;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.function.Supplier;
import org.junit.jupiter.api.Assumptions.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("신규 Study 생성")
    @Tag("study")
    void create_new_test() {
        Study study = new Study(10);
        assertNotNull(study);


        assertAll(
                //왼쪽 -> 기댓값, 오른쪽 -> 실제값
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디 처음 생성 시 DRAFT 상태여야한다"),

                () -> assertThrows(IllegalAccessError.class, () -> new Study(-10)),

                //assertTrue(1>2);
                () -> assertTrue(study.getLimit() > 0, () -> "참석인원은 0 보다 커야한다")
        );

        assertTimeout(Duration.ofMillis(100),() -> {new Study(-100); Thread.sleep(100);});

    }

    @Test
    //테스트 비활성화
    void create1() {
        System.out.println("create");
    }


    //전체 테스트 시작 전
    @BeforeAll
    static void beforeAll() {

        System.out.println("before");

    }

    //전체 테스트 종료 후
    @AfterAll
    static void afterAll() {
        System.out.println("after");
    }


    //각 테스트 시작 전
    @BeforeEach
    void beforeEach() {
        System.out.println("before Each");
    }

    //각 테스트 종료 후
    @AfterEach
    void afterEach() {
        System.out.println("after Each");
    }


}