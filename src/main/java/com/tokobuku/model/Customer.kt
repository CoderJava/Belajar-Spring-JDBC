package com.tokobuku.model

class Customer(var custId: Int, var fullName: String?, var address: String?, var email: String?) {

    override fun toString(): String {
        return "Customer{" +
                "custId=" + custId +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}'
    }
}
