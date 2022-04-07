package com.spring.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.spring.test.Class.KOREAN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StudentTest {

    @Test
    @DisplayName("Student Null 체크")
    public void nullCheck() throws Exception {
        // given
        Student student = null;
        // when
        // then
        assertThat(student).isNull();
    }


    @Test
    @DisplayName("Student Not Null 체크")
    public void notNullChk() throws Exception{
        // given
        Student student = new Student();
        // when
        // then
        assertThat(student).isNotNull();
    }
    
    @Test
    @DisplayName("Student 이름 체크")
    public void nameCheck() throws Exception{
        // given
        Student student = new Student("admin", 10);
        // when
        // then
        assertThat(student.getName()).isEqualTo("admin");
        assertThat(student.getAge()).isEqualTo(10);
    }
    
    @Test
    @DisplayName("Student 나이 체크 예외 발생")
    public void ageCheck() throws Exception{
        assertThatThrownBy(() -> new Student("admin", -10))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Student 수강 클래스 확인")
    public void hasClassCheck() throws Exception{
        // given
        Student student = new Student();
        List<Class> classes = student.getClasses();
        // when
        assertThat(classes).isNotEmpty();
        assertThat(classes).containsAnyOf(KOREAN);
        // then
    }
}