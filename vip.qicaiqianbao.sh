cp -fr vip.qicaiqianbao.yml        src/main/resources/application-prod.yml
cp -fr vip.qicaiqianbao.properties src/main/resources/properties/jpush.properties

mvn clean package -Dmaven.test.skip=true
scp ./target/gold-app.jar root@h5.qicaiqianbao.vip:/root/apps/vip.qicaiqianbao.h5.jar

ssh root@h5.qicaiqianbao.vip > /dev/null 2>&1 << eeooff
  nohup java -jar /root/apps/vip.qicaiqianbao.h5.jar --spring.profiles.active=prod --server.port=8080 > /root/apps/vip.qicaiqianbao.h5.log &
  exit
eeooff
