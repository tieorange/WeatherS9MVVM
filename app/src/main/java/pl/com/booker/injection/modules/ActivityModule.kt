package pl.edu.pawelsienkiewicz.injection.modules

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import pl.edu.pawelsienkiewicz.injection.scopes.PerActivity
import pl.edu.pawelsienkiewicz.ui.base.navigator.ActivityNavigator
import pl.edu.pawelsienkiewicz.ui.base.navigator.Navigator
import pl.edu.pawelsienkiewicz.injection.qualifier.ActivityContext
import pl.edu.pawelsienkiewicz.injection.qualifier.ActivityFragmentManager


@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @PerActivity
    @ActivityContext
    internal fun provideActivityContext(): Context {
        return activity
    }

    @Provides
    @PerActivity
    @ActivityFragmentManager
    internal fun provideFragmentManager(): FragmentManager {
        return activity.supportFragmentManager
    }

    @Provides
    @PerActivity
    internal fun provideNavigator(): Navigator {
        return ActivityNavigator(activity)
    }
}
