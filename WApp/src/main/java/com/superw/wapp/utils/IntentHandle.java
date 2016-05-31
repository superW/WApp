package com.superw.wapp.utils;

import java.io.File;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;


/**处理Intent相关的操作
 * Created by wangyc-e on 2015/12/23.
 */
public class IntentHandle {

    public static final int REQUEST_ALBUM = 0x101;	// 相册
    public static final int REQUEST_CAMER = 0x102; 	// 拍照
    public static final int REQUEST_CROP = 0x103; 	// 裁剪

    /***
     * 去相册
     * @param act
     */
    public static void toAlbum(Activity act){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        act.startActivityForResult(Intent.createChooser(intent, "选择图片"), REQUEST_ALBUM);
    }

    /**
     * 去拍照
     * @param act
     */
    public static void toCamera(Activity act){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        act.startActivityForResult(intent, REQUEST_CAMER);
    }

    /**
     * 裁剪
     * @param activity
     * @param uri
     */
    public static void cropImage(Activity activity, Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // crop为true是设置在开启的intent中设置显示的view可以剪裁
        intent.putExtra("crop", "true");// 设置了参数，就会调用裁剪，如果不设置，就会跳过裁剪的过程。
        // aspectX aspectY 是宽高的比例(注意： aspectX, aspectY ，两个值都需要为
        // 整数，如果有一个为浮点数，就会导致比例失效。)
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX,outputY 是剪裁图片的宽高,返回数据的时候的 X,Y 像素大小
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);// 是否要返回值。 一般都要
        intent.putExtra("noFaceDetection", true);// 是否去除面部检测， 如果你需要特定的比例去裁剪图片，那么这个一定要去掉，因为它会破坏掉特定的比例。
        activity.startActivityForResult(intent, REQUEST_CROP);
    }

}
