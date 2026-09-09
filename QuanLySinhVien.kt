package com.example.myapplication


data class sv(
    val masv: String,
    val hoten: String,
    val tuoi: Int,
    val nganh: String,
    val khoa: String,
    val gpa: Double
)
fun hienThiSinhVien(sv: sv) {
    println("Ma sinh vien: ${sv.masv}")
    println("Ho ten: ${sv.hoten}")
    println("Tuoi: ${sv.tuoi}")
    println("Nganh: ${sv.nganh}")
    println("Khoa: ${sv.khoa}")
    println("GPA: ${sv.gpa}")
    println("--------------------------------------")
}
fun themSinhVien(danhSach: MutableList<sv>) {

    println()
    println("========== ADD STUDENT ==========")

    print("Nhap ma sv: ")
    val masv = readLine() ?: ""

    for (sv in danhSach) {
        if (sv.masv == masv) {
            println("Ma sinh vien da ton tai!")
            return
        }
    }

    print("Nhap ho ten: ")
    val hoTen = readLine() ?: ""

    print("Nhap tuoi: ")
    val tuoi = readLine()?.toIntOrNull()

    if (tuoi == null || tuoi <= 0) {
        println("Tuoi khong hop le!")
        return
    }

    print("Nhap nganh: ")
    val nganh = readLine() ?: ""

    print("Nhap khoa: ")
    val khoa = readLine() ?: ""

    print("Nhap GPA: ")
    val gpa = readLine()?.toDoubleOrNull()

    // Validation GPA
    if (gpa == null || gpa!in 0.0..10.0) {
        println("GPA không hợp lệ! GPA phải từ 0 đến 10.")
        return
    }

    val sv = sv(masv ,hoTen,tuoi,nganh,khoa,gpa)
    danhSach.add(sv)
    println("Thêm sinh viên thành công!")
}

// 4. HIỂN THỊ TẤT CẢ SINH VIÊN
fun hienThiTatCa(danhSach: MutableList<sv>) {

    if (danhSach.isEmpty()) {
        println("Danh sach sinh vien dang trong!")
        return
    }

    println()
    println("========== ALL STUDENTS ==========")

    for (sv in danhSach) {
        hienThiSinhVien(sv)
    }
}


// ======================================================
// 5. YÊU CẦU 15
// LỌC SINH VIÊN CÓ GPA > 9
// ======================================================

fun locGpaLonHon9(danhSach: MutableList<sv>) {

    var timThay = false

    println()
    println("========== GPA > 9 ==========")

    for (sv in danhSach) {

        if (sv.gpa > 9) {
            hienThiSinhVien(sv)
            timThay = true
        }
    }

    if (!timThay) {
        println("Khong co sinh vien GPA > 9.")
    }
}

// 6. YÊU CẦU 16
// SẮP XẾP TÊN ABC
fun sapXepTheoTen(danhSach: MutableList<sv>) {

    danhSach.sortBy {
        it.hoten.substringAfterLast(" ").lowercase()
    }

    println("Da sap xep sinh vien theo ten ABC.")

    hienThiTatCa(danhSach)
}

// 7. TÌM THEO MÃ SINH VIÊN
// Yêu cầu 13

fun timTheoMa(danhSach: MutableList<sv>) {

    print("Nhap ma sv can tim: ")
    val maSV = readLine() ?: ""

    var timThay = false

    for (sv in danhSach) {

        if (sv.masv == maSV) {

            println()
            println("Da tim thay:")
            hienThiSinhVien(sv)

            timThay = true
            break
        }
    }

    if (!timThay) {
        println("Khong tim thay sinh vien!")
    }
}

// 8. TÌM THEO MỘT PHẦN TÊN
// Yêu cầu 8

fun timTheoTen(danhSach: MutableList<sv>) {

    print("Nhap mot phan ten: ")
    val ten = readLine()?.lowercase() ?: ""

    var timThay = false

    for (sv in danhSach) {

        if (sv.hoten.lowercase().contains(ten)) {

            hienThiSinhVien(sv)
            timThay = true
        }
    }

    if (!timThay) {
        println("Khong tim thay sinh vien!")
    }
}

// 9. TÌM THEO NGÀNH
// Yêu cầu 7

fun timTheoNganh(danhSach: MutableList<sv>) {

    print("Nhap nganh can tim : ")
    val nganh = readLine()?.lowercase() ?: ""

    var timThay = false

    for (sv in danhSach) {

        if (sv.nganh.lowercase() == nganh) {

            hienThiSinhVien(sv)
            timThay = true
        }
    }

    if (!timThay) {
        println("Khong co sinh vien thuoc nganh nay!")
    }
}

// 10. TÌM GPA TRONG KHOẢNG 7.0 -> < 8.5
// Yêu cầu 6


fun timGpaTrongKhoang(danhSach: MutableList<sv>) {

    println()
    println("========== GPA 7.0 -> < 8.5 ==========")

    var timThay = false

    for (sv in danhSach) {

        if (sv.gpa >= 7.0 && sv.gpa < 8.5) {

            hienThiSinhVien(sv)
            timThay = true
        }
    }

    if (!timThay) {
        println("Khong co sinh vien phu hop.")
    }
}

// 11. TÌM SINH VIÊN LỚN TUỔI NHẤT
// Yêu cầu 5


fun timLonTuoiNhat(danhSach: MutableList<sv>) {

    if (danhSach.isEmpty()) return

    var svMax = danhSach[0]

    for (sv in danhSach) {

        if (sv.tuoi > svMax.tuoi) {
            svMax = sv
        }
    }

    println()
    println("========== SINH VIEN LON TUOI NHAT==========")

    hienThiSinhVien(svMax)
}


// ======================================================
// 12. TÌM SINH VIÊN GPA CAO NHẤT
// Yêu cầu 4
// ======================================================

fun timGpaCaoNhat(danhSach: MutableList<sv>) {

    if (danhSach.isEmpty()) return

    var svMax = danhSach[0]

    for (sv in danhSach) {

        if (sv.gpa > svMax.gpa) {
            svMax = sv
        }
    }

    println()
    println("========== GPA CAO NHAT ==========")

    hienThiSinhVien(svMax)
}

// 13. ĐẾM GPA >= 8
// Yêu cầu 1

fun demGpa8(danhSach: MutableList<sv>) {
    var dem = 0
    for (sv in danhSach) {

        if (sv.gpa >= 8.0) {
            dem++
        }
    }
    println("So sinh vien co GPA >= 8.0: $dem")
}

// 14. ĐẾM GPA < 5
// Yêu cầu 2

fun demGpa5(danhSach: MutableList<sv>) {
    var dem = 0
    for (sv in danhSach) {

        if (sv.gpa < 5.0) {
            dem++
        }
    }
    println("So sinh vien co GPA < 5.0: $dem")
}

// 15. GPA TRUNG BÌNH
// Yêu cầu 3


fun tinhGpaTrungBinh(danhSach: MutableList<sv>) {

    if (danhSach.isEmpty()) {
        println("Danh sach trong!")
        return
    }
    var tong = 0.0

    for (sv in danhSach) {
        tong += sv.gpa
    }
    val gpaTB = tong / danhSach.size
    println("GPA trung binh: %.2f".format(gpaTB))
}

// 16. GPA TRUNG BÌNH THEO NGÀNH
// ======================================================

fun tinhGpaTheoNganh(danhSach: MutableList<sv>) {

    print("Nhap nganh: ")
    val nganh = readLine()?.lowercase() ?: ""

    var tong = 0.0
    var dem = 0
    for (sv in danhSach) {

        if (sv.nganh.lowercase() == nganh) {

            tong += sv.gpa
            dem++
        }
    }
    if (dem == 0) {
        println("Khong co sinh vien thuoc nganh nay!")
    } else {

        val gpaTB = tong / dem

        println("GPA trung binh nganh $nganh: %.2f".format(gpaTB))
    }
}

// 17. TOP 3 GPA CAO NHẤT
// Yêu cầu 10
fun top3Gpa(danhSach: MutableList<sv>) {
    if (danhSach.isEmpty()) return
    val ds = danhSach.sortedByDescending { it.gpa }
    val soLuong = if (ds.size < 3) ds.size else 3
    println()
    println("========== TOP 3 GPA ==========")
    for (i in 0 until soLuong) {
        println("Hang ${i + 1}:")
        hienThiSinhVien(ds[i])
    }
}


// 18. SẮP XẾP THEO TUỔI
// Yêu cầu 11
fun sapXepTheoTuoi(danhSach: MutableList<sv>) {
    danhSach.sortBy { it.tuoi }
    println("Da sap xep theo tuoi.")
    hienThiTatCa(danhSach)
}
// 19. XÓA SINH VIÊN

fun xoaSinhVien(danhSach: MutableList<sv>) {

    print("Nhap ma sinh vien can xoa: ")
    val masv = readLine() ?: ""

    var timThay = false

    for (i in danhSach.indices) {

        if (danhSach[i].masv == masv) {

            danhSach.removeAt(i)

            println("Xoa sinh vien thanh cong!")

            timThay = true
            break
        }
    }

    if (!timThay) {
        println("Khong tim thay sinh vien!")
    }
}

// 20. MENU DISPLAY
// Chức năng chính số 2

fun menuDisplay(danhSach: MutableList<sv>) {

    while (true) {

        println()
        println("========== DISPLAY ==========")
        println("1. Display all students")
        println("2. Display students GPA > 9")
        println("3. Sort students by name ABC")
        println("4. Sort students by age")
        println("0. Back")

        print("Choose: ")

        when (readLine()?.toIntOrNull()) {

            1 -> hienThiTatCa(danhSach)

            2 -> locGpaLonHon9(danhSach)

            3 -> sapXepTheoTen(danhSach)

            4 -> sapXepTheoTuoi(danhSach)

            0 -> return

            else -> println("Lua chon khong hop le!")
        }
    }
}

// 21. MENU SEARCH
// Chức năng chính số 3

fun menuSearch(danhSach: MutableList<sv>) {

    while (true) {

        println()
        println("========== SEARCH STUDENT ==========")
        println("1. Search by student ID")
        println("2. Search by name")
        println("3. Search by major")
        println("4. Search GPA 7.0 -> < 8.5")
        println("5. Find oldest student")
        println("0. Back")

        print("Choose: ")

        when (readLine()?.toIntOrNull()) {

            1 -> timTheoMa(danhSach)

            2 -> timTheoTen(danhSach)

            3 -> timTheoNganh(danhSach)

            4 -> timGpaTrongKhoang(danhSach)

            5 -> timLonTuoiNhat(danhSach)

            0 -> return

            else -> println("Lựa chọn không hợp lệ!")
        }
    }
}

// 22. MENU GPA
// Chức năng chính số 4
// ======================================================

fun menuGPA(danhSach: MutableList<sv>) {

    while (true) {

        println()
        println("========== GPA MANAGEMENT ==========")
        println("1. Calculate average GPA")
        println("2. Calculate average GPA by major")
        println("3. Count GPA >= 8.0")
        println("4. Count GPA < 5.0")
        println("0. Back")

        print("Choose: ")

        when (readLine()?.toIntOrNull()) {

            1 -> tinhGpaTrungBinh(danhSach)

            2 -> tinhGpaTheoNganh(danhSach)

            3 -> demGpa8(danhSach)

            4 -> demGpa5(danhSach)

            0 -> return

            else -> println("Lựa chọn không hợp lệ!")
        }
    }
}

// 23. MENU GPA CAO NHẤT
// Chức năng chính số 5

fun menuGpaCaoNhat(danhSach: MutableList<sv>) {

    while (true) {

        println()
        println("========== HIGH GPA ==========")
        println("1. Find highest GPA")
        println("2. Display top 3 GPA")
        println("0. Back")

        print("Choose: ")

        when (readLine()?.toIntOrNull()) {

            1 -> timGpaCaoNhat(danhSach)

            2 -> top3Gpa(danhSach)

            0 -> return

            else -> println("Lua chon khong hop le!")
        }
    }
}
// 24. MENU CHÍNH
// CHỈ 6 CHỨC NĂNG

fun menuChinh(danhSach: MutableList<sv>) {

    while (true) {

        println()
        println("================================================")
        println("              STUDENT MANAGEMENT")
        println("================================================")
        println("1. Add student")
        println("2. Display all students")
        println("3. Search student")
        println("4. Calculate average GPA")
        println("5. Find student with highest GPA")
        println("6. Remove student")
        println("0. Exit")
        println("================================================")

        print("Choose: ")

        when (readLine()?.toIntOrNull()) {

            1 -> themSinhVien(danhSach)

            2 -> menuDisplay(danhSach)

            3 -> menuSearch(danhSach)

            4 -> menuGPA(danhSach)

            5 -> menuGpaCaoNhat(danhSach)

            6 -> xoaSinhVien(danhSach)

            0 -> {
                println("Da thoat chuong trinh!")
                return
            }

            else -> println("Lua chon khong hop le!")
        }
    }
}



fun main () {
    val danhSach=mutableListOf(
      sv("001","Le Thi Minh Thao",20,"Cong nghe thong tin","Cong nghe so",8.9),
        sv("002","Nguyen Vu Hoang Ngan",22,"Kinh te xay dung","Xay dung",8.5),
        sv("003","Le Cao Hoang Anh",20,"Cong nghe thong tin","Cong nghe so",6.5),
        sv("004","Vo Tan Phat",21,"Cong nghe thong tin","Cong nghe so",4.5),
        sv("005","Nguyen Thi Thao Ngoc",19,"Ngon ngu Anh","Ngoai ngu",9.2)
    )

    println("So sinh vien hien co ${danhSach.size}")

    println("====================================================")
    println("             STUDENT MANAGEMENT")
    println("====================================================")
    println("Da khoi tao ${danhSach.size} sinh vien mau.")

    menuChinh(danhSach)
}











