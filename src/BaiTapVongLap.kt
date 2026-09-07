fun main() {
    println("BÀI 1")
    print("Các số từ 1 đến 10 là: ")
    for (i in 1..10) {
        print("$i ")
    }
    println("\n")

    println("BÀI 2")
    var sum = 0
    for (i in 1..100) {
        sum += i
    }
    println("Tổng từ 1 đến 100 là: $sum\n")

    println("BÀI 3")
    print("Các số chẵn từ 1 đến 20 (dùng for): ")
    for (i in 1..20) {
        if (i % 2 == 0) {
            print("$i ")
        }
    }
    println()
}