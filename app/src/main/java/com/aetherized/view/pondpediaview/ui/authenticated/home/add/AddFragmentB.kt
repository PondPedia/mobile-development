package com.aetherized.view.pondpediaview.ui.authenticated.home.add

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.aetherized.view.pondpediaview.R
import com.aetherized.view.pondpediaview.data.model.PondFish
import com.aetherized.view.pondpediaview.utils.customview.MyButton
import com.aetherized.view.pondpediaview.utils.helper.ReplaceListener
import com.google.android.material.textfield.TextInputEditText

class AddFragmentB : Fragment() {
    private lateinit var view: View
    private val addViewModel by activityViewModels<AddViewModel>()

    private lateinit var fishType: TextInputEditText
    private lateinit var fishAmount: TextInputEditText
    private lateinit var fishHarvest: TextInputEditText
    private lateinit var submitButton: MyButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = inflater.inflate(R.layout.fragment_add_b, container, false)

        initializeView()
        setupAction()
        insertValue()
        return view
    }

    private fun initializeView() {
        fishType = view.findViewById(R.id.fishTypeEditText)
        fishAmount = view.findViewById(R.id.fishAmountEditText)
        fishHarvest = view.findViewById(R.id.fishHarvestEditText)
        submitButton = view.findViewById(R.id.submitButton)

        fishType.focusable = View.NOT_FOCUSABLE

        submitButton.text = "Fill all the data"
    }


    private fun insertValue(){
        addViewModel.pondFish = PondFish(
            1,
            fishType.text.toString(),
            fishAmount.text.toString().toFloatOrNull(),
            fishHarvest.text.toString().toFloatOrNull(),
        )
    }

    private fun dataIsFilled(): Boolean = (
            (fishType.text.toString() != "") && (fishAmount.text.toString() != "") && (fishHarvest.text.toString() != ""))

    private fun setMyButtonEnable() {
        submitButton.isEnabled = dataIsFilled()
        addViewModel.fishDataFilled = dataIsFilled()
        if (dataIsFilled()) {

            submitButton.text = "Next Section!"
        }
        insertValue()

        Log.d("FragmentB", dataIsFilled().toString())
    }

    private fun nextSection() {
        (activity as? ReplaceListener)?.onReplace("C")
    }

    private fun setupAction() {
        fishAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        fishHarvest.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        submitButton.setOnClickListener {
            nextSection()
        }
    }
}