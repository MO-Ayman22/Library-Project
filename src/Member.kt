class Member(name:String,email:String,password:String,address:String,age:Int)
    : User(name, email, password, address, age) {
    private var memberID=""
    private var memberReservations=0
    private var borrowedItems=0
    fun doReservation(item: Item):Boolean{
        if (item.getItemStatus()==ItemStatus.Available)
            return false
        if(memberReservations==Constants.maxNumberCanBeReserved)
            return false
        memberReservations++
        if(item.getItemStatus()==ItemStatus.Reserved)
            Library.reservedItems[item]?.add(this)
        else
            Library.reservedItems[item] = mutableSetOf(this)
        item.setItemStatus(ItemStatus.Reserved)
        return true
    }
    fun borrowItem(item: Item):Boolean{
        if (item.getItemStatus()!=ItemStatus.Available)
            return false
        if(borrowedItems==Constants.maxNumberCanBeBorrowed)
            return false
        borrowedItems++
        Library.borrowedItems[item] = mutableSetOf(this)
        item.setItemStatus(ItemStatus.Loaned)
        return true
    }
    fun returnItem(item: Item){
        borrowedItems--;
        if(item.getItemStatus()==ItemStatus.Reserved)
        {
            for(member in Library.reservedItems[item]!!){
                if(member.borrowedItems<Constants.maxNumberCanBeBorrowed){
                    member.memberReservations--;
                    member.borrowedItems++;
                    Library.borrowedItems[item] = mutableSetOf(member)
                    Library.reservedItems[item]?.remove(member)
                    if (Library.reservedItems[item]?.size==0)
                    {
                        Library.reservedItems.remove(item)
                        item.setItemStatus(ItemStatus.Loaned)
                    }
                    return
                }
            }
            item.setItemStatus(ItemStatus.Available)
        }
    }
}