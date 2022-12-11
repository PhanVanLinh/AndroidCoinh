package com.coin.wallet.ui.wallet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coin.wallet.R
import com.coin.wallet.ui.wallet.model.CurrencyItem
import com.coin.wallet.ui.wallet.model.DisplayCurrencyItem
import com.coin.wallet.ui.wallet.model.LoadingItem

class CurrencyAdapter :
    ListAdapter<DisplayCurrencyItem, RecyclerView.ViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_TYPE_LOADING) {
            LoadingViewHolder(inflater.inflate(R.layout.wallet_item_loading, parent, false))
        } else {
            CurrencyViewHolder(
                inflater.inflate(R.layout.wallet_item_currency, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CurrencyViewHolder) {
            holder.bind(getItem(position) as CurrencyItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (getItem(position) is LoadingItem) {
            return VIEW_TYPE_LOADING
        }
        return VIEW_TYPE_ITEM
    }

    class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class CurrencyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageCryptoIcon = itemView.findViewById<ImageView>(R.id.image_crypto_icon)
        private var textCryptoName = itemView.findViewById<TextView>(R.id.text_crypto_name)
        private var textCryptoBase = itemView.findViewById<TextView>(R.id.text_crypto_base)
        private var textCryptoPrice = itemView.findViewById<TextView>(R.id.text_crypto_price)

        fun bind(currencyItem: CurrencyItem) {
            textCryptoName.text = currencyItem.name
            textCryptoBase.text = currencyItem.base
            textCryptoPrice.text = currencyItem.price.toPlainString()
            Glide
                .with(itemView.context)
                .load(currencyItem.icon)
                .centerCrop()
                .into(imageCryptoIcon)
        }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<DisplayCurrencyItem>() {
        override fun areItemsTheSame(
            oldItem: DisplayCurrencyItem,
            newItem: DisplayCurrencyItem
        ): Boolean {
            return (oldItem is LoadingItem && newItem is LoadingItem)
                    || (oldItem is CurrencyItem && newItem is CurrencyItem && oldItem.base == newItem.base)
        }

        override fun areContentsTheSame(
            oldItem: DisplayCurrencyItem,
            newItem: DisplayCurrencyItem
        ): Boolean {
            return (oldItem is LoadingItem && newItem is LoadingItem)
                    || (oldItem is CurrencyItem && newItem is CurrencyItem && oldItem == newItem)
        }
    }

    companion object {
        const val VIEW_TYPE_LOADING = 1
        const val VIEW_TYPE_ITEM = 2
    }
}