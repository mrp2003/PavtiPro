package com.pavtipro.invoice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavtipro.invoice.databinding.ActivityInvoicePreviewBinding
import com.pavtipro.invoice.model.InvoiceData

class InvoicePreviewActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityInvoicePreviewBinding
    private lateinit var invoiceData: InvoiceData
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInvoicePreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        invoiceData = intent.getParcelableExtra("invoice_data") ?: return
        
        setupInvoicePreview()
        setupListeners()
    }
    
    private fun setupInvoicePreview() {
        binding.apply {
            tvCustomerNameValue.text = invoiceData.customerName
            tvDateValue.text = invoiceData.date
            tvGoldColorValue.text = invoiceData.goldColor
            tvItemTypeValue.text = invoiceData.itemType
            tvStoneTypesValue.text = invoiceData.stoneTypes.joinToString(", ")
            tvDesignNoValue.text = invoiceData.designNo
            tvLotNumberValue.text = invoiceData.lotNumber
            tvCaratValue.text = "${invoiceData.carat} CT"
            tvGramValue.text = "${invoiceData.gram} g"
            tvStoneWeightValue.text = "${invoiceData.stoneWeight} g"
            tvAmountValue.text = "₹ ${String.format("%.2f", invoiceData.amount)}"
        }
    }
    
    private fun setupListeners() {
        binding.btnFinish.setOnClickListener {
            finish()
        }
        
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}