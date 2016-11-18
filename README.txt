一、架构简介：
从底层到上层分别为：Data Layer 、Domain Layer、UI Layer
其中Data Layer包含local、remote
UI Layer 采用mvp模式

二、模块介绍：

data:
属于Data Layer，负责本地数据的处理

http:
属于Data Layer,纯java,采用okhttp、retrofit、rxjava,负责http/https协议的网络处理

domain:
属于领域层,纯java,与android无关，负责业务逻辑

mvp:
属于UI层,mvp模式接口（Model-View-Presenter),纯java,与android无关



core:
android核心模块,没有集成第三方框架，android相关的

base:
基础模块，依赖data、domain、mvp、core、http模块，集成各种第三方框架与库

widget:
各种自定义控件模块

asynctask:
替代系统AsyncTask的异步任务库

app:
Demo模块,展示整个工程所有模块的使用方法


！注意：
请不要在相关层和模块引入与该层或该模块主要功能无关的东西

三、开发规范：
1.开放中的版本请在创建分支名字
 开发中的版本总分支（版本+develop）
 开发中的版本各用户的分支（版本+develop_用户名）
2.每个版本开放必须先写下当前版本要做的事情(写在目录下的版本任务清单目录下)，
  只在当前版本开发过程中，只做当前版本要做的事情
3.尽量编写单元测试代码
4.如果有必要请在app层写demo代码
5.命名规范请参照目录下的Android小组开发编码规范_v0.1.txt

四、依赖说明：
所有的依赖的地址必须写在目录下的dependencies中,引入依赖请从该文件中查找

五、config.gradle说明
里面配置有compileSdkVersion、buildToolsVersion、minSdkVersion、targetSdkVersion属性
以及依赖配置，使用请参照其它模块使用方式