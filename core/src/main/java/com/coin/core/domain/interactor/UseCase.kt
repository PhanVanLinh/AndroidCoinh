package com.coin.core.domain.interactor

abstract class UseCase<in I : UseCase.Input, out T : Any> {

    abstract suspend operator fun invoke(input: I): Result<T>

    abstract class Input
}