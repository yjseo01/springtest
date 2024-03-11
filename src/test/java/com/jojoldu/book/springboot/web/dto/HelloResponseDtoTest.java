package com.jojoldu.book.springboot.web.dto;

import org.junit.jupiter.api.Test;
import web.dto.HelloResponseDto;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombokTest() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name); // assertj 라이브러리의 검증 메소드, 동등 비교 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
