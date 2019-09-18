package com.example.coddinginflow_fragment2_fragmentinterface


import android.content.Context
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.view.*


class FirstFragment : Fragment() {

     var listener:FregmatAListener?=null

    interface FregmatAListener{
        fun onInputASent(input:CharSequence)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        view.button_first.setOnClickListener {
            val input=textView_first.text
            listener?.onInputASent(input)
        }

        return view
    }

    fun updateEditText(newText:CharSequence){
        textView_first.text= newText as Editable?
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FregmatAListener){
            listener=context as FregmatAListener
        }else{
            throw RuntimeException(context.toString()+" must implement FragmentAListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener=null
    }


}
