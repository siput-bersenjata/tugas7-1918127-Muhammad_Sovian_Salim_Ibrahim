package com.example.tgsprak7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_sl";
    private static final String tb_game = "tb_game";
    private static final String tb_game_id = "id";
    private static final String tb_game_nama = "nama";
    private static final String tb_game_harga = "harga";
    private static final String CREATE_TABLE_SL = "CREATE TABLE " +
            tb_game +"("
            + tb_game_id + " INTEGER PRIMARY KEY ,"
            + tb_game_nama + " TEXT ,"
            + tb_game_harga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SL);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateMahasiswa(Game data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_game_id, data.get_id());
        values.put(tb_game_nama, data.get_nama());
        values.put(tb_game_harga, data.get_kelas());
        db.insert(tb_game, null, values);
        db.close();
    }
    public List<Game> ReadMahasiswa() {
        List<Game> listMhs = new ArrayList<Game>();
        String selectQuery = "SELECT * FROM " + tb_game;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Game data = new Game();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_kelas(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateMahasiswa (Game data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_game_nama, data.get_nama());
        values.put(tb_game_harga, data.get_kelas());
        return db.update(tb_game, values, tb_game_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteMahasiswa(Game data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_game,tb_game_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

