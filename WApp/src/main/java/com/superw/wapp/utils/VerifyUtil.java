package com.superw.wapp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**验证工具
 * Created by wangyc-e on 2015/12/23.
 */
public class VerifyUtil {

    /**
     * 验证手机号
     * @param num
     * @return
     */
    public static boolean verifyPhoneNum(String num){
        return matchStr("^1[3458]\\d{9}$", num);
    }

    /**
     * 验证密码格式是否正确
     * @param pwd
     * @return
     */
    public static boolean verifyPassword(String pwd){
        return matchStr("[0-9a-zA-Z]{6,20}", pwd);
    }

    /**
     * 验证昵称格式是否正确
     * @param nickName
     * @return
     */
    public static boolean verifyNickName(String nickName){
        return matchStr("[0-9a-zA-Z]{4,10}", nickName);
    }

    /**判断
     * 正则表达式 与 字符串 是否匹配
     * @param zz 正则表达式
     * @param str 字符串
     * @return
     */
    public static boolean matchStr(String zz, String str){
        Pattern p = Pattern.compile(zz);
        Matcher m = p.matcher(str);
        return m.matches();
    }

}
