package com.aetherized.compose.pondpedia.domain.use_case

import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.domain.repository.PondLogRepository

class AddPondLog (
    private val repository: PondLogRepository
) {
    suspend operator fun invoke(userId: String?, pond: Pond) {

        repository.addLocalPondLog(userId, pond)
    }
}