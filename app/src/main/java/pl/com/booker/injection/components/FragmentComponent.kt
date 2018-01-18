package pl.edu.pawelsienkiewicz.injection.components

import dagger.Component
import pl.edu.pawelsienkiewicz.injection.modules.FragmentModule
import pl.edu.pawelsienkiewicz.injection.modules.ViewModelModule
import pl.edu.pawelsienkiewicz.injection.scopes.PerFragment


@PerFragment
@Component(dependencies = arrayOf(ActivityComponent::class),
           modules = arrayOf(FragmentModule::class, ViewModelModule::class))
interface FragmentComponent {

//    fun inject(myDataFragment: MyDataFragment)
}
