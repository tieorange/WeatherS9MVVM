package pl.edu.pawelsienkiewicz.injection.modules


import dagger.Binds
import dagger.Module
import pl.edu.pawelsienkiewicz.ui.home.HomeMvvm
import pl.edu.pawelsienkiewicz.ui.home.HomeViewModel


@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindHomeViewModel(viewModel: HomeViewModel): HomeMvvm.ViewModel

    /*@Binds
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): MainMvvm.ViewModel
*/

}