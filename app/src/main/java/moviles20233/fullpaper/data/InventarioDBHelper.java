package moviles20233.fullpaper.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import moviles20233.fullpaper.data.UsuarioContract.UsuarioEntry;

public class InventarioDBHelper  extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Inventario.db";

    public InventarioDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + UsuarioEntry.TABLE_NAME + " ("+
                UsuarioEntry.ID + " INTEGER PRIMARY KEY," +
                UsuarioEntry.NAME+ " TEXT NOT NULL," +
                UsuarioEntry.PASSWORD+ " INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long saveUser(Usuario usuario) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(
                UsuarioEntry.TABLE_NAME,
                null,
                usuario.toContentValues());
    }

    public Cursor getAllUsuarios() {
        return getReadableDatabase()
                .query(
                        UsuarioEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getUsuarioById(String usuarioId) {
        Cursor c = getReadableDatabase().query(
                UsuarioEntry.TABLE_NAME,
                null,
                UsuarioEntry.ID + " LIKE ?",
                new String[]{usuarioId},
                null,
                null,
                null);
        return c;
    }

    public Cursor getUsuarioByIdPassword(String usuarioId,String usuarioPassword) {
        Cursor c = getReadableDatabase().query(
                UsuarioEntry.TABLE_NAME,
                null,
                UsuarioEntry.ID + " LIKE ? AND "+UsuarioEntry.PASSWORD + " LIKE ?",
                new String[]{usuarioId,usuarioPassword},
                null,
                null,
                null);
        return c;
    }

    public int deleteUsuario(String usuarioId) {
        return getWritableDatabase().delete(
                UsuarioEntry.TABLE_NAME,
                UsuarioEntry.ID+ " LIKE ?",
                new String[]{usuarioId});
    }

    public int updateUsuario(Usuario usuarioModificar, String usuarioId) {
        return getWritableDatabase().update(
                UsuarioEntry.TABLE_NAME,
                usuarioModificar.toContentValues(),
                UsuarioEntry.ID + " LIKE ?",
                new String[]{usuarioId}
        );
    }

}
