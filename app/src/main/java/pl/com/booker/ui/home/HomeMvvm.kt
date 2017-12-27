package pl.com.booker.ui.home

import pl.com.booker.ui.base.view.MvvmView
import pl.com.booker.ui.base.viewmodel.MvvmViewModel

class HomeMvvm {

    interface View : MvvmView

    interface ViewModel : MvvmViewModel<View> {

    }

}