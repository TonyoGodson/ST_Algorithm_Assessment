package com.godston.st_assessment // ktlint-disable package-name

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.godston.st_assessment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ST_ViewModel by viewModels()
    lateinit var accountList: MutableList<AccountDataClass>
    private lateinit var accountAdapter: AccountAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        accountList = viewModel.accountList
        binding.createNo.setOnClickListener {
            viewModel.calculate()
            binding.instructionTv.visibility = View.GONE
            accountAdapter = AccountAdapter()
            val rvLayoutManager = LinearLayoutManager(this@MainActivity)
            rvLayoutManager.reverseLayout = true
            rvLayoutManager.stackFromEnd = true
            binding.acctRv.apply {
                adapter = accountAdapter
                layoutManager = rvLayoutManager
                setHasFixedSize(true)
                accountAdapter.differ.submitList(accountList)
            }
        }
    }
}
