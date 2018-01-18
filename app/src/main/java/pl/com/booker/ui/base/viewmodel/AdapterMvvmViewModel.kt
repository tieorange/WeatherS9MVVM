package pl.edu.pawelsienkiewicz.ui.base.viewmodel

import android.support.v7.widget.RecyclerView

import pl.edu.pawelsienkiewicz.ui.base.view.MvvmView


interface AdapterMvvmViewModel<V : MvvmView> : MvvmViewModel<V> {

    val adapter: RecyclerView.Adapter<*>
}
