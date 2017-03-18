package com.exovum.main.android;

import android.content.Context;
import android.os.Handler;

import com.exovum.main.ActionResolver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by exovu on 3/18/2017.
 */

public class AndroidActionResolver implements ActionResolver {

    Handler uiThread;
    Context appContext;

    public AndroidActionResolver(Context appContext) {
        uiThread = new Handler();
        this.appContext = appContext;
    }

    @Override
    public Connection getConnection() {
        String url = "jdbc:sqldroid:/data/data/my.app.name/databases/data.sqlite";
        try {
            Class.forName("org.sqldroid.SQLDroidDriver").newInstance();
            return DriverManager.getConnection(url);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}