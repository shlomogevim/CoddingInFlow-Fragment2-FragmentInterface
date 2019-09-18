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
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {


    var listener:FregmatBListener?=null



    interface FregmatBListener{
        fun onInputBSent(input:CharSequence)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        view.button_second.setOnClickListener {
            val input=textView_second.text
            listener?.onInputBSent(input)
        }




        return view
    }

    fun updateEditText(newText:CharSequence){
        textView_second.text= newText as Editable?
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FregmatBListener){
            listener=context as FregmatBListener
        }else{
            throw RuntimeException(context.toString()+" must implement FragmentBListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener=null
    }

}
