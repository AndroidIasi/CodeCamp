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

-keepclassmembers class ** {
   public void onEvent*(**);
}

# Keep our interfaces so they can be used by other ProGuard rules.
# See http://sourceforge.net/p/proguard/bugs/466/
-keep,allowobfuscation @interface com.facebook.common.internal.DoNotStrip

# Do not strip any method/class that is annotated with @DoNotStrip
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}

-keep class com.facebook.common.** { *;}
-keep enum com.facebook.common.**
-keep interface com.facebook.common.**
-keepclassmembers class com.facebook.common.** { *;}
-keepclassmembers enum com.facebook.common.** { *;}
-keepclassmembers interface com.facebook.common.** { *;}
-keepclassmembernames class com.facebook.common.** { *;}
-keepclassmembernames enum com.facebook.common.** { *;}
-keepclassmembernames interface com.facebook.common.** { *;}

# Keep native methods
-keepclassmembers class * {
    native <methods>;
}

-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn com.android.volley.toolbox.**

-keep class ro.androidiasi.** { *;}
-keep enum ro.androidiasi.**
-keep interface ro.androidiasi.**
-keepclassmembers class ro.androidiasi.** { *;}
-keepclassmembers enum ro.androidiasi.** { *;}
-keepclassmembers interface ro.androidiasi.** { *;}
-keepclassmembernames class ro.androidiasi.** { *;}
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

# Glide specific rules #
# https://github.com/bumptech/glide

-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}
