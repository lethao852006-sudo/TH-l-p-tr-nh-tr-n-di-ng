package com.example.project_andr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project_andr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnSubmit.setOnClickListener {
                // Dùng Extension 'trimmedText()' lấy dữ liệu từ EditText
                val name = edtInputName.trimmedText()

                if (name.isEmpty()) {
                    // Dùng Extension 'toast()' để hiện thông báo
                    toast("Vui lòng nhập tên!")
                    return@setOnClickListener
                }

                if (!cbAgreeTerms.isChecked) {
                    toast("Bạn cần đồng ý với điều khoản!")
                    return@setOnClickListener
                }

                val statusText = if (switchStatus.isChecked) "Bật" else "Tắt"

                // Dùng Extension 'show()' để hiện TextView kết quả
                tvResult.show()
                tvResult.text = "Xin chào: $name\nThông báo: $statusText"

                toast("Đã xử lý thông tin thành công!")
            }
        }
    }
}