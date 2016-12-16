# Robust
美团热修复框架案例

#RobustHost
这个项目是宿主项目，也就是开发应用项目，主要逻辑有加载修复包。依赖于RobustPatch项目

#RobustPatch
这个项目是修复包接口项目，这个项目主要定义了修复接口。

#RobustPatchImpl
这个项目是具体实现修复功能的项目，依赖于RobustPatch项目

#运行
整个运行流程很简单，先运行修复包工程RobustPatchImpl得到apk文件之后，获取其classes.dex文件改名成patch.dex，放到sd卡下即可。当然这个步骤不是必须的，可以直接加载apk文件，放到自己定义的目录下即可，只要修改Application的加载代码即可。

#报错
这里运行过程中遇到的最多问题就是：Class ref in pre-verified class resolved to unexpected implementation，关于这个错误，可以去查看这篇文章进行解决：[Android中插件开发原理](http://www.wjdiankong.cn/android%E4%B8%AD%E6%8F%92%E4%BB%B6%E5%BC%80%E5%8F%91%E7%AF%87%E4%B9%8B-%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8/)