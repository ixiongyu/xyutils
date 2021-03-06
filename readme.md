XYUtils
=======

Maven

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<settings xsi:schemaLocation='http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd'
          xmlns='http://maven.apache.org/SETTINGS/1.0.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>
    
    <profiles>
        <profile>
            <repositories>
                <repository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-ixiongyu-maven</id>
                    <name>bintray</name>
                    <url>https://dl.bintray.com/ixiongyu/maven</url>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-ixiongyu-maven</id>
                    <name>bintray-plugins</name>
                    <url>https://dl.bintray.com/ixiongyu/maven</url>
                </pluginRepository>
            </pluginRepositories>
            <id>bintray</id>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>bintray</activeProfile>
    </activeProfiles>
</settings>
```
then
```
<dependency>
  <groupId>com.ixiongyu</groupId>
  <artifactId>xyutils</artifactId>
  <version>0.0.2</version>
  <type>pom</type>
</dependency>
```
Gradle

```gradle
repositories {
    maven {
        url  "https://dl.bintray.com/ixiongyu/maven" 
    }
}
```

then
```
compile 'com.ixiongyu:xyutils:0.0.2'
````


## 注意
如需要使用sigar,请下载对应的依赖到对应的系统路径，详情：
[点击查看](https://blog.csdn.net/weixin_42219075/article/details/81099909)

## 获取系统信息（[SystemInfoUtil.java](src/main/java/com/ixiongyu/system/SystemInfoUtil.java)）
- getProperty(),获取基础jdk信息
- getMemoryInfo(),获取内存信息
- getCpuInfo(),获取cpu信息
- getOsInfo(),获取操作系统信息
- getUsrInfo(),获取用户信息
- getFileSystemInfo(),获取文件系统信息
- getNetInfo(),获取网络信息
- getEthernetInfo(),获取网卡信息
- getEthernetInfo(),获取网卡信息

## 身份证校验 （[IDUtils.java](src/main/java/com/ixiongyu/validation/IDUtils.java)）
- conver15CardTo18(),转化15位生份证到18位
- validateIdCard18(),校验身份证号码是否合法
- validateIdCard15(),校验身份证号码是否合法
- validateTWCard(),校验台湾身份证号码是否合法
- validateHKCard(),校验香港身份证号码是否合法
- getGenderByIdCard(),获取性别
- getProvinceByIdCard(),获取省份
- getAreaByIdCard(),获取区域


## OkHttp封装 （[IDUtils.java](src/main/java/com/ixiongyu/validation/IDUtils.java)）
使用实例:
```java
    public static void main(String[] args) {
        // get请求，方法顺序按照这种方式，切记选择post/get一定要放在倒数第二，同步或者异步倒数第一，才会正确执行
        OkHttpUtils.builder().url("请求地址，http/https都可以")
                // 有参数的话添加参数，可多个
                .addParam("参数名", "参数值")
                .addParam("参数名", "参数值")
                // 也可以添加多个
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .get()
                // 可选择是同步请求还是异步请求
                //.async();
                .sync();

        // post请求，分为两种，一种是普通表单提交，一种是json提交
        OkHttpUtils.builder().url("请求地址，http/https都可以")
                // 有参数的话添加参数，可多个
                .addParam("参数名", "参数值")
                .addParam("参数名", "参数值")
                // 也可以添加多个
                .addHeader("Content-Type", "application/json; charset=utf-8")
                // 如果是true的话，会类似于postman中post提交方式的raw，用json的方式提交，不是表单
                // 如果是false的话传统的表单提交
                .post(true)
                .sync();
        
        // 选择异步有两个方法，一个是带回调接口，一个是直接返回结果
        OkHttpUtils.builder().url("")
                .post(false)
                .async();

        OkHttpUtils.builder().url("").post(false).async(new OkHttpUtils.ICallBack() {
            @Override
            public void onSuccessful(Call call, String data) {
                // 请求成功后的处理
            }

            @Override
            public void onFailure(Call call, String errorMsg) {
                // 请求失败后的处理
            }
        });
    }

```
License
=======

    MIT License

    Copyright (c) 2020 XiongYu

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.




