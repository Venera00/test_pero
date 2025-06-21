package com.example.demo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CommunityPageTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/club225299895");
    }

    @Test
    public void testCommunityMainPage() {
    
        $("h1").shouldHave(text("Test public for test"));
       
        $$("button").findBy(text("Подписаться")).shouldBe(visible);

        $$("a").findBy(text("Главная")).shouldBe(visible);
    }
}
