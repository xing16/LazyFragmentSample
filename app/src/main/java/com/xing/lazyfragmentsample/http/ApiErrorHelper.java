package com.xing.lazyfragmentsample.http;

import android.content.Context;
import android.widget.Toast;

import java.io.IOException;

import retrofit2.HttpException;

public class ApiErrorHelper {

    public static void handleCommonError(Context context, Throwable throwable) {
        if (throwable instanceof HttpException) {
            Toast.makeText(context, "服务异常，请稍后重试", Toast.LENGTH_SHORT).show();
        } else if (throwable instanceof IOException) {
            Toast.makeText(context, "连接失败", Toast.LENGTH_SHORT).show();
        } else if (throwable instanceof ApiException) {
            // ApiException 处理
        } else {
            Toast.makeText(context, "未知错误", Toast.LENGTH_SHORT).show();
        }

    }


}
