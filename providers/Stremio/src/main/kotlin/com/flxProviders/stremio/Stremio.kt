package com.flxProviders.stremio

import android.content.Context
import androidx.compose.runtime.Composable
import com.boooplay.provider.FlixclusiveProvider
import com.boooplay.provider.Provider
import com.boooplay.provider.ProviderApi
import com.flxProviders.stremio.api.StremioApi
import com.flxProviders.stremio.settings.StreamioScreen
import okhttp3.OkHttpClient


@FlixclusiveProvider
class Stremio : Provider() {
    private var client: OkHttpClient
        = OkHttpClient() // For safety

    @Composable
    override fun SettingsScreen() {
        StreamioScreen(
            settings = settings,
            client = client
        )
    }

    override fun getApi(
        context: Context,
        client: OkHttpClient
    ): ProviderApi {
        this.client = client

        return StremioApi(
            provider = this,
            client = client,
            settings = settings
        )
    }
}
