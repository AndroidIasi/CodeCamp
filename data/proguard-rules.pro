# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/andrei/Developer/android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-dontwarn
-ignorewarnings

-keep class ro.androidiasi.** { *;}
-keep enum ro.androidiasi.**
-keep interface ro.androidiasi.**
-keepclassmembers class ro.androidiasi.** { *;}
-keepclassmembers enum ro.androidiasi.** { *;}
-keepclassmembers interface ro.androidiasi.** { *;}
-keepclassmembernames class ro.androidiasi.** {
    <methods>;
    *;
}
-keepclassmembernames enum ro.androidiasi.** { *;}
-keepclassmembernames interface ro.androidiasi.** { *;}

-dontwarn sun.reflect.**
-dontwarn java.beans.**
-keep,allowshrinking class com.esotericsoftware.** {
   <fields>;
   <methods>;
}
-keep,allowshrinking class java.beans.** { *; }
-keep,allowshrinking class sun.reflect.** { *; }
-keep,allowshrinking class com.esotericsoftware.kryo.** { *; }
-keep,allowshrinking class com.esotericsoftware.kryo.io.** { *; }
-keep,allowshrinking class sun.nio.ch.** { *; }
-dontwarn sun.nio.ch.**
-dontwarn sun.misc.**

-keep,allowshrinking class com.snappydb.** { *; }
-dontwarn com.snappydb.**

-keepattributes *Annotation*,EnclosingMethod,Signature
-keepnames class com.fasterxml.jackson.** { *; }
 -dontwarn com.fasterxml.jackson.databind.**
 -keep class org.codehaus.** { *; }
 -keepclassmembers public final enum org.codehaus.jackson.annotate.JsonAutoDetect$Visibility {
 public static final org.codehaus.jackson.annotate.JsonAutoDetect$Visibility *; }
-keep public class your.class.** {
  public void set*(***);
  public *** get*();
}