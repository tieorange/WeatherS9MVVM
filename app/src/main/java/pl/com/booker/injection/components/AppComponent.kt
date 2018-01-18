package pl.edu.pawelsienkiewicz.injection.components

import android.content.Context
import android.content.res.Resources
import dagger.Component
import pl.edu.pawelsienkiewicz.data.remote.MyApi
import pl.edu.pawelsienkiewicz.injection.modules.AppModule
import pl.edu.pawelsienkiewicz.injection.modules.DataModule
import pl.edu.pawelsienkiewicz.injection.modules.NetModule
import pl.edu.pawelsienkiewicz.injection.qualifier.AppContext
import pl.edu.pawelsienkiewicz.injection.scopes.PerApplication
import pl.edu.pawelsienkiewicz.util.LoginManager


@PerApplication
@Component(modules = arrayOf(AppModule::class, NetModule::class, DataModule::class))
interface AppComponent {
    @AppContext fun appContext(): Context
    fun resources(): Resources

    fun myApi(): MyApi
    fun loginManager(): LoginManager
}

