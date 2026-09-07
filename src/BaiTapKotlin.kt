import kotlin.math.max

fun main() {
    val studentName = "Võ Minh Huy"
    val studentId = "2415053122117"
    val mathScore = 8.5
    val programmingScore = 7.0
    val databaseScore = 9.0

    val totalScore = mathScore + programmingScore + databaseScore
    val averageScore = totalScore / 3
    val highestScore = max(mathScore, max(programmingScore, databaseScore))
    val isPassed = averageScore >= 5.0

    println("Thông tin sinh viên: $studentName | Mã sinh viên: $studentId")
    println("Tổng điểm: $totalScore")
    println("Điểm trung bình (GPA): ${String.format("%.2f", averageScore)}")
    println("Điểm cao nhất: $highestScore")

    if (isPassed) {
        println("ĐẠT")
    } else {
        println("KHÔNG ĐẠT")
    }
}