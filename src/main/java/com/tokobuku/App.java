package com.tokobuku;

import com.tokobuku.dao.CustomerDao;
import com.tokobuku.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Main.xml");
        CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
        customerDao.insert(new Customer(1, "Russel Banks", "5160 Haas Junction", "rbanks0@seesa.net"));
        customerDao.insert(new Customer(2, "Tina Peters", "0023 Mandrake Pass", "tpeters1@rambler.ru"));
        customerDao.insert(new Customer(3, "Jeremy Ward", "6230 Kenwood Circle", "jward2@skyrock.com"));

        Customer customerLocal = customerDao.findByCustomerId(1);
        System.out.println(customerLocal);
    }
}
