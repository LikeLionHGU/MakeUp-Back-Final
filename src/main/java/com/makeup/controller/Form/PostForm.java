package com.makeup.controller.Form;

import com.makeup.dto.BrandProductDto;
import lombok.Getter;

import java.util.List;

@Getter
public class PostForm {

    private String title;

    private Long memberId;

    private List<BrandProductDto> brandProducts;

}
