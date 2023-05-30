package com.aetherized.view.pondpediaview.ui.authenticated.home.add

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.aetherized.view.pondpediaview.R
import com.aetherized.view.pondpediaview.data.model.PondWater
import com.aetherized.view.pondpediaview.utils.customview.MyButton
import com.aetherized.view.pondpediaview.utils.helper.ReplaceListener
import com.aetherized.view.pondpediaview.utils.helper.ResetListener
import com.google.android.material.textfield.TextInputEditText

class AddFragmentA : Fragment() {
    private lateinit var view: View
    private val addViewModel by activityViewModels<AddViewModel>()

    private lateinit var pondName: TextInputEditText
    private lateinit var pondLength: TextInputEditText
    private lateinit var pondWidth: TextInputEditText
    private lateinit var pondDepth: TextInputEditText
    private lateinit var pondTemperature: TextInputEditText
    private lateinit var pondTurbidity: TextInputEditText
    private lateinit var pondDissolvedOxygen: TextInputEditText
    private lateinit var pondPH: TextInputEditText
    private lateinit var pondAmmonia: TextInputEditText
    private lateinit var pondNitrate: TextInputEditText
    private lateinit var submitButton: MyButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = inflater.inflate(R.layout.fragment_add_a, container, false)

        initializeView()
        setupAction()
        insertValue()
        return view
    }

    private fun initializeView() {
        pondName = view.findViewById(R.id.nameEditText)
        pondLength = view.findViewById(R.id.lengthEditText)
        pondWidth = view.findViewById(R.id.widthEditText)
        pondDepth = view.findViewById(R.id.depthEditText)
        pondTemperature = view.findViewById(R.id.temperatureEditText)
        pondTurbidity = view.findViewById(R.id.turbidityEditText)
        pondDissolvedOxygen = view.findViewById(R.id.oxygenEditText)
        pondPH = view.findViewById(R.id.phEditText)
        pondAmmonia = view.findViewById(R.id.ammoniaEditText)
        pondNitrate = view.findViewById(R.id.nitrateEditText)
        submitButton = view.findViewById(R.id.submitButton)
        submitButton.text = "Fill all the data"
    }

    private fun insertValue(){
        addViewModel.pondName = pondName.text.toString()
        addViewModel.pondLength = pondLength.text.toString().toFloatOrNull()
        addViewModel.pondWidth = pondWidth.text.toString().toFloatOrNull()
        addViewModel.pondDepth = pondDepth.text.toString().toFloatOrNull()
        addViewModel.pondWater = PondWater(
            pondTemperature.text.toString().toFloatOrNull(),
            pondTurbidity.text.toString().toFloatOrNull(),
            pondDissolvedOxygen.text.toString().toFloatOrNull(),
            pondPH.text.toString().toFloatOrNull(),
            pondAmmonia.text.toString().toFloatOrNull(),
            pondNitrate.text.toString().toFloatOrNull(),
        )
    }
    private fun dataIsFilled(): Boolean = (
            (pondName.text.toString() != "") && (pondLength.text.toString() != "") && (pondWidth.text.toString() != "") && (pondDepth.text.toString() != "") && (pondTemperature.text.toString() != "")
                    && (pondTurbidity.text.toString() != "") && (pondDissolvedOxygen.text.toString() != "") && (pondPH.text.toString() != "") && (pondAmmonia.text.toString() != "") && (pondNitrate.text.toString() != ""))

    private fun setMyButtonEnable() {
        submitButton.isEnabled = dataIsFilled()
        addViewModel.pondDataFilled = dataIsFilled()
        if (dataIsFilled()) {
            submitButton.text = "Next Section!"
        }
        insertValue()
        Log.d("FragmentD", dataIsFilled().toString())
    }

    private fun nextSection() {
        (activity as? ReplaceListener)?.onReplace("B")
    }

    private fun setupAction() {
        pondName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        pondLength.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        pondWidth.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        pondDepth.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        pondTemperature.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        pondTurbidity.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        pondDissolvedOxygen.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        pondPH.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        pondAmmonia.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })
        pondNitrate.addTextChangedListener(object : TextWatcher {
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