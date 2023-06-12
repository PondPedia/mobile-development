package com.aetherized.compose.pondpedia.data.repository
import com.aetherized.compose.pondpedia.core.Resource
import com.aetherized.compose.pondpedia.data.csv.CSVParser
import com.aetherized.compose.pondpedia.data.local.database.PondDatabase
import com.aetherized.compose.pondpedia.data.mapper.toPond
import com.aetherized.compose.pondpedia.data.mapper.toPondEntity
import com.aetherized.compose.pondpedia.data.remote.api.PondApi
import com.aetherized.compose.pondpedia.domain.model.pond.Pond
import com.aetherized.compose.pondpedia.domain.repository.PondRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PondRepositoryImpl @Inject constructor(
    val api: PondApi,
    val db: PondDatabase,
    val pondsParser: CSVParser<Pond>
): PondRepository {

    private val dao = db.pondDao()

    override suspend fun getPonds(
        fetchFromRemote: Boolean,
    ): Flow<Resource<List<Pond>>> {
        return flow {
            emit(Resource.Loading(true))
            val localPonds = dao.getAllPonds()
            emit(Resource.Success(
                data = localPonds.map { it.toPond() }
            ))

            val isDbEmpty = localPonds.isEmpty()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            val remotePonds = try {
                val response = api.getAllStories()
                pondsParser.parse(response.byteStream())
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

            remotePonds?.let { ponds ->
                dao.deleteAllPonds()
                dao.insertAllPonds(
                    ponds.map{ it.toPondEntity() }
                )
                emit(Resource.Success(
                    data = dao
                        .getAllPonds()
                        .map { it.toPond() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }
}