package pl.edu.pawelsienkiewicz.injection.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pl.edu.pawelsienkiewicz.BuildConfig
import pl.edu.pawelsienkiewicz.MyApp
import pl.edu.pawelsienkiewicz.data.remote.MyApi
import pl.edu.pawelsienkiewicz.injection.qualifier.AppContext
import pl.edu.pawelsienkiewicz.injection.scopes.PerApplication
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.*

@Module
class NetModule(@AppContext private val context: Context) {

    @Provides
    @PerApplication
    internal fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @PerApplication
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(ChuckInterceptor(context))
                .build()
    }

    @Provides
    @PerApplication
    internal fun provideMyApi(gson: Gson, okHttpClient: OkHttpClient): MyApi {
        val httpClientBuilder = okHttpClient.newBuilder().connectTimeout(20, MINUTES)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClientBuilder.addInterceptor(loggingInterceptor)
        }

        return Retrofit.Builder()
                .baseUrl(MyApp.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .callFactory(httpClientBuilder.build())
                .build().create(MyApi::class.java)
    }
}
