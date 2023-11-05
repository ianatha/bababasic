-keep class com.google.common.io.** { *; }
-dontwarn com.google.common.io.**

-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}
-keep class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

-keep class org.antlr.** { *; }
-dontwarn org.antlr.**

-dontwarn java.awt.**
-dontwarn javax.swing.**

-keepnames class com.fasterxml.jackson.databind.** { *; }
-dontwarn com.fasterxml.jackson.databind.**

#-renamesourcefileattribute SourceFile
-dontwarn com.google.protobuf.java_com_google_android_gmscore_sdk_target_granule__proguard_group_gtm_N1281923064GeneratedExtensionRegistryLite$Loader
-dontwarn java.beans.BeanInfo
-dontwarn java.beans.FeatureDescriptor
-dontwarn java.beans.IntrospectionException
-dontwarn java.beans.Introspector
-dontwarn java.beans.PropertyDescriptor
-dontwarn com.google.protobuf.GeneratedExtensionRegistryLoader