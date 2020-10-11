#region Kotlinx.serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt # core serialization annotations

-keepclassmembers class kotlinx.serialization.json.** {
    *** Companion;
}
-keepclasseswithmembers class kotlinx.serialization.json.** {
    kotlinx.serialization.KSerializer serializer(...);
}

-keep,includedescriptorclasses class com.mforn.**.**$$serializer { *; }
-keepclassmembers class com.mforn.**.*Dto {
    *** Companion;
}
-keepclasseswithmembers class com.mforn.**.*Dto {
    kotlinx.serialization.KSerializer serializer(...);
}
#endregion