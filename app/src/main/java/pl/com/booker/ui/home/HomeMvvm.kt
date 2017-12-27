package pl.com.booker.ui.home

import android.databinding.ObservableField
import pl.com.booker.ui.base.view.MvvmView
import pl.com.booker.ui.base.viewmodel.MvvmViewModel

class HomeMvvm {

    interface View : MvvmView

    interface ViewModel : MvvmViewModel<View> {
        val temperature: ObservableField<String>

    }

}