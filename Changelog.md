# 11.7.0

Android Channels custom sound issue is fixed.

### Changed

`getSmartRecommendationWithProduct` method taxonomy parameter minimum array size has been changed from 2 to 1.

### Added

- Stock existence product attribute has been added.

```java
public InsiderProduct setInStock(boolean isInStock)
```
# 11.6.1-nh

`nh` stands for non-huawei.

Same as 11.6.1 without any Huawei dependencies and services.

# 11.6.1

Minor changes.

# 11.6.0-nh

`nh` stands for non-huawei.

Same as 11.6.0 without any Huawei dependencies and services.

# 11.6.0

Google policy update adaptation.

### Removed

- Rule has been removed from proguard.

```pro
-keep class com.useinsider.insider.Vendor { *; }
```

- Amplification has been removed.

```java
public void getAutoStartPermission(Vendor[] vendors)
```

# 11.5.2

Template Store improvements has been done.

# 11.5.1

Logic improvement has been done for Insider ID retrieval logic.

# 11.5.0

### Added

- New proguard rule has been added.

```pro
-keep interface com.useinsider.insider.InsiderUser$InsiderIDResult { *; }
```

- Login method with retrieving Insider ID has been added.

```java
 public void login(InsiderIdentifiers identifiers, InsiderIDResult insiderIDResult)
```

### Changed

- Huawei dependency versions updated in Insider build gradle.

```gradle
implementation 'com.huawei.hms:push:5.0.4.302'
implementation 'com.huawei.hms:ads-identifier:3.4.34.301'
implementation 'com.huawei.hms:location:4.0.4.300'
```

- `minSdkVersion` has been set to 17.

```gradle
minSdkVersion 17
```

- `compileSdkVersion` and `targetSdkVersion` has been set to 30.

# 11.4.0

StrandHogg vulnerability fix.

Some improvements.

Setting user identifiers as attributes now requires successful unification.

### Changed

- `getSearchData` method signature has been changed. 

```java
public void getSearchData(String searchQuery, String currency, String locale, InsiderSearchAPI.SearchResult searchResult)
```

- `getSmartRecommendationWithProduct` method signature has been changed.

```java
public void getSmartRecommendationWithProduct(InsiderProduct product, int recommendationID, String locale, RecommendationEngine.SmartRecommendation smartRecommendation)
```

- `getSmartRecommendation` method signature has been changed.

```java
public void getSmartRecommendation(int recommendationID, String locale, String currency, RecommendationEngine.SmartRecommendation smartRecommendation)
```

# 11.3.0-nh

`nh` stands for non-huawei.

Huawei related dependencies and services has been removed.

### Removed

- Huawei dependencies has been removed from Insider build.gradle file.

```gradle
implementation 'com.huawei.hms:push:4.0.2.300'
implementation 'com.huawei.hms:ads-identifier:3.4.28.305'
implementation 'com.huawei.hms:location:4.0.1.300'
```

- HMS notification handler has been removed.

```java
public void handleHMSNotification(Context context, com.huawei.hms.push.RemoteMessage message)
```

# 11.3.0

## Added

- New proguard rule has been added.

```pro
-keep interface com.useinsider.insider.InsiderSearchAPI$SearchResult { *; }
```

- IDFA collection has been disabled by default.

```java
public void enableIDFACollection(boolean enableIDFACollection)
```

- Insider Search API has been added.

```java
 public void getSearchData(String searchQuery, String currency, InsiderSearchAPI.SearchResult searchResult)
```


# 11.2.0

SDK host url changed.

ACCESS_BACKGROUND_LOCATION permission check for an exception added.

### Removed

- `setEmail` has been removed from InsiderUser. You can use `InsiderIdentifiers`.

```java
 public InsiderUser setEmail(String email)
```

- `setPhoneNumber` has been removed from InsiderUser. You can use `InsiderIdentifiers`.

```java
 public InsiderUser setPhoneNumber(String phoneNumber)
```

### Added

- Event count limitation per session has been added.
- Smart Recommendation logging feature added.

```java
 public void clickSmartRecommendationProduct(int recommendationID, InsiderProduct product)
```

- Locale attribute has been added.
  
```java
 public InsiderUser setLocale(String locale)
```

### Changed


- SDK url has been changed from `https://mobile.useinsider.com` to `https://mobilesdk.useinsider.com/android`.

```gradle
maven { url "https://mobilesdk.useinsider.com/android" }
```

# 11.1.0

Unification request optimizations, minor bug fixes has been done.

Custom identifiers capability has been added.

### Removed

- Icon changer feature has been removed from SDK.

### Added

- Regex validation has been added for `addEmail` method.

```java
"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"
```

- Regex validation has been added for `addPhoneNumber`

```java
"^\\+[1-9]\\d{1,14}$"
```

- Custom identifier setting with key value pair has been added.

```java
public InsiderIdentifiers addCustomIdentifier(String key, String value)
```

### Changed

- `'androidx.lifecycle:lifecycle-extensions:2.0.0'` has been changed to:

```gradle
implementation 'androidx.lifecycle:lifecycle-process:2.2.0'
```

# 11.0.0

Huawei Messaging Services has been added.

Notification handling methods has been changed accordingly.

### Removed

```java
public void handleNotification(Context context, RemoteMessage message)
```

### Added

```java
public void handleFCMNotification(Context context, RemoteMessage message)
public void handleHMSNotification(Context context, com.huawei.hms.push.RemoteMessage message)
```

**HMS Core Services has been integrated.**

You need to have following integrations in your project level build.gradle file.

- `maven { url "http://developer.huawei.com/repo/"}` under the buildscript.
- `classpath 'com.huawei.agconnect:agcp:1.4.2.300'` under the dependencies.
- `maven {url "http://developer.huawei.com/repo/"}` under the all projects.

A full example can be found here:

```gradle
buildscript {
    repositories {
        google()
        jcenter()
        maven { url "http://developer.huawei.com/repo/"}
    }

    dependencies {
        classpath 'com.android.tools.build:gradle:4.0.0'
        classpath 'com.google.gms:google-services:4.3.4'
        classpath 'com.huawei.agconnect:agcp:1.4.2.300'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {url "https://mobilesdk.useinsider.com/android"}
        maven {url "http://developer.huawei.com/repo/"}
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```

You need to have `agconnect-services.json` under your app folder.

You need to have following integrations in your module level build.gradle.

- `implementation 'com.huawei.hms:push:5.0.4.302'`
  `implementation 'com.huawei.hms:ads-identifier:3.4.34.301'`
  `implementation 'com.huawei.hms:location:4.0.4.300'`
  under the dependencies.
- `apply plugin: 'com.huawei.agconnect'` in the main level.
- `minSdkVersion` must be 19 or higher.

A full example can be found here:

```gradle
apply plugin: 'com.android.application'

android {
    compileSdkVersion 30
    defaultConfig {
        // TODO: Please change with your partner name.
        manifestPlaceholders = [partner:"yourpartnername"]
        // TODO: Please change with your application ID as it is in google-service.json and agconnect-services.json.
        applicationId "com.useinsider.InsiderDemo"
        minSdkVersion 23
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'

    //Optional for Geofence
    implementation 'com.google.android.gms:play-services-location:17.0.0'

    //Required
    implementation 'com.google.firebase:firebase-messaging:20.2.0'
    implementation 'androidx.lifecycle:lifecycle-process:2.2.0'
    implementation 'com.useinsider:insider:11.5.1'
    implementation 'com.google.android.gms:play-services-ads:16.0.0'

    implementation 'com.huawei.hms:push:5.0.4.302'
    implementation 'com.huawei.hms:ads-identifier:3.4.34.301'
    implementation 'com.huawei.hms:location:4.0.4.300'
}
//Required
apply plugin: 'com.google.gms.google-services'
apply plugin: 'com.huawei.agconnect'
```

### Changed

Minimum Android SDK version has been set to 19 due to HMS requirements. 

```gradle
minSdkVersion 19
```
