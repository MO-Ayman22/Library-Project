class Item (
    private var itemTitle:String,
    private var authorName:String,
    private var itemFormat: ItemFormat,
    private var itemStatus: ItemStatus,
    private var numberOfPages:Int){
    private var iSBN= generateISBN
    private var reservationsList:MutableSet<Member> = mutableSetOf()
    private var borrower:Member?=null
    init {
        generateISBN++;
    }
    fun getItemTitle():String{
        return itemTitle
    }
    fun getAuthorName():String{
        return authorName
    }
    fun getItemFormat():ItemFormat{
        return itemFormat
    }
    fun getItemStatus():ItemStatus{
        return itemStatus
    }
    fun getItemISBN():Int{
        return iSBN
    }
    fun getBorrower():Member?{
            return borrower
    }
    fun getNumberOfPages():Int{
        return numberOfPages
    }
    fun getReservationList():MutableSet<Member>{
        return reservationsList
    }
    fun setItemStatus(itemStatus: ItemStatus){
        this.itemStatus=itemStatus
    }
    fun setBorrower(borrower:Member){
        this.borrower=borrower
    }
    fun addReservation(member: Member){
        reservationsList.add(member)
    }
    fun reBorrow(){
        val member:Member=reservationsList.first()
        reservationsList.remove(member)
        borrower=member
        Library.addBorrowedItem(this,member)
    }
    fun display(){
        println("This item is : ${itemFormat.name}")
        println("${itemFormat.name} Title is : $itemTitle")
        println("The ${itemFormat.name} written by : $authorName")
        println("It's number of pages is : $numberOfPages")
        println("The item State is : ${itemStatus.name}")
    }

    companion object{
        private var generateISBN=0;
    }
}