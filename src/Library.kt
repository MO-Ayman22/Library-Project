class Library (private var libraryName:String,private var libraryAddress:String){
    companion object{
       private var borrowedItems=HashMap<Item,Member>()
       private var accounts=HashMap<String,User>()
       fun addBorrowedItem(item: Item,member: Member){
           borrowedItems[item]=member
       }
       fun addAccount(email:String,user: User){
           accounts[email]=user
       }
       fun removeAccount(email:String){
           accounts.remove(email)
       }
       fun signIn(email:String,password:String): User? {
           if(accounts.containsKey(email)&&accounts[email]?.getPassword()==password&& accounts[email]?.getAccountStatus()==AccountStatus.Active)
                   return accounts[email]
           return null
       }
       fun register(name :String, email :String,password :String,address :String, age :Int): Boolean {
           if(accounts.containsKey(email))
               return false
           var user = User(name,email,password,address, age)
           accounts.put(email,user);
           return true
       }
    }
}