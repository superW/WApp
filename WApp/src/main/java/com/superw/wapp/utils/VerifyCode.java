package com.superw.wapp.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
/**验证码 相关操作
 * Created by wangyc-e on 2015/12/23.
 */
public class VerifyCode {


    /**
     *  获取验证码
     * @param tv
     * @param
     */
    public static void getCode(final Context context, final TextView tv, final View.OnClickListener l) {
        final Resources r = context.getResources();

        tv.setOnClickListener(null);

        new CountDownTimer(60000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                String text = "<font color=\"#cfcfcf\">"+ (millisUntilFinished / 1000) +"s后重获验证码</font>";
                tv.setText(Html.fromHtml(text));
//                tv.setBackgroundDrawable(r.getDrawable(R.drawable.shape_verify_code_gray_bg));
            }

            @Override
            public void onFinish() {
                String text = "<font color=\"#ffffff\">重新获取验证码</font>";
                tv.setText(Html.fromHtml(text));
//                tv.setBackgroundResource(R.color.verify_code_red_bg);
                tv.setOnClickListener(l);
            }

        }.start();

    }
}
