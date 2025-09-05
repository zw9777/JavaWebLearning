import com.sun.org.glassfish.gmbal.ParameterNames;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @BelongsProject: Maventest
 * @BelongsPackage: PACKAGE_NAME
 * @Author: WeiZhenDeng
 * @CreateTime: 2025-09-01
 */


public class UserServiceTest {

    @Test
    public void testGetAge() {
        UserService userService = new UserService();
        Integer age = userService.getAge("110101199001011234");
        System.out.println(age);
    }

    /*断言测试*/
    @Test
    public void testGetGender() {
        UserService userService = new UserService();
        String gender = userService.getGender("110101199001011234");
        System.out.println(gender);
    }


    @Test
    public void testGetGenderASSERT(){
        UserService userService = new UserService();
        String gender = userService.getGender("110101199001011234");
        Assertions.assertEquals("男", gender,"性别错误");

    }

    /*参数化测试*/
    @DisplayName("测试用户性别")
    @ParameterizedTest
    @ValueSource(strings = {"110101199001011234","110101199001011235"})
    public void testGetGender3(String idCard){
        UserService userService = new UserService();
        String gender = userService.getGender(idCard);
        /*断言*/
        Assertions.assertEquals("男", gender);
    }
}
