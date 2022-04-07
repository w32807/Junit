package com.spring.test;

import com.spring.testTag.FastTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.WINDOWS;
import static org.junit.jupiter.params.provider.Arguments.*;

public class StudentAdvancedTest {

    @Test
    @DisplayName("Enable OS 테스트")
    @EnabledOnOs({WINDOWS, LINUX})
    public void enableOs() throws Exception {
        // given
        Student student = new Student();
        // when
        // then
        assertThat(student).isNotNull();
    }

    @Test
    @DisplayName("Java Version 테스트")
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
    public void enableJre() throws Exception {
        // given
        Student student = new Student();
        // when
        // then
        assertThat(student).isNotNull();
    }

    @Test
    @DisplayName("커스텀 태그 테스트")
    @FastTest
    public void customTag() throws Exception{
        // given
        Student student = new Student();
        // when
        // then
        assertThat(student).isNotNull();
    }

    @RepeatedTest(10)
    @DisplayName("반복 테스트")
    public void repeatTest1(RepetitionInfo info) throws Exception{
        System.out.println("test "+ info.getCurrentRepetition() + "/"
                + info.getTotalRepetitions());
    }

    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("반복 테스트")
    public void repeatTest2(RepetitionInfo info) throws Exception{
        System.out.println("test "+ info.getCurrentRepetition() + "/"
                + info.getTotalRepetitions());
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C"})
    @DisplayName("파라미터를 받아 테스트하기")
    public void repeatTest3(String message) throws Exception{
        System.out.println(message);
    }

    @ParameterizedTest
    @MethodSource("parameterProvider") // 파라미터가 1개인 테스트에 사용
    @DisplayName("파라미터를 받아 테스트하기")
    public void repeatTest4(Student student, String message) throws Exception{
        System.out.println(student);
        System.out.println(message);
    }

    static Stream<Arguments> parameterProvider(){
        return Stream.of(
            // 파라미터 1세트씩 작성
            // 파라미터 수가 달라도, 받을 수 있는 것만 받는다.
            arguments(new Student(), "1번 째 학생"),
            arguments(new Student("admin", 10), "2번 째 학생")
        );
    }
}
