一、模块介绍：
data:
数据库层

domain:
用例层（任务抽象接口）

mvp:
mvp模式接口层（Model-View-Presenter）

core:
没有集成第三方框架的核心层

base:
在核心层与mvp模式层（可替换成其它模式）基础上集成了各种第三方框架与库的基础层

widget:
控件层，各种自定义控件

app:
Demo层,展示整个工程所有模块的使用方法


！注意：
请不要在相关层引入与该层主要功能无关的东西
除了base层和widget层之外其它层不要引入第三方框架

二、开发规范：
1.开放中的版本请在创建分支名字（develop_版本_用户名）
2.每个版本开放必须先写下当前版本要做的事情(写在目录下的版本任务清单目录下)，
  只在当前版本开发过程中，只做当前版本要做的事情
3.尽量编写单元测试代码
4.如果有必要请在app层写demo代码
5.命名规范请参照目录下的Android小组开发编码规范_v0.1.txt

三、依赖说明：
所有的依赖的地址必须写在目录下的dependencies中,引入依赖请从该文件中查找

四、config.gradle说明
里面配置有compileSdkVersion、buildToolsVersion、minSdkVersion、targetSdkVersion属性
以及依赖配置，使用请参照其它模块使用方式