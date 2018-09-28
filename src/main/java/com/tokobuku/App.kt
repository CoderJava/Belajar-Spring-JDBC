package com.tokobuku

import com.tokobuku.dao.CustomerDao
import com.tokobuku.model.Customer
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val context = ClassPathXmlApplicationContext("Main.xml")
        val customerDao = context.getBean("customerDao") as CustomerDao
        customerDao.insert(Customer(1, "Russel Banks", "5160 Haas Junction", "rbanks0@seesa.net"))
        customerDao.insert(Customer(2, "Tina Peters", "0023 Mandrake Pass", "tpeters1@rambler.ru"))
        customerDao.insert(Customer(3, "Jeremy Ward", "6230 Kenwood Circle", "jward2@skyrock.com"))

        var customerLocal = customerDao.findByCustomerId(1)
        println(customerLocal)

        customerLocal.address = "Jalan Klambir 5"
        customerDao.update(customerLocal)
        customerLocal = customerDao.findByCustomerId(1)
        println(customerLocal)

        customerDao.delete(2)
        println("Customer ID 2 has been deleted")
    }
}
