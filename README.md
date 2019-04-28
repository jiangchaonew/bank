银行详情信息接口测试
===================
url = http://preview.airwallex.com:30001/bank 在config.properties文件中配置，可修改。

## 执行步骤
* 安装jdk1.8
* 设置环境变量
* 安装maven
* 设置环境变量
* cd 工程目录
* 运行mvn clean test -DsuiteXmlFile=testng.xml
* 等待执行结束，查看测试报告
* 在测试用例.xlsx中记录测试发现的问题
