package com.superw.wapp.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

/**文件工具类
 * Created by wangyc-e on 2015/12/23.
 */
public class FileUtils {


    /** sdcard路径 */
    public static final String SDCARD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();

    /** 项目根路径 */
    public static final String PROJECT_ROOT_PATH = SDCARD_PATH + "/com.glodon.knowcar";

    /** 项目图片路径 */
    public static final String PROJECT_IMAGE_PATH = PROJECT_ROOT_PATH + "/image";

    /** 项目头像文件路径 (截图成功后的图片存储路径) */
    public static final String HEAD_IMAGE_PATH = PROJECT_IMAGE_PATH + "/headimage.jpg";

    /** 项目头像临时文件路径 (未截图之前的图片存储路径) */
    public static final String TEMP_HEAD_IMAGE_PATH = PROJECT_IMAGE_PATH + "/temp_headimage.jpg";

    /**
     * 判断是否存在外部设备
     */
    public static boolean haveExternalDevice(){
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 创建文件
     * 如果文件不存在则主动创建
     * @param file 创建的文件
     * @return 创建成功与否
     */
    public static File createNewFile(File file) {
        createNewFolder(file.getParentFile());
        try {
            if(!file.exists()){
                file.createNewFile();
            }else{
                file.delete();
                file.createNewFile();
            }
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 创建文件夹
     * 如果文件夹不存在则主动创建
     * @param file
     * @return
     */
    public static File createNewFolder(File file) {
        if(!file.exists()){
            file.mkdirs();
        }
        return file;
    }

    /**
     * 删除文件或者文件夹
     * @param file
     * @return
     */
    public static void deleteFile(File file){
        if(file == null) return;
        if(file.exists()){
            if(file.isFile()){
                file.delete();
            }else if(file.isDirectory()){
                File files[] = file.listFiles();
                for(File f : files){
                    deleteFile(f);
                }
                file.delete();
            }
        }
    }

    /**
     * 保存剪裁后的图片
     *
     * @param bitmap
     * @param file
     */
    public static boolean saveBitmap(Bitmap bitmap, File file) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (fos != null){
                    fos.close();
                    fos = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
