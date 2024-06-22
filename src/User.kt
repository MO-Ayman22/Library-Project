open class User (
    private var name :String,
    private var email :String,
    private var password :String,
    private var address :String,
    private var age :Int,
){
    private var accountStatus=AccountStatus.Active
    open fun getAccountStatus():AccountStatus{
        return accountStatus
    }
    open fun getName():String{
        return name
    }
    open fun getPassword():String{
        return password
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
    open fun resetName(name: String,password: String):Boolean{
        if(this.password==password)
            return false
        this.name = name
        return true
    }
    open fun resetEmail(email: String,password: String):Boolean{
        if(this.password==password)
            return false
        this.email = email
        return true
    }
    open fun resetPassword(oldPassword:String,newPassword:String,confirmPassword:String):Boolean{
        if(password!=oldPassword)
            return false
        if(newPassword!=confirmPassword)
            return false
        password=newPassword;
        return true
    }
}