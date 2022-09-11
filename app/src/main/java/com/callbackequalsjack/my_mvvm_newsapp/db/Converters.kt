package com.callbackequalsjack.my_mvvm_newsapp.db

import androidx.room.TypeConverter
import com.callbackequalsjack.my_mvvm_newsapp.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String = source.name

    @TypeConverter
    fun toSource(name: String): Source = Source(name, name)
}