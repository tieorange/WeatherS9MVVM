package pl.com.booker.ui.home

import android.content.Context
import android.os.Bundle
import pl.com.booker.injection.qualifier.AppContext
import pl.com.booker.injection.scopes.PerActivity
import pl.com.booker.ui.base.viewmodel.RxBaseViewModel
import javax.inject.Inject

@PerActivity
class HomeViewModel
@Inject
constructor(@AppContext private val context: Context) : RxBaseViewModel<HomeMvvm.View>(),
                                                        HomeMvvm.ViewModel {

    override fun attachView(view: HomeMvvm.View, savedInstanceState: Bundle?) {
        super.attachView(view, savedInstanceState)
    }

}