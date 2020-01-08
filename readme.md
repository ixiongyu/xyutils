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