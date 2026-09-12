package com.example.lib

// data class
data class Student(
    val id: String,
    val fullName: String,
    val age: Int,
    val major: String,
    val gpa: Double
)

fun main(){
    val students = mutableListOf(
        Student("SV001", "Vo Minh Huy", 20, "CNTT", 8.5),
        Student("SV002", "Tran Thi Mai", 21, "Kinh Te", 4.5),
        Student("SV003", "Le Hoang Dung", 19, "CNTT", 9.1),
        Student("SV004", "Pham Tuan Anh", 22, "Ngon Ngu Anh", 7.2),
        Student("SV005", "Hoang Bao Ngoc", 20, "Marketing", 8.0)
    )

    while (true){
        println("\n========== STUDENT MANAGEMENT ==========")
        println("1. Add student")
        println("2. Display all students")
        println("3. Search student (by exact ID)")
        println("4. Calculate average GPA (All students)")
        println("5. Find student with highest GPA")
        println("6. Remove student")
        println("7. Dem so sinh vien co GPA >= 8.0")
        println("8. Dem so sinh vien co GPA < 5.0")
        println("9. Tinh GPA trung binh cua mot nganh")
        println("10. Tim sinh vien lon tuoi nhat")
        println("11. Tim sinh vien co GPA tu 7.0 -> 8.5")
        println("12. Tim tat ca sinh vien thuoc mot nganh")
        println("13. Tim sinh vien theo mot phan ten")
        println("14. Sap xep sinh vien theo GPA giam dan")
        println("15. Hien thi 3 sinh vien co GPA cao nhat")
        println("16. Sap xep sinh vien theo tuoi")
        println("17. Sap xep sinh vien theo ten")
        println("0. Exit")
        print("Choose an option: ")

        val choice = readln().toIntOrNull() ?: -1

        when(choice){
            1 -> {
                print("ID: ")
                val id = readln()
                print("Full name: ")
                val name = readln()
                print("Age: ")
                val age = readln().toIntOrNull() ?: 0
                print("Major: ")
                val major = readln()
                print("GPA: ")
                val gpa = readln().toDoubleOrNull() ?: 0.0
                students.add(Student(id, name, age, major, gpa))
                println("Add student successfully")
            }

            2 -> students.forEach { println(it) }

            3 -> {
                print("Enter ID to search: ")
                val id = readln()
                val s = students.find{it.id == id}
                if(s != null) println(s) else println("Not found")
            }

            4 -> {
                if (students.isEmpty()) println("No student available")
                else println("Average GPA: ${String.format("%.2f", students.map { it.gpa }.average())}")
            }

            5 -> println("Highest GPA: ${students.maxByOrNull { it.gpa }}")

            6 -> {
                print("Enter ID to move: ")
                val id = readln()
                if(students.removeIf { it.id == id })
                    println("Remove successfully")
                else
                    println("Not found")
            }

            7 -> println("So luong GPA >= 8.0: ${students.count{it.gpa >= 8.0}}")

            8 -> println("So luong GPA < 5.0: ${students.count { it.gpa < 5.0 }}")

            9 -> {
                print("Nhap ten nganh: ")
                val major = readln()
                val filtered = students.filter { it.major.equals(major, ignoreCase = true) }
                if(filtered.isEmpty())
                    println("Khong co sinh vien nganh nay")
                else
                    println("GPA trung binh nganh $major: ${String.format("%.2f", filtered.map { it.gpa }.average())}")
            }

            10 -> println("Sinh vien co tuoi lon nhat: ${students.maxByOrNull { it.age }}")

            11 -> students.filter { it.gpa in 7.0..8.5 }.forEach { println(it) }

            12 -> {
                print("Nhap ten nganh can tim: ")
                val major = readln()
                students.filter { it.major.equals(major, ignoreCase = true) }.forEach { println(it) }
            }

            13 -> {
                print("Nhap tu khoa ten: ")
                val keyword = readln()
                students.filter { it.fullName.contains(keyword, ignoreCase = true) }.forEach { println(it) }
            }

            14 -> students.sortedByDescending { it.gpa }.forEach { println(it) }

            15 -> students.sortedByDescending { it.gpa }.take(3).forEach { println(it) }

            16 -> students.sortedBy{ it.age }.forEach {println(it)}

            17 -> students.sortedBy { it.fullName }.forEach { println(it) }

            0 -> return

            else -> println("Invalid choice")
        }
    }
}