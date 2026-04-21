package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void verifyLogin_correctUsernameCorrectPassword_returns0() {
        int result = Main.verifyLogin("Qijie,Wang", "123456");
        assertEquals(0, result);
    }

    @Test
    void verifyLogin_correctUsernameWrongPassword_returns1() {
        int result = Main.verifyLogin("Qijie,Wang", "wrongPass");
        assertEquals(1, result);
    }

    @Test
    void verifyLogin_wrongUsernameAnyPassword_returns2() {
        int result = Main.verifyLogin("WrongUser", "123456");
        assertEquals(2, result);
    }

    @Test
    void verifyLogin_nullUsername_returns2() {
        int result = Main.verifyLogin(null, "123456");
        assertEquals(2, result);
    }

    @Test
    void verifyLogin_correctUsernameNullPassword_returns1() {
        int result = Main.verifyLogin("Qijie,Wang", null);
        assertEquals(1, result);
    }

    @Test
    void verifyLogin_nullUsernameNullPassword_returns2() {
        int result = Main.verifyLogin(null, null);
        assertEquals(2, result);
    }

    @Test
    void showLoginResultDialog_allCases_noException() {
        assertDoesNotThrow(() -> Main.showLoginResultDialog(0));
        assertDoesNotThrow(() -> Main.showLoginResultDialog(1));
        assertDoesNotThrow(() -> Main.showLoginResultDialog(2));
        assertDoesNotThrow(() -> Main.showLoginResultDialog(999));
    }
}