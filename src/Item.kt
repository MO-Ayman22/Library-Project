class Item (
    private var itemTitle:String,
    private var authorName:String,
    private var itemFormat: ItemFormat,
    private var itemStatus: ItemStatus,
    private var numberOfPages:Int){
    private var iSBN=""
    fun getItemTitle():String{
        return itemTitle
    }
    fun getAuthorName():String{
        return authorName
    }
    fun getItemFormat():String{
        return itemFormat.name
    }
    fun getItemStatus():String{
        return itemStatus.name
    }
    fun getNumberOfPages():Int{
        return numberOfPages
    }
    fun getItemISBN():String{
        return iSBN
    }
    fun display(){
        println("This item is : ${itemFormat.name}")
        println("${itemFormat.name} Title is : $itemTitle")
        println("The ${itemFormat.name} written by : $authorName")
        println("It's number of pages is : $numberOfPages")
        println("The item State is : ${itemStatus.name}")

    }
}