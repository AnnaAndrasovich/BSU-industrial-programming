package org.example;

import static org.example.Main.eps_get;
import static org.example.Main.res_get;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void main() {
        double x = 0.6, eps = 3, expected = 0.636, actual;
        int e = 2;
        eps = eps_get(e);
        actual = res_get(x, eps);
        assertEquals(expected, actual);
    }
}