package com.iottech.demokotlinapp;

import android.content.SharedPreferences;

public class Constant {
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    public static String sp_name = "Office_Admin";
    public static int pro;

    public interface keys{
        String USER_ID = "USER_ID";
        String OFFICE_NAME = "OFFICE_NAME";
        String OFFICE_IMG = "OFFICE_IMG";
        String USER_NAME = "USER_NAME";
        String USER_NUMBER = "USER_NUMBER";
        String USER_IMG = "USER_IMG";
        String TOKEN = "TOKEN";
        String IDENTITY = "IDENTITY";
        String TempIDENTITY = "TempIDENTITY";
        String ASSISTENT_ID = "ASSISTENT_ID";
        String OFFICER_ID = "OFFICER_ID";

    }
}
