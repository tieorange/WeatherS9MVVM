package pl.edu.pawelsienkiewicz.injection.components

import dagger.Component
import pl.edu.pawelsienkiewicz.injection.modules.ViewModelModule
import pl.edu.pawelsienkiewicz.injection.modules.ViewHolderModule
import pl.edu.pawelsienkiewicz.injection.scopes.PerViewHolder


@PerViewHolder
@Component(
        dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(ViewHolderModule::class, ViewModelModule::class)
)
interface ViewHolderComponent {

}
