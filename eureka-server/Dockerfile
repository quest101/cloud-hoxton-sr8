# 基于哪个镜像
From java:8
# 复制文件到容器
ADD eureka-server-1.0-SNAPSHOT.jar /eureka-server.jar
# 声明需要暴露的端口
EXPOSE 8761
# 配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","/eureka-server.jar"]