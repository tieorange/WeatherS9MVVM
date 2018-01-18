package pl.edu.pawelsienkiewicz.injection.modules

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import pl.edu.pawelsienkiewicz.injection.qualifier.ChildFragmentManager
import pl.edu.pawelsienkiewicz.injection.scopes.PerFragment
import pl.edu.pawelsienkiewicz.ui.base.navigator.ChildFragmentNavigator
import pl.edu.pawelsienkiewicz.ui.base.navigator.FragmentNavigator


@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @PerFragment
    @ChildFragmentManager
    internal fun provideChildFragmentManager(): FragmentManager {
        return fragment.childFragmentManager
    }

    @Provides
    @PerFragment
    internal fun provideFragmentNavigator(): FragmentNavigator {
        return ChildFragmentNavigator(fragment)
    }

    /*@Provides
    @PerFragment
    internal fun providesErrorHandler(): ErrorHandler {
        return ErrorHandler(fragment.context, ActivityNavigator(fragment.activity))
    }*/
}
