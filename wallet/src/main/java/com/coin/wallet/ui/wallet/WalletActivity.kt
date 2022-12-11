package com.coin.wallet.ui.wallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.coin.wallet.databinding.ActivityWalletBinding
import com.coin.wallet.ui.wallet.adapter.CurrencyAdapter
import com.coin.wallet.ui.wallet.model.LoadingItem

class WalletActivity : AppCompatActivity() {

    private lateinit var currencyAdapter: CurrencyAdapter
    private lateinit var binding: ActivityWalletBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWalletBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnPostCreate()
    }

    private fun setOnPostCreate() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        currencyAdapter = CurrencyAdapter()
        binding.recyclerViewCurrencies.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewCurrencies.adapter = currencyAdapter
        currencyAdapter.submitList(
            listOf(LoadingItem, LoadingItem, LoadingItem, LoadingItem)
        )
    }
}