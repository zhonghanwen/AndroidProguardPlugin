package com.zhw.proguard;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.GroupedElementsRenderer;

/**
 * Created by zhonghanwen on 2016/6/7.
 */
public class AndroidProGuardAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
        Application application = ApplicationManager.getApplication();
        AndroidComponent androidComponent = application.getComponent(AndroidComponent.class);
        androidComponent.sayHello();
    }
}
