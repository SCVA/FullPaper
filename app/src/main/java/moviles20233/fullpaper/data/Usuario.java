package moviles20233.fullpaper.data;

import android.content.ContentValues;
import android.database.Cursor;
import moviles20233.fullpaper.data.UsuarioContract.UsuarioEntry;

public class Usuario {
    private int id;
    private int password;
    private String nombre;

    public Usuario(int id, int password, String nombre) {
        this.id = id;
        this.password = password;
        this.nombre = nombre;
    }

    public Usuario(Cursor cursor){
        id = cursor.getInt( cursor.getColumnIndex( UsuarioEntry.ID ) );
        password =cursor.getInt( cursor.getColumnIndex(UsuarioEntry.PASSWORD) );
        nombre =cursor.getString(  cursor.getColumnIndex(UsuarioEntry.NAME));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put( UsuarioEntry.ID,id );
        values.put( UsuarioEntry.PASSWORD,password );
        values.put( UsuarioEntry.NAME,nombre );
        return values;
    }

    public int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
