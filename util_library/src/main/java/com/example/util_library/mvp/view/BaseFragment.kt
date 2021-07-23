package com.example.mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mvp.presenter.IPresenter


abstract class BaseFragment<P : IPresenter> : Fragment(), IFragment, IView {
    protected var presenter: P? = null
    protected lateinit var mFview: View

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        mFview = inflater.inflate(bindLyout(), container, false)
        return mFview
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initData()
    }

    override fun <T : View> findViewById(id: Int): T {
        return mFview.findViewById(id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (presenter != null) {
            presenter!!.destory()
            presenter = null
        }
    }
}