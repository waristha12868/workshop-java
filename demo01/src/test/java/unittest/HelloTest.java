package unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTest {

    @Test
    @DisplayName("case-demo01")
    public void case01() {
        // Arrange
        Hello hello = new Hello();
        // Act
        String actualResult = hello.hi("waristha");
        // Assert
        assertEquals("Hello, waristha", actualResult);
    }

    @Test
    @DisplayName("case-demo02 : ทดสอบ database")
    public void case02() {
        // Arrange
        Hello hello = new Hello();
        hello.userDB = new UserDB() {
            @Override
            public String getNameById(int id) {
                return "waristha";
            }
        };
        // Act
        String name = hello.workWithDb(1);
        // Assert
        assertEquals("waristha", name);
    }

    @Test
    @DisplayName("กรณี exception เมื่อหาผู้ใช้งาน Id=2 ไม่เจอ")
    public void case03() {
        Hello hello = new Hello();
        hello.userDB = new UserDB(){
            @Override
            public String getNameById(int id){
                throw new UserNotFoundException("Id=" + id + " Not found");
            }
        };
        Exception exception = assertThrows(UserNotFoundException.class, () ->
                hello.workWithDb(2));
        assertEquals("Id=2 Not found", exception.getMessage());
    }
}
