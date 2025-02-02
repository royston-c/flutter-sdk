package com.qonversion.flutter.sdk.qonversion_flutter_sdk

import io.flutter.plugin.common.MethodChannel

private const val passValidValue = "Please make sure you pass a valid value"

fun MethodChannel.Result.noArgsError() {
    return this.error("0", "Could not find call arguments", "Make sure you pass Map as call arguments")
}

fun MethodChannel.Result.noApiKeyError() {
    return this.error("1", "Could not find API key", "Make sure you pass Map as call arguments")
}

fun MethodChannel.Result.noUserIdError() {
    return this.error("2", "Could not find userID", "Make sure you pass Map as call arguments")
}

fun MethodChannel.Result.noAutoTrackPurchasesError() {
    return this.error("3", "Could not find autoTrackPurchases boolean value", "Make sure you pass Map as call arguments")
}

fun MethodChannel.Result.noDataError() {
    return this.error("4", "Could not find data", passValidValue)
}

fun MethodChannel.Result.noProviderError() {
    return this.error("5", "Could not find provider", passValidValue)
}

fun MethodChannel.Result.noProductIdError() {
    return this.error("8", "Could not find productId value", "Please provide valid productId")
}

fun MethodChannel.Result.qonversionError(message: String, cause: String) {
    return this.error("9", message, cause)
}

fun MethodChannel.Result.noNewProductIdError() {
    return this.error("10", "Could not find new product id", passValidValue)
}

fun MethodChannel.Result.noOldProductIdError() {
    return this.error("11", "Could not find new product id", passValidValue)
}

fun MethodChannel.Result.parsingError(message: String?) {
    return this.error("12", "Arguments Parsing Error", message)
}

fun MethodChannel.Result.noProperty() {
    return this.error("13", "Could not find property", passValidValue)
}

fun MethodChannel.Result.noPropertyValue() {
    return this.error("14", "Could not find property value", passValidValue)
}

fun MethodChannel.Result.offeringsError(description: String?, message: String?) {
    return this.error("OFFERINGS", "Could not get offerings", "$description $message")
}

fun MethodChannel.Result.noSdkInfo() {
    return this.error("15", "Could not find sdk info", passValidValue)
}
