package com.epam.emotionalHelpTestAutomation.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Question {

    private Long id;
    private String text;
    private Emotion emotion;
}
