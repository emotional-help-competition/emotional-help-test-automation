package com.epam.emotionalHelpTestAutomation.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Set;

@NoArgsConstructor
@Data
public class Quiz {

    private Long id;
    private String name;
    private String description;
    private ZonedDateTime createDate;
    private Set<Question> questions;
}
