package com.qonversion.flutter.sdk.qonversion_flutter_sdk

import com.android.billingclient.api.SkuDetails
import com.qonversion.android.sdk.QonversionError
import com.qonversion.android.sdk.dto.QLaunchResult
import com.qonversion.android.sdk.dto.QPermission
import com.qonversion.android.sdk.dto.eligibility.QEligibility
import com.qonversion.android.sdk.dto.eligibility.QIntroEligibilityStatus
import com.qonversion.android.sdk.dto.offerings.QOffering
import com.qonversion.android.sdk.dto.offerings.QOfferings
import com.qonversion.android.sdk.dto.products.QProduct

data class PurchaseResult(val permissions: Map<String, QPermission>? = null, val error: QonversionError? = null) {
    fun toMap(): Map<String, Any?> {
        return mapOf(
                "permissions" to permissions?.mapValues { it.value.toMap() },
                "error" to (error?.description ?: error?.additionalMessage)
        )
    }
}

fun QLaunchResult.toMap(): Map<String, Any> {
    return mapOf(
            "uid" to uid,
            "timestamp" to date.time.toDouble(),
            "products" to products.mapValues { it.value.toMap() },
            "permissions" to permissions.mapValues { it.value.toMap() },
            "user_products" to userProducts.mapValues { it.value.toMap() }
    )
}

fun QProduct.toMap(): Map<String, Any?> {
    return mapOf(
            "id" to qonversionID,
            "store_id" to storeID,
            "type" to type.type,
            "duration" to duration?.type,
            "sku_details" to skuDetail?.toMap(),
            "pretty_price" to prettyPrice,
            "trial_duration" to trialDuration?.type
    )
}

fun QPermission.toMap(): Map<String, Any?> {
    return mapOf(
            "id" to permissionID,
            "associated_product" to productID,
            "renew_state" to renewState.type,
            "started_timestamp" to startedDate.time.toDouble(),
            "expiration_timestamp" to expirationDate?.time?.toDouble(),
            "active" to isActive()
    )
}

fun QOfferings.toMap(): Map<String, Any?> {
    return mapOf(
            "main" to main?.toMap(),
            "available_offerings" to availableOfferings.map { it.toMap() }
    )
}

fun QOffering.toMap(): Map<String, Any?> {
    return mapOf(
            "id" to offeringID,
            "tag" to tag.tag,
            "products" to products.map { it.toMap() }
    )
}

fun QEligibility.toMap(): Map<String, Any?> {
    return mapOf("status" to status.toInt())
}

fun QIntroEligibilityStatus.toInt(): Int {
    return when (this) {
        QIntroEligibilityStatus.Unknown -> 0
        QIntroEligibilityStatus.NonIntroProduct -> 1
        QIntroEligibilityStatus.Ineligible -> 2
        QIntroEligibilityStatus.Eligible -> 3
    }
}

fun SkuDetails.toMap(): Map<String, Any?> {
    return mapOf(
            "title" to title,
            "description" to description,
            "freeTrialPeriod" to freeTrialPeriod,
            "introductoryPrice" to introductoryPrice,
            "introductoryPriceAmountMicros" to introductoryPriceAmountMicros,
            "introductoryPriceCycles" to introductoryPriceCycles,
            "introductoryPricePeriod" to introductoryPricePeriod,
            "price" to price,
            "priceAmountMicros" to priceAmountMicros,
            "priceCurrencyCode" to priceCurrencyCode,
            "sku" to sku,
            "type" to type,
            "subscriptionPeriod" to subscriptionPeriod,
            "originalPrice" to originalPrice,
            "originalPriceAmountMicros" to originalPriceAmountMicros
    )
}
