package com.aetherized.view.pondpediaview.ui.authenticated.home.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.aetherized.view.pondpediaview.R
import com.aetherized.view.pondpediaview.data.local.entity.PondEntity
import com.aetherized.view.pondpediaview.data.local.entity.PondLogEntity
import com.aetherized.view.pondpediaview.data.model.PondFeed
import com.aetherized.view.pondpediaview.data.model.PondFish
import com.aetherized.view.pondpediaview.data.model.PondWater
import com.aetherized.view.pondpediaview.ui.authenticated.home.pond.PondViewModel
import com.aetherized.view.pondpediaview.ui.authenticated.pond.logs.PondLogViewModel
import com.aetherized.view.pondpediaview.utils.customview.MyButton
import com.aetherized.view.pondpediaview.utils.helper.ResetListener
import com.aetherized.view.pondpediaview.utils.helper.ViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.sql.Timestamp

class AddFragmentD : Fragment() {
    private lateinit var view: View
    private val addViewModel  by activityViewModels<AddViewModel>()

    private val viewModelFactory by lazy { ViewModelFactory.getInstance(requireContext()) }
    private val pondViewModel by viewModels<PondViewModel> { viewModelFactory }
    private val pondLogViewModel by viewModels<PondLogViewModel> { viewModelFactory }

    private lateinit var createButton: MyButton


    private lateinit var pondName: TextView
    private lateinit var pondLength: TextView
    private lateinit var pondWidth: TextView
    private lateinit var pondDepth: TextView
    private lateinit var pondTemperature: TextView
    private lateinit var pondTurbidity: TextView
    private lateinit var pondDissolvedOxygen: TextView
    private lateinit var pondPH: TextView
    private lateinit var pondAmmonia: TextView
    private lateinit var pondNitrate: TextView
    private lateinit var fishType: TextView
    private lateinit var fishAmount: TextView
    private lateinit var fishHarvest: TextView
    private lateinit var feedAmount: TextView
    private lateinit var feedProtein: TextView
    private lateinit var feedLipid: TextView
    private lateinit var feedCarbohydrate: TextView
    private lateinit var feedOthers: TextView
    private lateinit var feedFrequency: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = inflater.inflate(R.layout.fragment_add_d, container, false)

        initializeView()
        setMyButtonEnable()
        setupAction()
        initializeValue()

        return view
    }

    override fun onResume() {
        super.onResume()
        initializeValue()
    }

    private suspend fun savePondData() {
        val currentTimeMillis = System.currentTimeMillis()
        val timestamp = Timestamp(currentTimeMillis)
        val pond = PondEntity(
            pondName = addViewModel.pondName ?: "",
            pondLength = addViewModel.pondLength ?: 0f,
            pondWidth = addViewModel.pondWidth ?: 0f,
            pondDepth = addViewModel.pondDepth ?: 0f,
            pondFish = addViewModel.pondFish ?: PondFish(0,"", 0f, 0f),
            pondFeed = addViewModel.pondFeed ?: PondFeed("",0f, 0f, 0f, 0f, 0f, 0),
            pondWater = addViewModel.pondWater ?: PondWater(0f, 0f, 0f, 0f, 0f, 0f),
            createdAt = timestamp.toString(),
            updatedAt = null
        )
        val insertedPond = withContext(Dispatchers.IO) {
            pondViewModel.insertPond(pond)
        }
        val pondLog = PondLogEntity (
            pondId = insertedPond.toInt(),
            action = "Pond Created",
            pondWater = addViewModel.pondWater ?: PondWater(0f, 0f, 0f, 0f, 0f, 0f),
            timestamp = timestamp.toString(),
        )

        pondLogViewModel.insertPondLog(pondLog)
    }

    private fun initializeValue() {
        pondName.text = addViewModel.pondName
        pondLength.text = addViewModel.pondLength.toString()
        pondWidth.text = addViewModel.pondWidth.toString()
        pondDepth.text = addViewModel.pondDepth.toString()
        pondTemperature.text = addViewModel.pondWater?.temperature.toString()
        pondTurbidity.text = addViewModel.pondWater?.turbidity.toString()
        pondDissolvedOxygen.text = addViewModel.pondWater?.dissolvedOxygen.toString()
        pondPH.text = addViewModel.pondWater?.pH.toString()
        pondAmmonia.text = addViewModel.pondWater?.ammonia.toString()
        pondNitrate.text = addViewModel.pondWater?.nitrate.toString()
        fishType.text = addViewModel.pondFish?.name ?: "-"
        fishAmount.text = addViewModel.pondFish?.amount.toString()
        fishHarvest.text = addViewModel.pondFish?.weight.toString()
        feedAmount.text = addViewModel.pondFeed?.feedPercentage.toString()
        feedProtein.text = addViewModel.pondFeed?.proteintPercentage.toString()
        feedLipid.text = addViewModel.pondFeed?.lipidPercentage.toString()
        feedCarbohydrate.text = addViewModel.pondFeed?.carbohydratePercentage.toString()
        feedOthers.text = addViewModel.pondFeed?.othersPercentage.toString()
        feedFrequency.text = addViewModel.pondFeed?.feedingFrequencyDaily.toString()

        createButton.isEnabled = dataIsFilled()
    }

    private fun setupAction() {
        createButton.setOnClickListener {
            lifecycleScope.launch {
                savePondData()
                (activity as? ResetListener)?.onReset()
            }
        }
    }
    private fun initializeView() {
        createButton = view.findViewById(R.id.createButton)
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
        fishType = view.findViewById(R.id.fishTypeEditText)
        fishAmount = view.findViewById(R.id.fishAmountEditText)
        fishHarvest = view.findViewById(R.id.fishHarvestEditText)
        feedAmount = view.findViewById(R.id.amountEditText)
        feedProtein = view.findViewById(R.id.proteinEditText)
        feedLipid =  view.findViewById(R.id.lipidEditText)
        feedCarbohydrate =  view.findViewById(R.id.carbohydrateEditText)
        feedOthers =  view.findViewById(R.id.othersEditText)
        feedFrequency =  view.findViewById(R.id.frequencyEditText)

    }

    private fun dataIsFilled(): Boolean = (
            (addViewModel.pondDataFilled) && (addViewModel.fishDataFilled) && (addViewModel.feedDataFilled))

    private fun setMyButtonEnable() {
        val create = "Create Pond!"
        if (dataIsFilled()) {
            createButton.text = create
        }
    }


}