package com.example.my_news.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.my_news.domain.manager.localUsermanager
import com.example.my_news.utils.contants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class localUsermanagerImple(
    private val context: Context
) :  localUsermanager {


    override suspend fun saveAppEntry() {
        context.dataStore.edit {setting->
            setting[preferenceKey.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {preferences->
            preferences[preferenceKey.APP_ENTRY]?: false
        }
    }

}

private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = contants.USER_SETTINGS)

private object preferenceKey{
    val APP_ENTRY = booleanPreferencesKey(name = contants.APP_ENTRY)
}