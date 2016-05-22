package accountms.com.dell.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 2016/5/17.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DBNAME = "account.db";



    public DBOpenHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_outaccount (_id integer primary key,money decimal,time varchar(10),"+
                "type varchar(10),address varchar(100),mark varchar(200))");  //创建支出信息表
        db.execSQL("create table tb_inaccount  (_id integer primary key,money decimal,time varchar(10),"+
        "type varchar(10),handler varchar(100),mark varchar(200))");//创建收入信息表
        db.execSQL("create table tb_pwd (password varchar(20))"); // 创建密码表
        db.execSQL("create table tb_flag (_id integer primary key,flag varchar(200))");  //创建便签信息表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
