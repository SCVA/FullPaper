package moviles20233.fullpaper.data;

import android.provider.BaseColumns;

public class UsuarioContract {
    public static abstract class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME ="usuario";
        public static final String ID = "cedula";
        public static final String NAME = "nombre";
        public static final String PASSWORD = "password";
    }
}
