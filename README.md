# AndroidProguardPlugin
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AndroidProguardPlugin-green.svg?style=true)](https://android-arsenal.com/details/1/3721)

OneKey Android Studio generate proguard codes 

一键生成项目混淆代码插件，值得你安装~

# Screenshot
![](http://7xrnko.com1.z0.glb.clouddn.com/androidproguard1.gif)

# Library List
目前插件的后台已集成了如下图的第三方开源库的代码混淆以及基本的代码混淆，还在努力地添加中，也欢迎大家通过new issue提交列表中没有的第三方开源库混淆代码。（你认为微不足道的事情，也许可以帮到别人的大忙~）

![](http://7xrnko.com1.z0.glb.clouddn.com/library_list.png)


# How to use
1. 下载AndroidProGuard插件并安装重启。[download](https://raw.githubusercontent.com/zhonghanwen/AndroidProguardPlugin/master/AndroidProguardPlugin.zip)
2.  在菜单栏的Edit下拉菜单中选择AndroidProGuard选项。
3. 如果弹出成功对话框，就可以按Ctrl+V粘贴到项目的proguard-rules.pro文件。
4. 根据proguard-rules.pro报错的提示进行修改成。
5. 将项目app下gradle文件将minifyEnabled修改成true就可以测试混淆效果。 （你可以使用AndroidKiller反编译看一下效果，AndroidKiller的使用可以参考我写的这篇文章[here](http://www.cnblogs.com/common1140/p/5198460.html)）

# **Note**
1. 实际的项目通常会有多个的Module，对于多个Module的代码混淆网上资料比较少，经过我实验得出：**对于多个Module的项目，在应用的Module（即app）下的proguard-rules.pro文件添加混淆代码以及在Gradle里minifyEnabled开启即可**。

2. 如果项目在编译的时候报warn信息，那么你可以使用-keep或者-dontwarn保留warn的类。

# End
我知道项目的代码混淆一般通常混淆一次就可以了，很多人认为这个插件的意义不太，但是我可以告诉你我也是这么想的，可是我也无办法阻止我的行动~哈哈~~

# Update

![](http://7xrnko.com1.z0.glb.clouddn.com/androidproguard_three_part.png)

update 20171029
* 新增fresco/更新Gilde/新增科大讯飞.

# License

    Copyright 2016 zhonghanwen
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
