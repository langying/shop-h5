cp -fr vip.chsd.yml        src/main/resources/application-prod.yml
cp -fr vip.chsd.properties src/main/resources/properties/jpush.properties

mvn clean package -Dmaven.test.skip=true
scp ./target/gold-app.jar root@dev.chsd.vip:/root/apps/vip.chsd.h5.jar

ssh root@dev.chsd.vip > /dev/null 2>&1 << eeooff
  nohup java -jar /root/apps/vip.chsd.h5.jar --spring.profiles.active=prod --server.port=8280 > /root/apps/vip.chsd.h5.log &
  exit
eeooff
