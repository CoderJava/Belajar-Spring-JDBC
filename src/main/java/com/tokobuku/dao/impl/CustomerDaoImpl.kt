package com.tokobuku.dao.impl

import com.tokobuku.dao.CustomerDao
import com.tokobuku.model.Customer

import javax.sql.DataSource
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CustomerDaoImpl : CustomerDao {

    private var dataSource: DataSource? = null

    fun setDataSource(dataSource: DataSource) {
        this.dataSource = dataSource
    }

    override fun insert(customer: Customer) {
        val sql = "INSERT INTO CUSTOMER " +
                "(cust_id, full_name, address, email) " +
                "VALUES " +
                "(?, ?, ?, ?)"
        var connection: Connection? = null

        try {
            connection = dataSource!!.connection
            val preparedStatement = connection!!.prepareStatement(sql)
            preparedStatement.setInt(1, customer.custId)
            preparedStatement.setString(2, customer.fullName)
            preparedStatement.setString(3, customer.address)
            preparedStatement.setString(4, customer.email)
            preparedStatement.executeUpdate()
            preparedStatement.close()
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            if (connection != null) {
                try {
                    connection.close()
                } catch (e: SQLException) {
                    e.printStackTrace()
                }

            }
        }
    }

    override fun findByCustomerId(custId: Int): Customer? {
        val sql = "SELECT * FROM CUSTOMER " +
                "WHERE " +
                "cust_id = ?"
        var connection: Connection? = null
        try {
            connection = dataSource!!.connection
            val preparedStatement = connection!!.prepareStatement(sql)
            preparedStatement.setInt(1, custId)
            var customer: Customer? = null
            val resultSet = preparedStatement.executeQuery()
            if (resultSet.next()) {
                customer = Customer(
                        resultSet.getInt("cust_id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("address"),
                        resultSet.getString("email")
                )
                resultSet.close()
                preparedStatement.close()
                return customer
            }
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            if (connection != null) {
                try {
                    connection.close()
                } catch (e: SQLException) {
                    e.printStackTrace()
                }

            }
        }
        return null
    }

    override fun update(customer: Customer) {
        val sql = "UPDATE CUSTOMER " +
                "SET " +
                "full_name = ?, address = ?, email = ? " +
                "where " +
                "cust_id = ?"
        var connection: Connection? = null

        try {
            connection = dataSource!!.connection
            val preparedStatement = connection!!.prepareStatement(sql)
            preparedStatement.setString(1, customer.fullName)
            preparedStatement.setString(2, customer.address)
            preparedStatement.setString(3, customer.email)
            preparedStatement.setInt(4, customer.custId)
            preparedStatement.executeUpdate()
            preparedStatement.close()
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            if (connection != null) {
                try {
                    connection.close()
                } catch (e: SQLException) {
                    e.printStackTrace()
                }

            }
        }
    }

    override fun delete(custId: Int) {
        val sql = "DELETE FROM CUSTOMER WHERE cust_id = ?"
        var connection: Connection? = null

        try {
            connection = dataSource!!.connection
            val preparedStatement = connection!!.prepareStatement(sql)
            preparedStatement.setInt(1, custId)
            preparedStatement.executeUpdate()
            preparedStatement.close()
        } catch (e: SQLException) {
            throw RuntimeException(e)
        } finally {
            if (connection != null) {
                try {
                    connection.close()
                } catch (e: SQLException) {
                    e.printStackTrace()
                }

            }
        }
    }
}
