class Member(name:String,email:String,password:String,address:String,age:Int)
    : User(name, email, password, address, age) {
    private var memberReservations=0
    private var numberOfBorrowedItems=0
    private var reservationsList:MutableSet<Item> = mutableSetOf()
    private var borrowedItems:MutableSet<Item> = mutableSetOf()
    fun doReservation(item: Item):Boolean{
        if(memberReservations==Constants.maxNumberCanBeReserved||memberReservations+numberOfBorrowedItems==Constants.maxNumberCanBeBorrowed)
            return false
        memberReservations++
        item.addReservation(this)
        reservationsList.add(item)
        item.setItemStatus(ItemStatus.Reserved)
        return true
    }
    fun borrowItem(item: Item):Boolean{
        if (item.getItemStatus()!=ItemStatus.Available)
            return false
        if(numberOfBorrowedItems+memberReservations==Constants.maxNumberCanBeBorrowed)
            return false
        numberOfBorrowedItems++
        Library.addBorrowedItem(item,this)
        borrowedItems.add(item)
        item.setBorrower(this)
        item.setItemStatus(ItemStatus.Loaned)
        return true
    }
    fun returnItem(item: Item){
        numberOfBorrowedItems--;
        borrowedItems.remove(item)
        if(item.getItemStatus()==ItemStatus.Reserved)
            item.reBorrow()
        else
            item.setItemStatus(ItemStatus.Available)
    }
}