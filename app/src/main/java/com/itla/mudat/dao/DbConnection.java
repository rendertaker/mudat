package com.itla.mudat.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by iconlabs on 25/11/17.
 */

public class DbConnection extends SQLiteOpenHelper
{
    public static String DATABASE_NAME = "mudat.db";
    public static String LOG_T = "DbConnection";

    public DbConnection(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SqlHelperSchema.USUARIO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}
