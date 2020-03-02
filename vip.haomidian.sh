cp -fr vip.haomidian.yml        src/main/resources/application-prod.yml
cp -fr vip.haomidian.properties src/main/resources/properties/jpush.properties

mvn clean package -Dmaven.test.skip=true
scp ./target/gold-app.jar root@haomidian.vip:/root/apps/vip.haomidian.h5.jar

ssh root@haomidian.vip > /dev/null 2>&1 << eeooff
  nohup java -jar /root/apps/vip.haomidian.h5.jar --spring.profiles.active=prod --server.port=8080 > /root/apps/vip.haomidian.h5.log &
  exit
eeooff
