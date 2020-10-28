package com.fireflyon.hiltexample.view

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.fireflyon.hiltexample.R
import com.fireflyon.hiltexample.utils.SampleUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.view_sample.view.*
import javax.inject.Inject

@AndroidEntryPoint
class SampleView: ConstraintLayout {

    @Inject
    lateinit var sampleUtils: SampleUtils

    private lateinit var viewText: TextView

    constructor(context: Context): super(context){
        init(context = context, attrs = null)
    }

    constructor(context: Context,
                attrs: AttributeSet): super(context, attrs){
        init(context, attrs)
    }

    constructor(context: Context,
                attrs: AttributeSet?,
                defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?){
        inflate(context, R.layout.view_sample, this)
        viewText = textView
        print(sampleUtils.printInfo("View Class"))
    }

    fun setText(text: String){
        viewText.text = text
    }
}