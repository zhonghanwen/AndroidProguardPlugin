package com.zhw.proguard;

import com.alibaba.fastjson.JSON;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.ui.Messages;
import com.zhw.proguard.bean.BaseBean;
import com.zhw.proguard.bean.ResultBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.https.HttpsUtils;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

/**
 * Created by zhonghanwen on 2016/6/7.
 */
public class AndroidComponent implements ApplicationComponent, Configurable {

    private String content = "";
    private boolean isLoading = true;


    public AndroidComponent() {
        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    @Override
    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    @Override
    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @Override
    @NotNull
    public String getComponentName() {
        return "AndroidComponent";
    }


    public void sayHello() {
        content = "";
        isLoading = false;
        // Show dialog with message
        String baseUrl = "https://api.bmob.cn/1/classes/proguard";
        OkHttpUtils
                .get()
                .url(baseUrl)
                .addHeader("X-Bmob-Application-Id", "8032a3407adfe5b02689f9cc3962fffe")
                .addHeader("X-Bmob-REST-API-Key", "043c532e6050fae1056acc1127741458")
                .addHeader("Content-Type","application/json")
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        isLoading = false;
                    }

                    @Override
                    public void onResponse(String s, int code) {
                        if (s != null){
                            BaseBean baseBean = JSON.parseObject(s, BaseBean.class);
                            if (baseBean.results != null){
                                for (ResultBean bean : baseBean.results){
                                    content += bean.content + "\n";
                                }
                            }
//                            System.out.println(content);
                            StringSelection stsel = new StringSelection(content);
                            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, stsel);
                            isLoading = false;
                        }
                    }

                });

        while (true){
            if (!isLoading){
                showSucceedDialog();
                break;
            }
        }
    }

    private void showSucceedDialog() {
        Messages.showMessageDialog(
                "Android Proguard Codes Generate Succeed~ " +
                 "\n Please paste codes(Ctrl+V) in proguard-rules.pro!",
                "AndroidProGuard",
                Messages.getInformationIcon()

        );
    }

    @Nls
    @Override
    public String getDisplayName() {
        return null;
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return null;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {

    }

    @Override
    public void reset() {

    }

    @Override
    public void disposeUIResources() {

    }
}
