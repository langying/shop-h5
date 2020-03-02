cp -fr vip.jinliangcang.yml        src/main/resources/application-prod.yml
cp -fr vip.jinliangcang.properties src/main/resources/properties/jpush.properties

mvn clean package -Dmaven.test.skip=true
scp ./target/gold-app.jar root@h5.jinliangcang.vip:/root/apps/vip.jinliangcang.h5.jar

ssh root@h5.jinliangcang.vip > /dev/null 2>&1 << eeooff
  nohup java -jar /root/apps/vip.jinliangcang.h5.jar --spring.profiles.active=prod --server.port=8280 > /root/apps/vip.jinliangcang.h5.log &
  exit
eeooff
