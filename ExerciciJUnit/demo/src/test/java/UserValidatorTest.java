import org.junit.jupiter.api.Test;

import com.example.UserValidator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserValidatorTest {

    @Test
    public void testValidaDNI_Valid() {
        UserValidator validator = new UserValidator();
        assertTrue(validator.validaDNI("48780803B"));
    }

    @Test
    public void testValidaDNI_Invalid() {
        UserValidator validator = new UserValidator();
        assertFalse(validator.validaDNI("4878080"));
    }

    @Test
    public void testValidaNIA_Valid() {
        UserValidator validator = new UserValidator();
        assertTrue(validator.validaNIA("4878080"));
    }

    @Test
    public void testValidaNIA_Invalid() {
        UserValidator validator = new UserValidator();
        assertFalse(validator.validaNIA("48780803"));
    }

    @Test
    public void testValidaUsuario_Valid() {
        UserValidator validator = new UserValidator();
        assertTrue(validator.validaUsuario("48780803B", "4878080", "patitodegoma"));
    }

    @Test
    public void testValidaUsuario_InvalidShortPassword() {
        UserValidator validator = new UserValidator();
        assertFalse(validator.validaUsuario("48780803B", "4878080", "patito"));
    }

    @Test
    public void testValidaUsuario_MockValidaDNITrue() {
        UserValidator validator = spy(new UserValidator());
        doReturn(true).when(validator).validaDNI("48780803B");
        doReturn(true).when(validator).validaNIA("4878080");
        assertTrue(validator.validaUsuario("48780803B", "4878080", "patitodegoma"));
    }

    @Test
    public void testValidaUsuario_MockValidaDNIFalse() {
        UserValidator validator = spy(new UserValidator());
        doReturn(false).when(validator).validaDNI("48780803B");
        doReturn(true).when(validator).validaNIA("4878080");
        assertFalse(validator.validaUsuario("48780803B", "4878080", "patitodegoma"));
    }
}
