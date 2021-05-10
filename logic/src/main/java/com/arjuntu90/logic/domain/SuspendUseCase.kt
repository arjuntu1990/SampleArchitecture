package com.arjuntu90.logic.domain

import com.arjuntu90.logic.api.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class SuspendUseCase<in P, out R>(private val coroutineDispatcher: CoroutineDispatcher) {
    suspend operator fun invoke(parameter: P): ResultWrapper<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameter).let {
                    ResultWrapper.Success(it)
                }
            }
        } catch (e: Exception) {
            ResultWrapper.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameter: P): R
}