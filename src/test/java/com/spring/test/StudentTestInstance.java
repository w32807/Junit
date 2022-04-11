package com.spring.test;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

// 테스트 클래스의 인스턴스는 기본적으로 테스트 1개가 실행 될 때마다 생성된다.
// 이는 테스트간의 의존성을 없애기 위한 전략이다.
// @BeforeAll, @AfterAll이 Static이어야 하는 이유 생각해보기!
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// 클래스 안에서 리소스를 공유하면서 통합테스트 할 때 사용가능
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentTestInstance {

    @Test
    @DisplayName("Create Student")
    @Order(1)
    public void createStudent() throws Exception{
        // given
        Student student = new Student();
        // when
        // then
        assertThat(student).isNotNull();
    }

    @Test
    @DisplayName("Modify Student")
    @Order(2)
    public void modifyStudent() throws Exception{
        // given
        Student student = new Student();
        // when
        student.setAge(10);
        // then
        assertThat(student.getAge()).isGreaterThan(0);
    }

}
