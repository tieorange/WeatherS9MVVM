package pl.com.booker.injection.modules


import dagger.Binds
import dagger.Module
import pl.com.booker.ui.home.HomeMvvm
import pl.com.booker.ui.home.HomeViewModel


@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindHomeViewModel(viewModel: HomeViewModel): HomeMvvm.ViewModel

    /*@Binds
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): MainMvvm.ViewModel
*/

}