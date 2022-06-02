# Insider Java Sample App <img src="https://github.com/github/explore/raw/main/topics/java/java.png" alt="java" width="50" height="50"/>
For more information about android integration please check the [link](https://academy.useinsider.com/docs/android-integration)

Check the changelogs 👉 [here](https://academy.useinsider.com/docs/android-sdk-changelog)

## Before getting the build:

1. Change the partner name with yours in the [MyApplicationClass.java](https://github.com/useinsider/java-sample/blob/master/InsiderDemo/app/src/main/java/com/useinsider/InsiderDemo/MyApplicationClass.java#L18) file
2. Add your partner name to manifestPlaceholders in the module-level [build.gradle](https://github.com/useinsider/java-sample/blob/master/InsiderDemo/app/build.gradle#L8) file
3. Change the google-service.json file with yours
4. Change the agconnect-services.json file with yours(if you are using huawei messaging service)
5. Replace the [applicationId](https://github.com/useinsider/java-sample/blob/master/InsiderDemo/app/build.gradle#L11) with the one in your google-service.json file
