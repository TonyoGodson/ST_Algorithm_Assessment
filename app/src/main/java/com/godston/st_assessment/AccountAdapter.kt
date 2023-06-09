package com.godston.st_assessment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.godston.st_assessment.databinding.AccountItemBinding

class AccountAdapter : RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {

    private lateinit var binding: AccountItemBinding

    inner class AccountViewHolder() : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AccountDataClass) {
            binding.apply {
                randomNumberTv.text = item.randomNumber
                codeAndRandomNumberTv.text = item.codeAndRandomNo
                mFactorTv.text = item.mFactor
                mappedNumberTv.text = item.mappedNumber
                totalTv.text = item.total
                moduloTv.text = item.modulo
                extraTv.text = item.extra
                acctNoTv.text = item.acctNo
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = AccountItemBinding.inflate(inflater, parent, false)
        return AccountViewHolder()
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    val diffUtil = object : DiffUtil.ItemCallback<AccountDataClass>() {
        override fun areItemsTheSame(
            oldItem: AccountDataClass,
            newItem: AccountDataClass
        ): Boolean {
            return oldItem.randomNumber == newItem.randomNumber
        }

        override fun areContentsTheSame(
            oldItem: AccountDataClass,
            newItem: AccountDataClass
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffUtil)
}
