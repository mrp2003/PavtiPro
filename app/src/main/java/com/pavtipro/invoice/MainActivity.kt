package com.pavtipro.invoice

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.pavtipro.invoice.databinding.ActivityMainBinding
import com.pavtipro.invoice.model.InvoiceData
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private val selectedStones = mutableListOf<String>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupUI()
        setupDropdowns()
        setupListeners()
    }
    
    private fun setupUI() {
        // Set current date
        val currentDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        binding.etDate.setText(currentDate)
        
        // Make date field read-only
        binding.etDate.isEnabled = false
    }
    
    private fun setupDropdowns() {
        // Gold Color Dropdown
        val goldColors = arrayOf("Yellow Gold", "Rose Gold", "White Gold", "Yellow and White Gold")
        val goldAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, goldColors)
        goldAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerGoldColor.adapter = goldAdapter
        
        // Item Type Dropdown
        val itemTypes = arrayOf("Ring", "Necklace", "Bracelet", "Bangle", "Earring")
        val itemAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemTypes)
        itemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerItemType.adapter = itemAdapter
        
        // Design Number Dropdown (sample data)
        val designNumbers = arrayOf("D001", "D002", "D003", "D004", "D005", "D006", "D007", "D008", "D009", "D010")
        val designAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, designNumbers)
        designAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDesignNo.adapter = designAdapter
        
        // Stone Types (Multi-select checkboxes)
        setupStoneSelection()
    }
    
    private fun setupStoneSelection() {
        binding.cbDiamond.setOnCheckedChangeListener { _, isChecked ->
            updateStoneSelection("Diamond", isChecked)
        }
        binding.cbRuby.setOnCheckedChangeListener { _, isChecked ->
            updateStoneSelection("Ruby", isChecked)
        }
        binding.cbEmerald.setOnCheckedChangeListener { _, isChecked ->
            updateStoneSelection("Emerald", isChecked)
        }
        binding.cbCZ.setOnCheckedChangeListener { _, isChecked ->
            updateStoneSelection("CZ", isChecked)
        }
        binding.cbSapphire.setOnCheckedChangeListener { _, isChecked ->
            updateStoneSelection("Sapphire", isChecked)
        }
    }
    
    private fun updateStoneSelection(stone: String, isSelected: Boolean) {
        if (isSelected) {
            if (selectedStones.size < 3) {
                selectedStones.add(stone)
            } else {
                // Uncheck the checkbox if limit exceeded
                when (stone) {
                    "Diamond" -> binding.cbDiamond.isChecked = false
                    "Ruby" -> binding.cbRuby.isChecked = false
                    "Emerald" -> binding.cbEmerald.isChecked = false
                    "CZ" -> binding.cbCZ.isChecked = false
                    "Sapphire" -> binding.cbSapphire.isChecked = false
                }
                Toast.makeText(this, "Maximum 3 stone types allowed", Toast.LENGTH_SHORT).show()
            }
        } else {
            selectedStones.remove(stone)
        }
    }
    
    private fun setupListeners() {
        binding.btnGenerateInvoice.setOnClickListener {
            if (validateForm()) {
                generateInvoice()
            }
        }
        
        binding.btnClear.setOnClickListener {
            clearForm()
        }
    }
    
    private fun validateForm(): Boolean {
        var isValid = true
        
        if (binding.etCustomerName.text.toString().trim().isEmpty()) {
            binding.etCustomerName.error = "Customer name is required"
            isValid = false
        }
        
        if (binding.etLotNumber.text.toString().trim().isEmpty()) {
            binding.etLotNumber.error = "Lot number is required"
            isValid = false
        }
        
        if (binding.etCarat.text.toString().trim().isEmpty()) {
            binding.etCarat.error = "Carat is required"
            isValid = false
        }
        
        if (binding.etGram.text.toString().trim().isEmpty()) {
            binding.etGram.error = "Gram is required"
            isValid = false
        }
        
        if (binding.etAmount.text.toString().trim().isEmpty()) {
            binding.etAmount.error = "Amount is required"
            isValid = false
        }
        
        return isValid
    }
    
    private fun generateInvoice() {
        val invoiceData = InvoiceData(
            customerName = binding.etCustomerName.text.toString().trim(),
            date = binding.etDate.text.toString(),
            goldColor = binding.spinnerGoldColor.selectedItem.toString(),
            itemType = binding.spinnerItemType.selectedItem.toString(),
            stoneTypes = selectedStones.toList(),
            designNo = binding.spinnerDesignNo.selectedItem.toString(),
            lotNumber = binding.etLotNumber.text.toString().trim(),
            carat = binding.etCarat.text.toString().toIntOrNull() ?: 0,
            gram = binding.etGram.text.toString().toFloatOrNull() ?: 0f,
            stoneWeight = binding.etStoneWeight.text.toString().toFloatOrNull() ?: 0f,
            amount = binding.etAmount.text.toString().toFloatOrNull() ?: 0f
        )
        
        val intent = Intent(this, InvoicePreviewActivity::class.java)
        intent.putExtra("invoice_data", invoiceData)
        startActivity(intent)
    }
    
    private fun clearForm() {
        binding.etCustomerName.text.clear()
        binding.spinnerGoldColor.setSelection(0)
        binding.spinnerItemType.setSelection(0)
        binding.spinnerDesignNo.setSelection(0)
        binding.etLotNumber.text.clear()
        binding.etCarat.text.clear()
        binding.etGram.text.clear()
        binding.etStoneWeight.text.clear()
        binding.etAmount.text.clear()
        
        // Clear stone selections
        selectedStones.clear()
        binding.cbDiamond.isChecked = false
        binding.cbRuby.isChecked = false
        binding.cbEmerald.isChecked = false
        binding.cbCZ.isChecked = false
        binding.cbSapphire.isChecked = false
    }
}