class Library (private var libraryName:String,private var libraryAddress:String){
    companion object{
        var reservedItems=HashMap<Item,MutableSet<Member>>()
        var borrowedItems=HashMap<Item,MutableSet<Member>>()
    }
}