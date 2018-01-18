package pl.edu.pawelsienkiewicz.util

interface ErrorHandlerInterface {
    fun handleError(throwable: Throwable)
    fun unauthorizedRequest()
    fun noInternet()
    fun validationFailed()
}