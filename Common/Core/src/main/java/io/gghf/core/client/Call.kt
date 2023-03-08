package be.rtbf.core.httpclient

import android.util.Log
import io.gghf.core.Tag
import io.gghf.core.client.ServiceResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <Success> call(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> Success,
): ServiceResult<Success, ClientError> =
    try {
        ServiceResult.Success(
            withContext(dispatcher) { apiCall() }
        )

    } catch (e: Exception) {
        Log.e(Tag.Log.Api, e.stackTraceToString())
        ServiceResult.Failure(
            when (e) {
                is IOException -> ClientError.Network
                is HttpException -> ClientError.Http(e.code())
                is NullPointerException -> ClientError.EmptyBody
                else -> ClientError.Unknown
            }
        )
    }

sealed class ClientError {
    object Network : ClientError()
    class Http(val code: Int) : ClientError()
    object EmptyBody : ClientError()
    object Unknown : ClientError()
}
