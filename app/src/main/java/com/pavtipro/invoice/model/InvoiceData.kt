package com.pavtipro.invoice.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InvoiceData(
    val customerName: String,
    val date: String,
    val goldColor: String,
    val itemType: String,
    val stoneTypes: List<String>,
    val designNo: String,
    val lotNumber: String,
    val carat: Int,
    val gram: Float,
    val stoneWeight: Float,
    val amount: Float
) : Parcelable