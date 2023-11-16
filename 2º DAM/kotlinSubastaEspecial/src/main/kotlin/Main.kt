fun main() {
    val winningBid = Bid(5000, "Coleccionista privado ")

    println("Objeto A es vendio por "+auctionPrice(winningBid, 2000)+".")
    println("Objeto B es vendio por  ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    if (bid == null) return minimumPrice
    else return bid.amount
//    Estos returns son exactanente lo mismo que...
    return bid?.amount?:minimumPrice
}
