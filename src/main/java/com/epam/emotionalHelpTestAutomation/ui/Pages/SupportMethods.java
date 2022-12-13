package com.epam.emotionalHelpTestAutomation.ui.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class SupportMethods {

    public static final ArrayList<String> scaredEmotion = new ArrayList<>(List.of("helpless",
            "rejected",
            "insecure",
            "submissive",
            "embarressed",
            "insignificant"));

    public static final ArrayList<String> afraidEmotion = new ArrayList<>(List.of(
            "stressed",
            "overwhelmed",
            "powerless  ",
            "anxious",
            "guilty",
            "ashamed"
    ));

    public static final ArrayList<String> acceptedEmotion = new ArrayList<>(List.of(
            "loved",
            "honored",
            "appreciated",
            "respected",
            "brave",
            "proud"
    ));

    public static final ArrayList<String> joyEmotion = new ArrayList<>(List.of(
            "proud",
            "optimistic",
            "happy",
            "cheerful",
            "enthusiastic",
            "hopeful",
            "eager",
            "amused",
            "satisfied",
            "pleased",
            "blisful"
    ));

    public static final ArrayList<String> surpriseEmotion = new ArrayList<>(List.of(
            "stunned",
            "confused",
            "amazed",
            "speechless",
            "shocked",
            "touched",
            "stimulated",
            "astounded",
            "awe-struck",
            "perplexed"
    ));

    public static final ArrayList<String> loveEmotion = new ArrayList<>(List.of(
            "tenderness",
            "heat",
            "sympathy",
            "bliss",
            "confidence",
            "identity",
            "respect",
            "sincerity",
            "mutual assistance",
            "kindness",
            "humility",
            "sympathy"
    ));

    public static final ArrayList<String> sadnessEmotion = new ArrayList<>(List.of(
            "bitterness",
            "yearning",
            "sorrow",
            "laziness",
            "pity",
            "despair",
            "heartache",
            "hopelessness",
            "disappointment",
            "boredom",
            "downtroddenness"
    ));

    public static final ArrayList<String> fearEmotion = new ArrayList<>(List.of(
            "despair",
            "fright",
            "numbness",
            "suspicion",
            "anxiety",
            "dumbfoundedness",
            "shame",
            "guilt",
            "fear",
            "humiliation",
            "confusion",
            "doubt"
    ));

    public static final ArrayList<String> angerEmotion = new ArrayList<>(List.of(
            "rabies",
            "fury",
            "hate",
            "hysteria",
            "irritation",
            "contempt",
            "indignation",
            "resentment",
            "jealousy",
            "vulnerability",
            "annoyance",
            "envy"
    ));
}
