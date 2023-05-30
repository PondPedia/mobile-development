package com.aetherized.view.pondpediaview.ui.authenticated.home.add

import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.aetherized.view.pondpediaview.R
import com.aetherized.view.pondpediaview.data.model.PondFeed
import com.aetherized.view.pondpediaview.utils.customview.MyButton
import com.aetherized.view.pondpediaview.utils.helper.ReplaceListener
import com.google.android.material.textfield.TextInputEditText

class AddFragmentC : Fragment() {
    private lateinit var view: View
    private val addViewModel by activityViewModels<AddViewModel>()

    private lateinit var feedAmount: TextInputEditText
    private lateinit var feedProtein: TextInputEditText
    private lateinit var feedLipid: TextInputEditText
    private lateinit var feedCarbohydrate: TextInputEditText
    private lateinit var feedOthers: TextInputEditText
    private lateinit var feedFrequency: TextInputEditText
    private lateinit var submitButton: MyButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = inflater.inflate(R.layout.fragment_add_c, container, false)

        initializeView()
        setMyButtonEnable()

        submitButton.setOnClickListener {
            nextSection()
        }

        return view
    }

    private fun initializeView() {
        feedAmount = view.findViewById(R.id.amountEditText)
        feedProtein = view.findViewById(R.id.proteinEditText)
        feedLipid =  view.findViewById(R.id.lipidEditText)
        feedCarbohydrate =  view.findViewById(R.id.carbohydrateEditText)
        feedOthers =  view.findViewById(R.id.othersEditText)
        feedFrequency =  view.findViewById(R.id.frequencyEditText)
        submitButton = view.findViewById(R.id.submitButton)

        feedAmount.focusable = View.NOT_FOCUSABLE
        feedProtein.focusable = View.NOT_FOCUSABLE
        feedLipid.focusable = View.NOT_FOCUSABLE
        feedCarbohydrate.focusable = View.NOT_FOCUSABLE
        feedOthers.focusable = View.NOT_FOCUSABLE
        feedFrequency.focusable = View.NOT_FOCUSABLE

    }


    private fun insertValue(){
        addViewModel.pondFeed = PondFeed(
            "Default",
            feedAmount.text.toString().toFloat(),
            feedProtein.text.toString().toFloat(),
            feedLipid.text.toString().toFloat(),
            feedCarbohydrate.text.toString().toFloat(),
            feedOthers.text.toString().toFloat(),
            feedFrequency.text.toString().toInt(),
        )
    }
    private fun dataIsFilled(): Boolean = (
            (feedAmount.text.toString() != "") && (feedProtein.text.toString() != "") && (feedLipid.text.toString() != "") && (feedCarbohydrate.text.toString() != "") && (feedOthers.text.toString() != "") && (feedFrequency.text.toString() != ""))

    private fun setMyButtonEnable() {
        if (dataIsFilled()) {
            submitButton.text = "Next Section!"
            submitButton.isEnabled = true
            insertValue()
        }

        Log.d("FragmentC", dataIsFilled().toString())
    }

    private fun nextSection() {
        (activity as? ReplaceListener)?.onReplace("D")
    }

}