package com.aetherized.view.pondpediaview.ui.authenticated.home.add

import androidx.lifecycle.ViewModel
import com.aetherized.view.pondpediaview.data.model.PondFeed
import com.aetherized.view.pondpediaview.data.model.PondFish
import com.aetherized.view.pondpediaview.data.model.PondWater

class AddViewModel : ViewModel() {
    var pondName: String? = null
    var pondLength: Float? = null
    var pondWidth: Float? = null
    var pondDepth: Float? = null
    var pondFish: PondFish? = null
    var pondFeed: PondFeed? = null
    var pondWater: PondWater? = null

    var pondDataFilled: Boolean = false
    var fishDataFilled: Boolean = false
    var feedDataFilled: Boolean = true
}