package com.example.csd214test3ankitkumar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloApplicationTest {

    @Test
    void totalBill() {
        HelloApplication app = new HelloApplication();

        assertEquals(14.95, app.TotalBill("L", 2), 0.01);

    }
}
