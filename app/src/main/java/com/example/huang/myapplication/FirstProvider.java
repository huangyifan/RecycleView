package com.example.huang.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.Nullable;

/**
 * Created by huang on 16-7-12.
 */
public class FirstProvider extends ContentProvider {

    UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    //第一次创建ContentProvider时调用该方法
    public boolean onCreate() {
        System.out.println("=====onCreate方法被调用======");
        return true;
    }


    //实现查询方法，该方法应该返回查询得到的Cursor
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        System.out.println(uri+"=====query方法被调用======");
        System.out.println("where参数为："+s);
        return null;
    }


    //该方法的返回值代表了该ContentProvider所提供数据的MIME类型
    public String getType(Uri uri) {
        return null;
    }



    public Uri insert(Uri uri, ContentValues contentValues) {
        System.out.println(uri+"=====insert方法被调用======");
        System.out.println("value参数为："+contentValues);
        return null;
    }


    public int delete(Uri uri, String s, String[] strings) {
        System.out.println(uri+"=====delete方法被调用======");
        System.out.println("where参数为："+s);
        return 0;
    }


    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        System.out.println(uri+"=====update方法被调用======");
        System.out.println("where参数为："+s);
        return 0;
    }
}
