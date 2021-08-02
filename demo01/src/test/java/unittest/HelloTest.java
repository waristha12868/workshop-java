package unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTest {

    @Test
    @DisplayName("นี่คือ case แรกขแงการเขียนนะ")
    public void case01() {
        // Arrange == Given == Pre Condition
        Hello hello = new Hello();
        // Act == When == Action == Call target method
        String actualresult = hello.hi("waristha");
        // Assert == Validate with expected result
        assertEquals("Hello waristha", actualresult);
    }

    @Test
    @DisplayName("ทำการทดสอบกับ database  success(I = Isolate/Independent)")
    public void case02() {
        Hello hello = new Hello();
        hello.userDB = new UserDBSuccess();
        String name = hello.workWithDB(1);
        assertEquals("waristha", name);
    }

    @Test
    @DisplayName("ทำการทดสอบกับ database fail(I = Isolate/Independent)")
    public void case03() {
        Hello hello = new Hello();
        hello.userDB = new UserDBFail();
        Exception exception = assertThrows(UserNotFoundException.class, () ->
                hello.workWithDB(2));
        assertEquals("Id=2 not found", exception.getMessage());
    }
}

class UserDBSuccess extends UserDB {
    @Override
    public String getNameById(int id) {
        return "waristha";
    }
}

class UserDBFail extends UserDB {
    @Override
    public String getNameById(int id) {
        throw new UserNotFoundException("Id=" + id + " not found");
    }
}
