package com.example.lib_component_center.handler;

import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.sankuai.waimai.router.annotation.RouterRegex;
import com.sankuai.waimai.router.core.UriCallback;
import com.sankuai.waimai.router.core.UriHandler;
import com.sankuai.waimai.router.core.UriRequest;
import com.sankuai.waimai.router.core.UriResult;


/**
 * webview组件的另一种实现
 * 只处理HTTPS链接的UriHandler的实现
 *
 * @author kinsomy
 * @date 2023/1/9
 * @time 22:16
 */

@RouterRegex(regex = "http(s)?://.*", priority = 1)
public class HttpUriHandler extends UriHandler {
    public void handle(@NonNull final UriRequest request, @NonNull final UriCallback callback) {
        Uri uri = request.getUri();
        // 处理HTTP链接
        if ("https".equalsIgnoreCase(uri.getScheme())) {
            try {
                // 调用系统浏览器
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                request.getContext().startActivity(intent);
                // 跳转成功
                callback.onComplete(UriResult.CODE_SUCCESS);
            } catch (Exception e) {
                // 跳转失败
                callback.onComplete(UriResult.CODE_ERROR);
            }
        } else {
            // 非HTTPS链接不处理，继续分发
            callback.onNext();
        }
    }

    @Override
    protected boolean shouldHandle(@NonNull UriRequest request) {
        return true;
    }

    @Override
    protected void handleInternal(@NonNull UriRequest request, @NonNull UriCallback callback) {
        handle(request, callback);
    }
}