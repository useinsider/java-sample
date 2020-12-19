# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class com.useinsider.insider.Insider { *; }
-keep interface com.useinsider.insider.InsiderCallback { *; }
-keep class com.useinsider.insider.InsiderUser { *; }
-keep interface com.useinsider.insider.InsiderUser$InsiderIDResult { *; }
-keep class com.useinsider.insider.InsiderProduct { *; }
-keep class com.useinsider.insider.InsiderEvent { *; }
-keep class com.useinsider.insider.InsiderCallbackTypes { *; }
-keep class com.useinsider.insider.InsiderGender { *; }
-keep interface com.useinsider.insider.Insider$TempStoreAction { *; }
-keep class com.useinsider.insider.RequestUtils { *; }
-keep interface com.useinsider.insider.RecommendationEngine$SmartRecommendation { *; }
-keep interface com.useinsider.insider.RequestUtils$MessageCenterData { *; }
-keep class com.useinsider.insider.Geofence { *; }
-keep class com.useinsider.insider.ContentOptimizerDataType { *; }
-keep class org.openudid.** { *; }
-keep class com.useinsider.insider.OpenUDID_manager { *; }