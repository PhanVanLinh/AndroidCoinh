package com.coin.wallet.ui.wallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.coin.wallet.databinding.ActivityWalletBinding
import com.coin.wallet.ui.wallet.adapter.CurrencyAdapter
import com.coin.wallet.ui.wallet.model.LoadingItem
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors

@AndroidEntryPoint
class WalletActivity : AppCompatActivity() {

    private lateinit var currencyAdapter: CurrencyAdapter
    private lateinit var binding: ActivityWalletBinding
    val viewModel by viewModels<WalletViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerLoginComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    LoginModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
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