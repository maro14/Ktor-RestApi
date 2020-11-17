package com.example.route

import com.example.model.Customer
import com.example.model.Response
import com.example.repository.CustomerRepo
import io.ktor.application.*
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*


fun Route.customer(customerRepo: CustomerRepo) {
    route("/customer") {
        get {
            call.respond(HttpStatusCode.OK, customerRepo.customerList)
        }

        post("/create") {
            val customer = call.receive<Customer>()
            customerRepo.customerList.add(customer)
            call.respond(HttpStatusCode.OK, Response("Created!!"))
        }
    }
}