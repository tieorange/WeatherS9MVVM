package pl.edu.pawelsienkiewicz.injection.components

import android.content.Context
import android.support.v4.app.FragmentManager
import dagger.Component
import pl.edu.pawelsienkiewicz.injection.modules.ActivityModule
import pl.edu.pawelsienkiewicz.injection.modules.ViewModelModule
import pl.edu.pawelsienkiewicz.injection.qualifier.ActivityContext
import pl.edu.pawelsienkiewicz.injection.qualifier.ActivityFragmentManager
import pl.edu.pawelsienkiewicz.injection.scopes.PerActivity
import pl.edu.pawelsienkiewicz.ui.base.navigator.Navigator
import pl.edu.pawelsienkiewicz.ui.home.HomeActivity


@PerActivity
@Component(dependencies = arrayOf(AppComponent::class),
           modules = arrayOf(ActivityModule::class, ViewModelModule::class))
interface ActivityComponent : AppComponent {

    @ActivityContext fun activityContext(): Context
    @ActivityFragmentManager fun defaultFragmentManager(): FragmentManager
    fun navigator(): Navigator
//    fun errorHandlerCargo(): ErrorHandler

//    fun inject(activity: MainActivity)
    fun inject(activity: HomeActivity)
}
