# micro-service
eureka
hosts需配置:backupIP masterIP

nohup java -jar eureka.jar --spring.profiles.active=backup &
nohup java -jar eureka.jar --spring.profiles.active=master &
logback.xml
<appender-ref ref="STDOUT" />   如果注意掉那么ide控制台不会输入日志


/usr/local/nginx/
        listen       1157;
        server_name  api.nextsgo.com;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;

 
        location /send {
            
            proxy_pass http://localhost:7680/msg/send;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header REMOTE-HOST $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        }
        location /admin/ {
            proxy_pass   http://192.168.1.103:1002/;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header REMOTE-HOST $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        }  
/usr/local/ngrokclient/
端口开发的开放的问题 7999 7998
zookeeper
1.4 启动和停止
进入bin目录，启动、停止、重启分和查看当前节点状态（包括集群中是何角色）别执行：
./zkServer.sh start
./zkServer.sh stop
./zkServer.sh restart
./zkServer.sh status

kafka要启动
4、启动Kafka
•	启动
进入kafka目录，敲入命令 bin/kafka-server-start.sh config/server.properties &
•	检测2181与9092端口
netstat -tunlp|egrep "(2181|9092)"
tcp        0      0 :::2181                     :::*                        LISTEN      19787/java          
tcp        0      0 :::9092                     :::*                        LISTEN      28094/java 

