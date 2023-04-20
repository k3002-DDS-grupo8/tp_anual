import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void cantidadCaracteresUnicode() {
        assertEquals(2, "日本".length());
    }

    @Test
    public void contraseniaEnListaNegra() {
        assert(Validator.getCommonPasswords().contains("admin"));
    }

    @Test
    public void contraseniaFueraDeListaNegra() {
        assert(!Validator.getCommonPasswords().contains("grupo8dds"));
    }

    @Test
    public void masDeOchoCaracteresUnicode() {
        assertEquals(true, Validator.validarPassword("日本日本日本日本"));
    }

    @Test
    public void masDe1EspacioFalso() {
        assertFalse(Validator.masDeOchoCaracteres(Validator.parsePassword("123456     ")));
    }

    @Test
    public void potenciaPasswords() {
        assertEquals(Validator.potenciaPassword("1"), 1);
        assertEquals(Validator.potenciaPassword("12345678"), 2);
        assertEquals(Validator.potenciaPassword("12345678a"), 3);
        assertEquals(Validator.potenciaPassword("12345678aA"), 4);
        assertEquals(Validator.potenciaPassword("12345678aA@"), 5);
    }

}
