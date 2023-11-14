package moviles20233.fullpaper.data;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class UsuarioTest {

    Usuario prueba = new Usuario(1111,1111,"Prueba");

    @Test
    public void getId() {
        assertEquals(1111,prueba.getId());
    }

    @Test
    public void getPassword() {
        assertEquals(1111,prueba.getPassword());
    }

    @Test
    public void getNombre() {
        assertEquals("Prueba",prueba.getNombre());
    }

    @Test
    public void setNombre() {
        prueba.setNombre( "Prueba 2" );
        assertEquals("Prueba 2",prueba.getNombre());
    }
}