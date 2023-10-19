package moviles20233.fullpaper.data;

import android.content.ContentValues;
import android.database.Cursor;
import moviles20233.fullpaper.data.UsuarioContract.UsuarioEntry;
import moviles20233.fullpaper.data.TelefonoContract.TelefonoEntry;

public class Telefono {
    private int id;

    private long telefono;

    public Telefono(int id, long telefono) {
        this.id = id;
        this.telefono = telefono;
    }

    public Telefono(Cursor cursor){
        id = cursor.getInt( cursor.getColumnIndex( UsuarioEntry.ID ) );
        telefono = cursor.getLong( cursor.getColumnIndex(TelefonoEntry.TELEFONO  ) );
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put( UsuarioEntry.ID,id );
        values.put( TelefonoEntry.TELEFONO,telefono );
        return values;
    }

    public int getId() {
        return id;
    }

    public long getTelefono() {
        return telefono;
    }
}
