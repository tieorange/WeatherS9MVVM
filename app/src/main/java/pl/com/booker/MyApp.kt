package pl.com.booker

import android.content.Context
import android.content.res.Resources
import android.net.TrafficStats
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy.Builder
import android.os.StrictMode.VmPolicy
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import io.reactivex.plugins.RxJavaPlugins
import pl.com.booker.injection.components.AppComponent
import pl.com.booker.injection.components.DaggerAppComponent
import pl.com.booker.injection.modules.AppModule
import pl.com.booker.injection.modules.NetModule
import timber.log.Timber

class MyApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        TrafficStats.setThreadStatsTag(1000)
        enableStrictMode()

        instance = this
        Timber.plant(Timber.DebugTree())
        RxJavaPlugins.setErrorHandler({ Timber.e(it) })

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule(this))
                .build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    private fun enableStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                    Builder()
                            .detectAll()
                            .penaltyLog()
                            .build()
            )
            StrictMode.setVmPolicy(
                    VmPolicy.Builder()
                            .detectAll()
                            .penaltyLog()
                            .build()
            )
        }
    }

    companion object {
        val BASE_URL = "https://41199309-bce5-4722-b287-77f1d61b140a.mock.pstmn.io/"

        lateinit var instance: MyApp
            private set

        lateinit var appComponent: AppComponent
            private set

        val res: Resources
            get() = instance.resources
    }
}