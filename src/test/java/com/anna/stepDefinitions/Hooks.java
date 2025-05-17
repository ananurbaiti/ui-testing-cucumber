package com.anna.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        // Optional: bisa kosong karena driver sudah di-initialize saat dipanggil di step Given
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
