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
