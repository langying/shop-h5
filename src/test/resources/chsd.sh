## https://www.jianshu.com/u/0690263bf2bd
## chmod u+x ./chsd/platforms/android/gradlew

cd shop-vue
npm run build

cd ..

cordova create chsd app.yunshu.shop 金粮仓

cd chsd
cordova platform add ios
cordova platform add android

cordova plugin add jpush-phonegap-plugin --variable APP_KEY=1093a256f5b1249a4985e220
cordova plugin add https://github.com/laden666666/cordovaDialogsPlus

cordova plugin add cordova-plugin-file                --save
cordova plugin add cordova-plugin-file-opener2        --save
cordova plugin add cordova-plugin-file-transfer       --save
cordova plugin add cordova-plugin-device              --save
cordova plugin add cordova-plugin-dialogs             --save
cordova plugin add cordova-plugin-vibration           --save
cordova plugin add cordova-plugin-backbutton          --save
cordova plugin add cordova-plugin-splashscreen        --save
cordova plugin add cordova-plugin-themeablebrowser    --save
cordova plugin add cordova-plugin-network-information --save
cordova plugin add cordova-plugin-android-permissions --save

cordova plugin ls

rm -fr platforms/android/app/src/main/assets/www/js
rm -fr platforms/android/app/src/main/assets/www/css
rm -fr platforms/android/app/src/main/assets/www/img
rm -fr platforms/android/app/src/main/assets/www/index.html
cp -fr ../shop-vue/template/* platforms/android/app/src/main/assets/www

cordova build android --release --verbose

cd ..
cp chsd/platforms/android/app/build/outputs/apk/release/app-release-unsigned.apk .
jarsigner -verbose -keystore shop-vue.keystore -signedjar yunshuapp.apk app-release-unsigned.apk yunshuapp

open .
