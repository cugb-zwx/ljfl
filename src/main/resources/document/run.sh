#!/bin/bash

ENV=$2

APP_NAME=ljfl-server-$ENV

APP_DIR=/usr/local/ljfl/$APP_NAME
JAR_FILE=$APP_NAME.jar
pid=0

#JVM
JVM_OPTS="-Duser.timezone=Asia/Shanghai -Xms2G -Xmx2G -XX:PermSize=256M -XX:MaxPermSize=512M -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDateStamps -XX:+UseParallelGC -XX:+UseParallelOldGC"

start(){
  checkpid
  if [ ! -n "$pid" ]; then
    echo "$APP_NAME start..."
    cd $APP_DIR
    if [ "$ENV" = "online" ]; then
        java -jar $JVM_OPTS $APP_DIR/$APP_NAME.jar --spring.profiles.active=$ENV
    else
        java -jar $APP_DIR/$APP_NAME.jar --spring.profiles.active=$ENV
    fi
    echo Start Success!
  else
      echo "$APP_NAME is runing PID: $pid"
  fi

}


status(){
   checkpid
   if [ ! -n "$pid" ]; then
     echo "$APP_NAME not runing"
   else
     echo "$APP_NAME runing PID: $pid"
   fi
}

checkpid(){
    echo "$APP_NAME checkpid..."
    pid=`ps -ef |grep $JAR_FILE |grep -v grep |awk '{print $2}'`
    echo "$APP_NAME pid=$pid"
}

stop(){
    checkpid
    if [ ! -n "$pid" ]; then
     echo "$APP_NAME not runing"
    else
      echo "$APP_NAME stop..."
      kill -9 $pid
    fi
}

restart(){
    stop
    sleep 1s
    start
}


case $1 in
          start) start;;
          stop)  stop;;
          restart)  restart;;
          status)  status;;
              *)  echo "require start|stop|restart|status"  ;;
esac