package com.jjh.tddpractice;

import com.jjh.tddpractice.domain.Study;
import org.junit.jupiter.api.*;

import java.time.Duration;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("신규 Study 생성")
    @Tag("study")
    void create_new_test() {
        Study study = new Study();
        assertNotNull(study);


        assertAll(
                //왼쪽 -> 기댓값, 오른쪽 -> 실제값
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디 처음 생성 시 DRAFT 상태여야한다"),

                //() -> assertThrows(IllegalAccessError.class, () -> new Study(-10)),

                //assertTrue(1>2);
                () -> assertTrue(study.getLimit() > 0, () -> "참석인원은 0 보다 커야한다")
        );

        //assertTimeout(Duration.ofMillis(100),() -> {new Study(-100); Thread.sleep(100);});

    }

    @Test
    //테스트 비활성화
    @Disabled
    void create1() {
        System.out.println("create");
    }

    //반복 테스트
    @DisplayName("반복 스터디 횟수")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}")
    void repeatTest(RepetitionInfo repetitionInfo){


        System.out.println("repeat Test" + repetitionInfo.getCurrentRepetition());

    }

    //
    @ParameterizedTest
    @ValueSource(strings ={"test1","test2"})
    @EmptySource
    @NullSource
    void parameterizedTest(String message){
        System.out.println(message);
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