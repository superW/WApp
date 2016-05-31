package com.superw.wapp.utils;

import android.content.Context;
import android.widget.Toast;

/**Toast统一管理类
 * Created by wangyc-e on 2015/12/23.
 */
public class T {


    private static Toast mToast;

    public static void showNewText(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    public static void showShort(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
    public static void showLong(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

}
