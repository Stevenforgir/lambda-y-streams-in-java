package com.debuggeando_ideas.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Review {

    private String comment;
    private Integer score;

}
