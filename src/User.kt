open class User (
    private var name :String,
    private var email :String,
    private var password :String,
    private var address :String,
    private var age :Int,
){
    open fun getName():String{
        return name
    }
    open fun resetName(name: String){
        this.name=name
    }
    open fun getEmail():String{
        return email
    }
    open fun getAddress():String{
        return address
    }
    open fun getAge():Int{
        return age
    }
    open fun resetAddress(address: String){
        this.address=address
    }
    open fun resetPassword(oldPassword:String,newPassword:String,confirmPassword:String):Boolean{
        if(password!=oldPassword){
            return false
        }
        else
        {
            if(newPassword==confirmPassword) {
                password=newPassword;
                return true
            }
            else
                return false
        }
    }
}