package com.spring.testTag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Test
@Tag("fast") // 어노테이션 사용 시 붙여 줄 태그
public @interface FastTest {
    // 커스텀 어노테이션를 만들어서 테스트 시 사용하자.
    // 여러 어노테이션을 묶은 어노테이션이라고 생각하면 됨
}
