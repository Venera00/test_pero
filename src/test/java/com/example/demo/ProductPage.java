package com.example.demo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ProductPageTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://vk.com/market/product/fyaf-225299895-10044406");
    }

    @Test
    public void testProductCard() {
        $("h1").shouldHave(text("фываф"));

        $("span[class*=Price]").shouldHave(text("бесплатно"));

        $$("button").findBy(text("Написать")).shouldBe(visible);

        $("a[href*='club225299895']").shouldHave(text("Test public for test"));

        
        $$("button").findBy(text("Подписаться")).shouldBe(visible);
    }
}
