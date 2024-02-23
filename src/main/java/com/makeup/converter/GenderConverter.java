package com.makeup.converter;

import com.makeup.domain.Gender;
import org.springframework.core.convert.converter.Converter;

public class GenderConverter implements Converter<String, Gender> {

    @Override
    public Gender convert(String source) {
        return Gender.findByKor(source);
    }
}
